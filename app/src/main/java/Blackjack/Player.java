package Blackjack;

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

    public boolean bust;

    private String name;

    private ArrayList<Card> cards;

    /**
     * Returns the player's name
     *
     * @param name player's name
     */
    public Player(String name){
        this.name = name;
        cards = new ArrayList<>();
    }


    public boolean holdAce(){
        for (int i = 0; i < cards.size(); i++){
            if (cards.get(i).getNum() == 11){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    /**
     * Returns the value of the player's name
     *
     * @return Value of current hand
     */
    public int getScore(){
        int total = 0;
        for (int i = 0; i < cards.size(); i++){
            total += cards.get(i).getNum();
        }
        return total;
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
        System.out.println(name + " has:");
        for (int i = 0; i < this.cards.size(); i++){
            System.out.println(this.cards.get(i));
        }
        System.out.println(name + "'s score is " + this.getScore() + '\n');
    }

    @Override
    public String toString() {
        return this.name;
    }
}
