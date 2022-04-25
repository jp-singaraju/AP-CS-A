import java.util.*;
import java.io.*;

public class Runner
{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("players.txt"));
        Scanner console = new Scanner(System.in);
        
        int p = scanner.nextInt();
        Team indy = new Team(p);
        
        for (int index = 0; index < indy.getPlayers().length; index++) {
            Player player = new Player(scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            indy.getPlayers()[index] = player;
        }
        scanner.close();
        
        indy.printTeamStats();
        
        System.out.println();
        System.out.println("Total people: " + indy.getNumPlayers() + "\n");
        System.out.println("Info for: " + indy.getPlayerInfo(4) + "\n");
        
        System.out.print("Player name? ");
        String name = console.nextLine();
        System.out.print("Player number? ");
        int number = console.nextInt();
        System.out.print("Total number of at-bats? ");
        int atBats = console.nextInt();
        System.out.print("Total number of hits?");
        int hits = console.nextInt();
        Player newP = new Player(name, number, atBats, hits);
        indy.addPlayer(newP, 5);
        System.out.println();
        
        indy.printTeamStats();
    }
}