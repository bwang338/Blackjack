package Blackjack;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
public class PlayerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    private Player p1;
    private Player p2;

    Card ace = new Card(1,"Spade");
    Card king = new Card(5,"Spade");
    Card two = new Card(2,"Spade");
    Card three = new Card(3,"Spade");
    Card queen = new Card(12,"Spade");
    Card jack = new Card(11,"Spade");


    @BeforeClass
    private static void setup() {
        p1 = new Player("Brian");
        p2 = new Player("Max");
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterClass
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void playerHasCorrectName() {
        assertEquals("Brian", p1.getName());
    }

    @Test
    public void playerHoldAce() {

        p1.addCard(ace);
        p1.addCard(king);
        p2.addCard(queen);
        p2.addCard(jack);

        assertTrue(p1.holdAce());
        assertFalse(p2.holdAce());
    }

    @Test
    public void playerGetCards() {
        ArrayList<Card> p1Expected = new ArrayList<>(Arrays.asList(ace, king, two));

        ArrayList<Card> p2Expected = new ArrayList<>(Arrays.asList(three, queen, jack));

        p1.addCard(ace);
        p1.addCard(king);
        p1.addCard(two);
        p2.addCard(three);
        p2.addCard(queen);
        p2.addCard(jack);

        ArrayList<Card> p1Cards = p1.getCards();
        ArrayList<Card> p2Cards = p2.getCards();

        for (int i = 0; i < p1Cards.size(); i++){
            assertEquals(p1Expected.get(i).toString(), p1Cards.get(i).toString());
            assertEquals(p2Expected.get(i).toString(), p2Cards.get(i).toString());
        }
        assertEquals(p1Expected.size(), p1Cards.size());
        assertEquals(p2Expected.size(), p2Cards.size());
    }

    @Test
    public void playerCheckScore() {

        p1.addCard(ace);
        p1.addCard(king);
        p1.addCard(two);
        p2.addCard(three);
        p2.addCard(queen);

        assertEquals(18, p1.getScore());
        assertEquals(13, p2.getScore());

        p1.addCard(new Card(3,"Spade"));
        p2.addCard(new Card(4,"Spade"));

        assertEquals(21, p1.getScore());
        assertEquals(17, p2.getScore());
    }

    @Test
    public void playerClearCards() {
        p1.addCard(ace);
        p1.addCard(king);
        p1.addCard(two);
        p2.addCard(three);
        p2.addCard(queen);

        assertEquals(3, p1.getCards().size());
        assertEquals(2, p2.getCards().size());

        p1.noCards();
        p2.noCards();

        assertEquals(0, p1.getCards().size());
        assertEquals(0, p2.getCards().size());

        p1.addCard(ace);
        p2.addCard(three);
        p2.addCard(queen);
        assertEquals(1, p1.getCards().size());
        assertEquals(2, p2.getCards().size());
    }

    @Test
    public void playerDisplayCards(){
        p1.addCard(ace);
        p1.addCard(three);
        p1.displayCards();
        assertEquals("Brian has:\n" + ace.toString() + three.toString() +
                "Brian's score is 14\n", outContent.toString());
    }
}
