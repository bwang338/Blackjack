package game;

import java.util.ArrayList;

public class Player {
    String name;
    int score;
    ArrayList<Card> cards;
    
    public Player(String name){
        this.name = name;
        this.score = 0;
        cards = new ArrayList<>();
    }

    public int getScore(){
        return this.score;
    }

    public String getName(){
        return this.name;
    }

    public void addCard(Card card){
        cards.add(card);
        this.score += card.getNum();
    }

    public void noCards(){
        cards.clear();
    }

    public void displayCards(){
        System.out.println(name + " has:\n");
        for (int i = 0; i < this.cards.size(); i++){
            System.out.println(this.cards.get(i));
        }
        System.out.println(name + "'s score is " + this.score + "\n");
    }
}
