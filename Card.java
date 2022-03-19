public class Card {
    boolean faceCard = false;
    int number;
    String suit; 
    String royal;
    String[] royalFaces = new String[]{"Jack", "Queen", "King"};

    public Card(int number, String suit){
        this.number = number;
        this.suit = suit;
        this.royal = "";
        if (number > 10){
            this.number = 10;
            faceCard = true;
            this.royal = royalFaces[number - 11];
        }
        if (number == 1){
            this.number = 11;
        }
    }

    public int getNum(){
        return this.number;
    }

    public void setNum(int num){
        this.number = num;
    }

    public String getSuit(){
        return this.suit;
    }

    public String getFace(){
        return this.royal;
    }

    public boolean isFace(){
        return this.faceCard;
    }

    @Override
    public String toString() {
        if (faceCard == true){
            return this.royal + " of " + this.suit; 
        }
        return this.number + " of " + this.suit;
    }
}
