
import java.util.Random;

public class Dice {
    private int noOfDices;
    public Dice(int noOfDices){
        this.noOfDices = noOfDices;
    }
    public int roll() {
        int min = 1;
		int max = noOfDices*6;
        return new Random().nextInt(max-min+1) + min; 
    }
}
