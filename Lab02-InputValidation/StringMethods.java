import java.util.*;

public class StringMethods
{
    public StringMethods()
    {
    }

    //6
    public void unusualHello(String name)
    {
        System.out.println("Good day " + name + ", you dummy!");
    }

    //7
    public String stringRipper(String str)
    {
        return (str.substring(0, 1) + str.substring(str.length() - 1, str.length()));
    }

    //8
    public boolean evenFooBar(String s)
    {
        int fooCount = 0;
        int barCount = 0;
        for(int index = 0; index <= s.length() - 3; index++)
        {
            if(s.substring(index, index + 3).equals("foo"))
            {
                fooCount++;
            }
            else if(s.substring(index, index + 3).equals("bar"))
            {
                barCount++;
            }
        }
        if(barCount == fooCount)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //10
    public int sumString(String str)
    {
        Scanner chopper = new Scanner(str);
        int count = 0;
        while(chopper.hasNext())
        {
            chopper.next();
            count++;
        }
        return count - 1;
    }

    //11
    public String decode(String key, String code)
    {
        Scanner chopper = new Scanner(code);
        String output = "";
        int[] codeArr = new int [code.split(" ").length];
        for(int index = 0; index < codeArr.length; index++)
        {
            while(chopper.hasNext())
            {
                codeArr[index] = chopper.nextInt();
                output += key.charAt(codeArr[index]);
            }
        }
        return output;
    }
}
