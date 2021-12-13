import java.util.Scanner;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
public class Game {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to snake and ladders game");
    
            System.out.println("Enter the Board Size");
            int boardSize = Integer.parseInt(sc.nextLine());
            System.out.println("Enter no of Dice");
            int noOfDices = Integer.parseInt(sc.nextLine());
            Dice dice = new Dice(noOfDices);
    
            System.out.println("Enter the no of snakes");
            int noOfSnakes = Integer.parseInt(sc.nextLine());
    
            HashMap<Integer, Snakes> snakePositions = new HashMap<Integer, Snakes>();
            for (int i = 0; i < noOfSnakes; i++) {
                String[] snakeArray = sc.nextLine().split(" ");
                int start = Integer.parseInt(snakeArray[0]);
                int end = Integer.parseInt(snakeArray[1]);
                Snakes snake = new Snakes(start, end);
                snakePositions.put(start, snake);
            }
            System.out.println("Enter No of Ladders");
            int noOfLadders = Integer.parseInt(sc.nextLine());
            HashMap<Integer, Ladders> ladderPositions = new HashMap<Integer, Ladders>();
    
            for (int i = 0; i < noOfLadders; i++) {
                String[] ladderArray = sc.nextLine().split(" ");
                int start = Integer.parseInt(ladderArray[0]);
                int end = Integer.parseInt(ladderArray[1]);
                Ladders ladder = new Ladders(start, end);
                ladderPositions.put(start, ladder);
            }
    
            // Players input
    
            Queue<Player> playerTurns = new LinkedList<Player>();
    
            System.out.println("Enter number of players");
            int noOfplayers = Integer.parseInt(sc.nextLine());
            System.out.println("Enter Players Name");
            for (int i = 0; i < noOfplayers; i++) {
                String name = sc.nextLine();
                Player p = new Player(name);
                playerTurns.add(p);
            }
    
            Board board = new Board(boardSize);
            board.gameStarts();
    
        }
    }
