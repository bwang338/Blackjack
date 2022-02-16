public class Card {
    
    int number;
    String suit; 

    public Card(int number, String suit){
        this.number = number;
        this.suit = suit;
    }

    public int getNum(){
        return this.number;
    }

    public String getSuit(){
        return this.suit;
    }
}
