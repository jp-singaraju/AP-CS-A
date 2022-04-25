public class Team
{
    private Player[] players;
    
    public Team() {
        players = new Player[12];
    }

    public Team(int numPlayers) {
        players = new Player[numPlayers];
    }
    
    public void printTeamStats() {
        for (int index =  0; index < players.length; index++) {
            System.out.println(getPlayerInfo(index));
        }
    }
    
    public String getPlayerInfo(int index) {
        return players[index].getName() + "\t#" + players[index].getNumber() + "\taverage >>> " + players[index].getBattingAverageString();
    }
    
    public Player[] getPlayers() {
        return players;
    }
    
    public Player getPlayer(int index) {
        return players[index];
    }
    
    public int getNumPlayers() {
        return players.length;
    }
    
    public void addPlayer(Player p, int index) {
        players[index] = p;
    }
}
