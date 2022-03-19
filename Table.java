import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Table {
    Player p1;
    Player dealer;
    ArrayList<Card> deck = new ArrayList<>();
    String[] suits = new String[]{"Spades", "Diamonds", "Hearts", "Clubs"};
    Random rand = new Random();
    
    
    public Table(String p1){
        this.p1 = new Player(p1);
        this.dealer = new Player("Dealer");
        initDeck();
    }

    //helper method
    private void drawCard(Player p){
        int cardIndex = rand.nextInt(deck.size());
        Card card = deck.get(cardIndex);
        p.addCard(card);
        deck.remove(cardIndex);
        if (deck.size() < 15){
            initDeck();
        }
    }
    
    private void initDeck(){
        for (int s = 0; s < 4; s++){
            for (int j = 0; j < 4; j++){
                for (int i = 1; i <= 13; i++){
                        deck.add(new Card(i, suits[j]));
                }
            }
        }
    }

    public void startGame(){
        drawCard(p1);
        drawCard(dealer);
        drawCard(p1);
        p1.displayCards();
        dealer.displayCards();
        drawCard(dealer);
    }

    public void play(Player p){
        System.out.println("what would " + p.getName() + " like to do? (hit/stay)");
        Scanner scan = new Scanner(System.in);
        String move = scan.next();
        while(p.getScore() < 21 && !move.equals("stay")){
            while (!move.equals("hit") && !move.equals("stay")){
                System.out.println("must input either hit or stay");
                move = scan.next();
            }
            if (move.equals("stay")){
                break;
            }
            drawCard(p);
            p.displayCards();
        }

        scan.close();
    }

    private void dealerPlay(){
        while(dealer.getScore() < 17){
            drawCard(dealer);
        }
    }

    public void checkWin(Player p1, Player p2){
        if (p1.getScore() > p2.getScore()){
            System.out.println(p1 + "wins!");
        }
        else System.out.println(p2 + "wins!");
    }

    //used to test
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Input player name:");
        String name = scan.nextLine();
        Table table = new Table(name);
        table.startGame();
        table.play(table.p1);
        table.dealerPlay();
        table.checkWin(table.p1, table.dealer);
        scan.close();
    }    
}
