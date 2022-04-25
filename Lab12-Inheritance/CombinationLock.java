import java.util.*;

public class CombinationLock extends Lock {
    private String combination;
    
    public CombinationLock() {
        super();
        this.combination = "";
    }
    
    public CombinationLock(String combination) {
        super();
        this.combination = combination;
    }

    public String toString() {
        return super.toString() + "\n" + "Combination = " + combination + "\n";
    }

    public void open() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter combination --> ");
        String combination = scanner.nextLine();
        if (this.combination.equals(combination)) {
            super.open();
        }
    }
    
    public void setCombination(String combination) {
        this.combination = combination;
    }
    
    public String getCombination() {
        return this.combination;
    }
}