import java.util.*;

public class PrintingFactors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int userNum = scanner.nextInt();
        int count = 0;
        String factorStr = "";

        while (userNum != 0) {
            for (int num = 2; num < userNum; num++) {
                if (userNum % num == 0) {
                    factorStr += (num + " ");
                    count++;
                }
            }
            System.out.println("There are " + count + " factors for this number " + userNum + ": " + factorStr);
            System.out.println();
            System.out.print("Enter a number: ");
            userNum = scanner.nextInt();
            factorStr = "";
            count = 0;
        }
    }
}