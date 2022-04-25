import java.util.*;

public class PrimeFactorization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int userNum = scanner.nextInt();

        while (userNum != 0) {
            String factorStr = "";
            int total = userNum;
            
            while (total != 1) {
                int num = 2;
                while (num <= total) {
                    if (total % num == 0 && isPrime(num)) {
                        factorStr += (num + " x ");
                        total /= num;
                    } else {
                        num++;
                    }
                }
            }
            
            System.out.println("The prime factorization for " + userNum + " is: " + factorStr.substring(0, factorStr.length() - 2));
            System.out.println();
            System.out.print("Enter a number: ");
            userNum = scanner.nextInt();
        }
    }

    public static boolean isPrime(int value) {
        for (int num = 2; num < value; num++) {
            if (value % num == 0 && value != num) {
                return false;
            }
        }
        return true;
    }
}