package Blackjack;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    @BeforeAll
    private static void setup() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void jackInitializedCorrectly(){
        Card jack = new Card(11, "Diamond");

        assertEquals(10, jack.getNum());
        assertTrue(jack.isFace());
        assertEquals("Diamond", jack.getSuit());
        assertEquals("Jack", jack.getFace());
        assertEquals("Jack of Diamond", jack.toString());
    }

    @Test
    public void queenInitializedCorrectly(){
        Card queen = new Card(12, "Spade");

        assertEquals(10, queen.getNum());
        assertTrue(queen.isFace());
        assertEquals("Spade", queen.getSuit());
        assertEquals("Queen", queen.getFace());
        assertEquals("Queen of Spade", queen.toString());
    }

    @Test
    public void kingInitializedCorrectly(){
        Card king = new Card(13, "Club");

        assertEquals(10, king.getNum());
        assertTrue(king.isFace());
        assertEquals("Club", king.getSuit());
        assertEquals("King", king.getFace());
        assertEquals("King of Club", king.toString());
    }

    @Test
    public void aceInitializedCorrectly(){
        Card ace = new Card(1, "Club");

        assertEquals(11, ace.getNum());
        assertFalse(ace.isFace());
        assertEquals("Club", ace.getSuit());
        assertEquals("Ace of Club", ace.toString());
        ace.setNum(1);
        assertEquals(1, ace.getNum());

    }

}
