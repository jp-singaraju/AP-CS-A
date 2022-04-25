import java.util.*;

public class AddingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int points = 0;
        int incorrect = 0;
        System.out.println("Time to play the Adding Game! Good Luck...");
        System.out.println();

        while (incorrect < 3) {
            int[] questionArray = new int [((int)(Math.random() * 4)) + 2];
            String equ = "";

            for (int index = 0; index < questionArray.length; index++) {
                questionArray[index] = (int)(Math.random() * 11);
                equ += (questionArray[index] + " + ");
            }

            equ = equ.substring(0, equ.length() - 2);
            System.out.print(equ + "= ");
            int input = scanner.nextInt();
            boolean value = addNums(questionArray, input);
            System.out.println();
            
            if (value) {
                points++;
            } else {
                incorrect++;
            }
        }
        
        System.out.println("Game Over! You earned a total of " + points + " points.");
    }

    public static boolean addNums(int[] array, int user) {
        int sum = 0;
        
        for (int index = 0; index < array.length; index++) {
            sum += array[index];
        }
        
        if (sum != user) {
            System.out.println("Wrong! The answer was " + sum);
            return false;
        }
        
        return true;
    }
}