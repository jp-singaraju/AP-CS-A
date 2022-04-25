import java.util.*;

public class Practice2 {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("It");
        words.add("was");
        words.add("a");
        words.add("stormy");
        words.add("night");
        System.out.println(words.toString());

        //Insert
        words.add(3, "dark");
        words.add(4, "and");
        System.out.println(words.toString());

        //Change
        words.set(1, "IS");
        System.out.println(words.toString());

        //Remove
        int index = 0;
        while (index < words.size()) {
            if (words.get(index).contains("a")) {
                words.remove(index);
                index--;
            }
            index++;
        }
        System.out.println(words.toString());
    }
}