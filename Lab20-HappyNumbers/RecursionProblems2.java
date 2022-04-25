public class RecursionProblems2 {
    public static void main(String[] args) {
        System.out.println(palindrome("racecar"));
        System.out.println(palindrome("blurg"));

        System.out.println(isPrime(7, 2));
        System.out.println(isPrime(10, 2));

        timesTwo(80);
        timesTwo(68);

        System.out.println(tri(4));
        System.out.println(tri(1));

        System.out.println(penta(4));
        System.out.println(penta(1));

        System.out.println(arraySum(new int[]{1, 2, 3, 4}, 0));

        System.out.println(reverseString("blurg"));
        printReverse("blurg");

        System.out.println(isPowerOfN(9, 3));
        System.out.println(isPowerOfN(25, 3));

        System.out.println(curlyString("what's {all this} then"));

        printPattern2(16);
        System.out.println();

        printSquares(5);
        System.out.println();
        printSquares(8);
        System.out.println();

        System.out.println(wordWrap("hello, how are you doing today?", 13));
    }

    public static boolean palindrome(String str) {
        if (str.length() < 2) {
            return true; 
        } else if (str.substring(0, 1).equals(str.substring(str.length() - 1))) {
            return palindrome(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    }

    public static boolean isPrime(int num, int i) {
        if (Math.pow(i, 2) > num) {
            return true;
        } else if (num <= 2) {
            return false;
        } else if (num % i == 0) {
            return false;
        }else {
            return isPrime(num, i + 1);
        }
    }

    public static void timesTwo(int n) {
        if (n % 2 != 0) {
            System.out.println(n);
        } else {
            System.out.print("2 * ");
            timesTwo(n / 2);
        }
    }

    public static int tri(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + tri(n - 1);
        }
    }

    public static int penta(int n) {
        if (n == 1) {
            return 1;
        } else {
            return ((3 * n) - 2) + penta(n - 1);
        }
    }

    public static int arraySum(int[] arr, int i) {
        if (i == arr.length - 1) {
            return arr[i];
        } else {
            return arr[i] + arraySum(arr, i + 1);
        }
    }

    public static String reverseString(String str) {
        if (str.length() < 2) {
            return str;
        } else {
            return str.substring(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
        }
    }

    public static void printReverse(String str) {
        if (str.length() < 2) {
            System.out.println(str);
        } else {
            System.out.print(str.substring(str.length() - 1));
            printReverse(str.substring(0, str.length() - 1));
        }
    }

    public static boolean isPowerOfN(int num, int base) {
        if (num == base) {
            return true;
        } else {
            if (num > base && num % base == 0) {
                return isPowerOfN(num / base, base);
            } else {
                return false;
            }
        }
    }

    public static String curlyString(String str) {
        if (str.substring(0, 1).equals("{") && str.substring(str.length() - 1).equals("}")) {
            return str;
        } else {
            if (str.substring(0, 1).equals("{") == false) {
                return curlyString(str.substring(1, str.length()));
            } else {
                return curlyString(str.substring(0, str.length() - 1));
            }
        }
    }

    public static void printPattern2(int n) {
        if (n <= 0) {
            System.out.print(n);
        } else {
            System.out.print(n + ", ");
            printPattern2(n - 5);
            System.out.print(", " + n);
        }
    }

    public static void printSquares(int n) {
        if (n == 1) {
            System.out.print(n);
        } else {
            if (n % 2 == 0) {
                printSquares(n - 1);
                System.out.print(", " + n * n);
            } else {
                System.out.print(n * n + ", ");
                printSquares(n - 2);
                System.out.print(", " + (n - 1) * (n - 1));
            }
        }
    }
    
    public static String wordWrap(String str, int width) {
        if (str.length() <= width) {
            return str;
        } else {
            return str.substring(0, str.lastIndexOf(" ", width)) + "\n" + wordWrap(str.substring(str.lastIndexOf(" ", width) + 1), width);
        }
    }
}