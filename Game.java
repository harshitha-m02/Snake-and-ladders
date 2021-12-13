import java.util.Scanner;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
public class Game {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to snake and ladders game");
    
            System.out.println("Enter the Board Size");
            int boardSize = input.nextInt();
            System.out.println("Enter no of Dice");
            int noOfDices = input.nextInt();
            Dice dice = new Dice(noOfDices);
    
            System.out.println("Enter the no of snakes");
            int noOfSnakes = input.nextInt();
    
            HashMap<Integer, Snakes> snakePositions = new HashMap<Integer, Snakes>();
            for (int i = 0; i < noOfSnakes; i++) {
                String[] snakeInput = input.nextLine().split(" ");
                int start = Integer.parseInt(snakeInput[0]);
                int end = Integer.parseInt(snakeInput[1]);
                Snakes snake = new Snakes(start, end);
                snakePositions.put(start, snake);
            }
            System.out.println("Enter No of Ladders");
            int noOfLadders = input.nextInt();
            HashMap<Integer, Ladders> ladderPositions = new HashMap<Integer, Ladders>();
    
            for (int i = 0; i < noOfLadders; i++) {
                String[] ladderInput = input.nextLine().split(" ");
                int start = Integer.parseInt(ladderInput[0]);
                int end = Integer.parseInt(ladderInput[1]);
                Ladders ladder = new Ladders(start, end);
                ladderPositions.put(start, ladder);
            }
            Queue<Player> playerTurns = new LinkedList<Player>();
            System.out.println("Enter number of players");
            int noOfplayers = input.nextInt();
            System.out.println("Enter Players Name");
            for (int i = 0; i < noOfplayers; i++) {
                String name = input.nextLine();
                Player p = new Player(name);
                playerTurns.add(p);
            }
    
            Board board = new Board(boardSize,playerTurns,dice,snakePositions,ladderPositions);
            board.gameStarts();
    
        }
    }
