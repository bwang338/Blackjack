package game;

import java.util.ArrayList;

/**
 * This class represents a player playing at the table. A Player has a name and a balance that they can use to bet
 * during the game.
 *
 * @author Brian Wang and Jonathan Leibovich
 * @version 1.0
 * @since 2022-03-18
 */
public class Player {

    String name;

    int score;

    ArrayList<Card> cards;

    /**
     * Returns the player's name
     *
     * @param name player's name
     */
    public Player(String name){
        this.name = name;
        this.score = 0;
        cards = new ArrayList<>();
    }

    /**
     * Returns the value of the player's name
     *
     * @return Value of current hand
     */
    public int getScore(){
        return this.score;
    }

    /**
     * Returns the player's name
     *
     * @return Player's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Adds card to player's hand.
     *
     * @param card Add card to hand for the round
     */
    public void addCard(Card card){
        cards.add(card);
        this.score += card.getNum();
    }

    /**
     * Remove the cards from your hand
     */
    public void noCards(){
        cards.clear();
    }

    /**
     * Display the cards in your hands as well as the cards combined value
     */
    public void displayCards(){
        System.out.println(name + " has:\n");
        for (int i = 0; i < this.cards.size(); i++){
            System.out.println(this.cards.get(i));
        }
        System.out.println(name + "'s score is " + this.score + "\n");
    }
}
