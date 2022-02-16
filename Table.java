import java.util.ArrayList;
import java.util.Random;

public class Table {
    Player p1;
    Player dealer;
    ArrayList<Card> deck = new ArrayList<>();
    String[] suits = new String[]{"Spades, Diamonds, Hearts, Clubs"};
    Random rand = new Random();
    
    public Table(String p1){
        this.p1 = new Player(p1);
        this.dealer = new Player("Dealer");

        for (int j = 0; j < 4; j++){
            for (int i = 1; i <= 13; i++){
                    deck.add(new Card(i, suits[j]));
            }
        }
    }

    public void drawCard(Player p){
        int cardIndex = rand.nextInt(deck.size());
        Card card = deck.get(cardIndex);
        if (card.getNum() < 11){
            p.setScore(p.getScore()+card.getNum());
        }
        else{
            p.setScore(p.getScore() + 10);
        }
        deck.remove(cardIndex);
    }

    public void runGame(){
        while(p1.getScore() <= 21 && dealer.getScore() <= 21){

        }
    }

    public void startGame(){
        for (int i = 0; i < 3; i++){
            if (i % 2 == 0){
                drawCard(p1);
            }
            else{
                drawCard(dealer);
            }
        }
    }
    public static void main(String[] args){
        Table table = new Table("Brian");
    }
    
}
