import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class Board {
    private int no_of_players;
    private Queue<player> players;
    snakes sn = new snakes();
    HashMap<Integer, Integer> snake = sn.getSnakes();
    ladder ld = new ladder();
    HashMap<Integer, Integer> ladder = ld.getLadders();
    private dice Dice;
    private int boardsize = 100;

    Board(int no_of_players, Queue<player> players, dice Dice) {
        this.Dice = Dice;
        this.no_of_players = no_of_players;
        this.players = players;

    }

    public int player_moves(int position, String name, player p, int flag) {
        if (position > 100) {
            System.out.println("The position of " + name + " - " + (p.getPosition()));
        } else if (snake.containsKey(position)) {
            int val = snake.get(position);
            System.out.println("Snake is bitten");
            System.out.println("The position of " + name + " - " + val);
            p.setPosition(val);
        } else if (ladder.containsKey(position)) {
            int val = ladder.get(position);
            System.out.println(" Got Ladder ");
            System.out.println(" The position of " + name + " - " + val);
            p.setPosition(val);
        } else {
            if (position == 100) {
                System.out.println("The " + (no_of_players - players.size()) + "st winner is " + name);
                flag = 1;
            }
            System.out.println("The position of " + name + " is - " + (position));
            p.setPosition(position);
        }

        return flag;
    }


    public void startGame(){
        Scanner input = new Scanner(System.in);
        System.out.println("Game is about to satrt ....");
        while (players.size() > 1) {
            player p = players.poll();
            String name = p.getPlayerName();
            int flag = 0;
            System.out.println(name + " => Type any key to roll the dice");
            String start = input.nextLine();
            int number = Dice.rolldice();
            System.out.println(name + " - got dice_number => " + number);
            int prev = p.getPosition();
            int position = p.getPosition() + number;
            int six_count = 0;
            if (number != 6) {
                flag = player_moves(position, name, p, flag);
            } else {
                do {
                    six_count++;
                    if (six_count == 3) {
                        System.out.println("Oops! yours score  remains same ");
                        flag = player_moves(prev, name, p, flag);
                        break;
                    }

                    else {
                        flag = player_moves(position, name, p, flag);
                        System.out.println("You got an another chance,Type any key to roll the dice");
                        start = input.nextLine();
                        number = Dice.rolldice();
                        System.out.println(name + " - got dice_number => " + number);
                        position = p.getPosition() + number;
                    }
                } while (number == 6);
                if (six_count != 3) {
                    flag = player_moves(position, name, p, flag);
                }
            }
            if (flag != 1) {
                players.add(p);
            }
        }
        System.out.println(players.poll().getPlayerName() + " lose the game");
        System.out.println("Game is over !!");
        }
    }
