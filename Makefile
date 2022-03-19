# A simple makefile for compiling three java classes

# define a makefile variable for the java compiler

JCC = javac

rootdir = .

CLASSPATH = $(rootdir)/src:$(rootdir)/tests

sourcelist = $(shell find $(rootdir) -name '*.java' | sed "s,[.]/,,g")

docdir = ./docs

classdir = ./classes


CLASSES = Table.java Card.java Player.java

default: all

all:
	# Compile classes
	@javac -g -cp $(CLASSPATH) -d ./classes $(sourcelist)
	# Compile Javadocs
	@javadoc -d $(docdir) -linksource $(sourcelist)

# To start over from scratch, type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
clean:
	# Remove all of the documentation
	@if [ -d $(docdir) ]; then rm -r $(docdir); fi;
	# Remove all the class files in the classpath
	@-find $(rootdir) \( -name "*~" -o -name "*.class" -o -name "runTests" \) -exec rm '{}' \;
	# Remove Classes directory
	@if [ -d $(classdir) ]; then rm -r $(classdir)/*; fi;

