public class Player {
    String name;
    int score;
    
    public Player(String name){
        this.name = name;
        this.score = 0;
    }

    public int getScore(){
        return this.score;
    }

    public String getName(){
        return this.name;
    }

    public void setScore(int score){
        this.score = score;
    }
}
