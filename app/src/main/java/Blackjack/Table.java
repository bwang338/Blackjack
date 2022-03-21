package Blackjack;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;

/**
 * Here's how I think this file should function
 * main:
 *      Get number of players
 *      for loop:
 *          Get players name
 *          add to arraylist
 *      Start Table
 *      initDeck()
 *      Table.addDealer()
 *      call Play():
 * Play:
 *      While numPlayers > 1:
 *          try:
 *              int array bets = getBets() //Throw error if no more players
 *          catch e:
 *              gameSummary()
 *              quit game
 *          drawDealerCards()
 *          if (Insurance()):
 *              OfferPlayersInsurance()
 *          Display all cards()
 *          hitOrStay()
 *          CheckWinners()
 *          clearCards()
 * getBets:
 *      for p in players:
 *          Ask for bet amount or quit
 *          if quit:
 *              remove player from Players, throw error if no more players? or we can do if anyone quits game ends
 *          draw initial set of cards (by calling different function)
 * DisplayCards:
 *      for p in players:
 *         p.DisplayCards
 * hitOrStay:
 *      for p in players:
 *         While move != stay:
 *              what do you want to do?
 *              if not hit or stay ask again
 *              if hit, add card and display new cards
 *              check bust()
 * CheckWinners:
 *      for p in players
 *          if p.bust or (p.score < dealer.score and !dealer.bust):
 *              p lost x money, new balance is
 *          else
 *              p won x money, new balance is
 * clearCards:
 *      for p in players:
 *          Remove cards, should make everyones score 0
 *      dealer.clearcard
 */

public class Table implements Runnable{
    Player p1;
    Player dealer;
    ArrayList<Card> deck = new ArrayList<>();
    String[] suits = new String[]{"Spades", "Diamonds", "Hearts", "Clubs"};
    Random rand = new Random();
    private Thread thr;

    public void run() {
		try{
			while (true) {
				if (p1.getScore() > 21 && p1.holdAce()){
                    for (int i = 0; i < p1.getCards().size(); i++){
                        if (p1.getCards().get(i).getNum() == 11){
                            p1.getCards().get(i).setNum(1);
                        }
                    }
                }

                if (dealer.getScore() > 21 && dealer.holdAce()){
                    for (int i = 0; i < dealer.getCards().size(); i++){
                        if (dealer.getCards().get(i).getNum() == 11){
                            dealer.getCards().get(i).setNum(1);
                        }
                    }
                }
			}	
		}catch(Exception e) {
		}
	}
    
    public Table(String p1){
        this.p1 = new Player(p1);
        this.dealer = new Player("Dealer");
        initDeck();
        thr = new Thread(this);
        thr.start();
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

    public void play(Player p, Scanner scan){
        String move = "";
        while (!Objects.equals(move, "stay")){
            System.out.println("what would " + p.getName() + " like to do? (hit/stay)");
            move = scan.next();
            while (!Objects.equals(move, "stay") && !Objects.equals(move, "hit")){
                System.out.println("Options are only to hit or stay. What would you like to do?");
                move = scan.next();
            }
            if (move.equals("hit")){
                drawCard(p);
                p.displayCards();
            }
            if (bust(p)){
                break;
            }
        }


    }

    public boolean bust(Player p){
        if (p.getScore() > 21){
            p.bust = true;
            return true;
        }
        return false;
    }

    private void dealerPlay(){
        while(dealer.getScore() < 17){
            drawCard(dealer);
            dealer.displayCards();
            bust(dealer);
        }
    }

    public void clearCards(Player p1, Player p2){
        p1.noCards();
        p2.noCards();
    }

    public void checkWin(Player p1, Player p2){
        if (p1.bust || (p2.getScore() > p1.getScore() && !p2.bust)){
            System.out.println(p2 +  " wins!\n");
        }
        else System.out.println(p1 + " wins!\n");
    }

    //used to test
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Input player name:");
        String name = scan.nextLine();
        Table table = new Table(name);
        while (true){
            table.p1.bust = false;
            table.startGame();
            table.play(table.p1, scan);
            table.dealerPlay();
            table.checkWin(table.p1, table.dealer);
            table.clearCards(table.p1, table.dealer);
        }
//        scan.close();
    }    
}
