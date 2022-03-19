package Blackjack;

/**
 * This class represents the cards used at the table.
 *
 * @author Brian Wang and Jonathan Leibovich
 * @version 1.0
 * @since 2022-03-18
 */
public class Card {
    boolean faceCard = false;
    int number;
    String suit; 
    String royal;
    String[] royalFaces = new String[]{"Jack", "Queen", "King"};

    /**
     * @param number value of the card
     * @param suit suit of the card
     */
    public Card(int number, String suit){
        this.number = number;
        this.suit = suit;
        this.royal = null;
        if (number > 10){
            this.number = 10;
            faceCard = true;
            this.royal = royalFaces[number - 11];
        }
        if (number == 1){
            this.number = 11;
        }
    }

    /**
     * Returns the value of the card
     *
     * @return value of the card
     */
    public int getNum(){
        return this.number;
    }




    public void setNum(int num){
        this.number = num;
    }

    /**
     * Returns the suit of the card
     *
     * @return suit of the card
     */
    public String getSuit(){
        return this.suit;
    }

    /**
     * If the card is a face card, it will return the face
     *
     * @return King, Queen, or Jack based on the card
     */
    public String getFace(){
        return this.royal;
    }

    /**
     * Returns whether this card is a face card
     *
     * @return If this card is a face card
     */
    public boolean isFace(){
        return this.faceCard;
    }

    /**
     * Returns all the information about a given card
     *
     * @return representation of the card as a string
     */
    @Override
    public String toString() {
        if (faceCard == true){
            return this.royal + " of " + this.suit; 
        }
        return this.number + " of " + this.suit;
    }
}
