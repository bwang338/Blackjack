# A simple makefile for compiling three java classes
#

# define a makefile variable for the java compiler

JCC = javac

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information

JFLAGS = -g -d

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)

CLASSES = Table.java Card.java Player.java

default: classes

classes:
	$(JCC) $(JFLAGS) ../classes $(CLASSES)

# To start over from scratch, type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
clean: 
	$(RM) ../classes/game/*.class
	rm -r ../classes/game
