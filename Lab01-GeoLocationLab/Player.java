import java.util.*;

public class Player
{
    private int number;
    private String name;

    public Player()
    {
       name = "Default";
       number = -1;
    }
    
    public Player(String user, int num)
    {
       name = user;
       number = num;
    }

    String playerInfo()
    {
        return ("Player: " + name + ", #" + number);
    }
}
