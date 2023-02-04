import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the no of players..");
        int no_of_players = input.nextInt();
        Queue<player> players = new LinkedList<player>();
        for (int i = 0; i < no_of_players; i++) {
            System.out.println("Enter the name of the player " + (i + 1));
            String name = input.next();
            player p = new player(name, 0);
            players.add(p);
        }
        System.out.println("Enter the no of dices....");
        int no_of_dice = input.nextInt();
        dice Dice = new dice(no_of_dice);
        Board b = new Board(no_of_players, players, Dice);
        b.startGame();
         

        input.close();

        
    }
}
