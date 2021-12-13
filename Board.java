import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Board {
    private Dice dice;
    private int size;
    private HashMap<Integer, Snakes> snakes; 
    private HashMap<Integer, Ladders> ladders;
    private Queue<Player> playerTurn;

    public Board(int size, Queue<Player> playerTurn,Dice dice,HashMap<Integer, Snakes> snakes,HashMap<Integer, Ladders> ladders) {
        this.dice = dice;
        this.size = size;
        this.snakes = snakes;
        this.ladders = ladders;
        this.playerTurn = playerTurn;
    }

    public int getSize() {
        return size;
    }
    
    public void gameStarts() {
        while (true) {
            Player playerNo = playerTurn.poll();
            int currPosition = playerNo.getLocation();
            int newPosition = currPosition + dice.roll();
            if (newPosition <= size) {
                if (snakes.containsKey(newPosition)) {
                    System.out.println(playerNo.getName() + "oops! bitten by a snake");
                    Snakes snakeObj = snakes.get(newPosition);
                    newPosition = snakeObj.getEndPoint();
                } else if (ladders.containsKey(newPosition)) {
                    System.out.println(playerNo.getName() + "congrats! got a ladder");
                    Ladders ladderObj = ladders.get(newPosition);
                    newPosition = ladderObj.getEndPoint();

                } else {
                    currPosition = newPosition;
                    System.out.println(playerNo.getName() + "rolled a dice moved from " + currPosition + "to " + newPosition);
                }
                if (newPosition == size) {
                    System.out.println(playerNo.getName() + "won the game");
                    break;
                }
                playerNo.setLocation(newPosition);

            }
            playerTurn.add(playerNo);

        }
    }
}
