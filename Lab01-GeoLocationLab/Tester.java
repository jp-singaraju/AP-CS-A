import java.util.*;

public class Tester
{
    public static void main(String[] args)
    {
        //3
        System.out.println("Hello again, world!");
        
        //4
        // This is a comment
        
        //5
        int numApples = 17;
        
        //6
        final int PRICE_OF_APPLES = 4;
        
        //7
        System.out.println("The total for " + numApples + " apples:\n" + (numApples * PRICE_OF_APPLES) + " cents");
        
        //8
        if((numApples * PRICE_OF_APPLES) >= 2000)
            System.out.println("Thank you valued customer!");
            
        //9
        for(int n = 15; n > 0; n--)
        {
            System.out.print(n + " ");
        }
        System.out.println();
        
        //10
        for(int n = 150; n <= 300; n += 3)
        {
            System.out.print(n + " ");
        }
        System.out.println();
        
        //11
        int sum = 0;
        for(int n = 0; n <= 100; n++)
        {
            sum += n;
        }
        System.out.println("Sum of first 100 numbers is: " + sum);
        
        //12 = silence
        
        //13
        Scanner console = new Scanner(System.in);
        
        //14
        System.out.println("Enter a double value: ");
        double num = console.nextDouble();
        
        //15
        System.out.println(Math.sqrt(num));
        
        //16
        System.out.println(num + "^3 = " + Math.pow(num, 3));
        
        //17
        System.out.println("Enter an integer: ");
        int num1 = console.nextInt();
        System.out.println("Enter another integer: ");
        int num2 = console.nextInt();
        if(num1 >= (num2 - 10) && num1 <= (num2 + 10))
            System.out.println("Within 10");
        else
            System.out.println("Not within 10");
            
        //18
        int total = 0;
        int count = 0;
        int user = -1;
        while(user != 0)
        {
            System.out.println("Enter a number to sum, 0 to quit: ");
            user = console.nextInt();
            total += user;
            if(user != 0)
            {
                count++;
            }
        }
        System.out.println("Average: " + (total/(double)count));
        
        //19
        double[] areas = new double[20];
        
        //20
        areas[0] = 4.56;
        
        //21
        int length = areas.length;
        
        //22
        boolean[] isBool = {true, true, false, false, true};
        
        //23 = Tombstone
        
        //24
        simpleMethod();
        
        //25
        System.out.println("Sum: " + sum(4, 5));
        
        //26
        int n = 20;
        System.out.println("Sum 3/5 multiples to " + n + ": " + sumToN(n));
        
        //27
        triangle(8);
        
        //28
        System.out.println(altCaps("singaraju"));
        
        //29 = DONE
        
        //30 = DONE
        
        //31
        Player player1 = new Player("Pranav Singaraju", 17);
        Player player2 = new Player();
        System.out.println(player1.playerInfo());
        System.out.println(player2.playerInfo());
    }
    
    public static void simpleMethod()
    {
        System.out.println("This is a method!");
    }
    
    public static int sum(int a, int b)
    {
        return a + b;
    }
    
    public static int sumToN(int n)
    {
        int sum = 0;
        for(int i = 0; i <= n; i++)
        {
            if(i % 3 == 0 || i % 5 == 0)
            {
                sum++;
            }
        }
        return sum;
    }
    
    public static void triangle(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    
    public static String altCaps(String s)
    {
        String word = "";
        for(int index = 0; index < s.length(); index++)
        {
            if(index % 2 != 0)
            {
                word += s.substring(index, index + 1).toUpperCase();
            }
            else
            {
                word += s.substring(index, index + 1);
            }
        }
        return word;
    }
}