public class RecursionProbs {
    public static void main(String[] args) {
        System.out.println(numEars(10));
        countdown(5);
        System.out.println();
        System.out.println(factorial(4));
        System.out.println(cheerlead("Go team!", 3));
        System.out.println(pow(2, 5));
        System.out.println(fibonacci(7));
        printPattern(16);
        System.out.println();
        printPattern(10);
        System.out.println();
        System.out.println(countNumA("aaHELLOa"));
        printAtoBbyC(10, 30, 5);
        System.out.println(countOdds(123456));
        System.out.println(sumDigits(128));
    }
    public static int numEars(int bunnies) {
        if (bunnies == 1) {
            return 2;
        } else {
            return 2 + numEars(bunnies - 1);
        }
    }
    public static void countdown(int num) {
        if (num == 0) {
            System.out.print("blastoff!");
        } else {
            System.out.print(num + ", ");
            countdown(num - 1);
        }
    }
    public static int factorial(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }
    public static String cheerlead(String str, int i) {
        if (i == 1) {
            return str;
        } else {
            return str + " " + cheerlead(str, i - 1);
        }
    }
    public static int pow(int base, int exp) {
        if (exp == 0) {
            return 1;
        } else if (exp == 1) {
            return base;
        } else {
            return base * pow(base, exp - 1);
        }
    }
    public static int fibonacci(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1 || num == 2) {
            return 1;
        } else {
            return fibonacci(num - 2) + fibonacci(num - 1);
        }
    }
    public static void printPattern(int num) {
        if (num < 0) {
            System.out.print(num);
        } else {
            System.out.print(num + ", ");
            printPattern(num - 5);
        }
    }
    public static int countNumA(String str) {
        if (str.length() == 0) {
            return 0;
        } else {
            if (str.substring(0, 1).equals("a")) {
                return 1 + countNumA(str.substring(1, str.length()));
            } else {
                return countNumA(str.substring(1, str.length()));
            }
        }
    }
    public static void printAtoBbyC(int a, int b, int c) {
        if(a > b) {
            System.out.println();
        } else {
            System.out.print(a + " ");
            printAtoBbyC(a + c, b, c);
        }
    }
    public static int countOdds(int num) {
        if (num == 0) {
            return 0;
        } else {
            if (num % 2 != 0) {
                return 1 + countOdds(num / 10);
            } else {
                return countOdds(num / 10);
            }
        }   
    }
    public static int sumDigits(int num) {
        if (num == 0) {
            return 0;
        } else {
            return (num % 10) + sumDigits(num / 10);
        }
    }
}