import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Card> cards;
    
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

    public int getScore(){
        int total = 0;
        for (int i = 0; i < cards.size(); i++){
            total += cards.get(i).getNum();
        }
        return total;
    }

    public String getName(){
        return this.name;
    }

    public void addCard(Card card){
        cards.add(card);
    }

    public void noCards(){
        cards.clear();
    }

    public void displayCards(){
        System.out.println(name + " has:\n");
        for (int i = 0; i < this.cards.size(); i++){
            System.out.println(this.cards.get(i));
        }
        System.out.println(name + "'s score is " + this.getScore() + "\n");
    }
    @Override
    public String toString(){
        return this.name;
    }
}
