import java.util.*;

public class Runner
{
    public static void main(String[] args)
    {
        StringMethods test = new StringMethods();

        //6
        test.unusualHello("Jeff");

        //7
        System.out.println(test.stringRipper("Pranav"));

        //8
        System.out.println(test.evenFooBar("ghfjoofooobarjbarfoo"));

        //10
        System.out.println(test.sumString("Hi 5 there are 2 or 3 numbers in this String"));;

        //11
        System.out.println(test.decode("six perfect quality black jewels amazed the governor", 
                "35 10 10 33 9 24 3 17 41 8 3 20 51 16 38 44 47 32 33 10 19 38 35 28 49"));
        System.out.println(test.decode("hello world", "6 4 0 5 3 7 2"));
    }
}