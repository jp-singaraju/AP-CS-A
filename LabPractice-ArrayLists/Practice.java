import java.util.*;
import java.io.*;

public class Practice {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("words.txt"));
        
        ArrayList<String> words = new ArrayList<String>();
        
        while (reader.hasNext()) {
            words.add(reader.next());
        }
        
        System.out.println(words.toString());
        
        System.out.println(reverseOrder(words).toString());
    }
    
    public static ArrayList<String> reverseOrder(ArrayList<String> list) {
        for (int index = 0; index < list.size() / 2; index++) {
            String word = list.get(index);
            String word2 = list.get(list.size() - 1 - index);
            list.set(list.size() - 1 - index, word);
            list.set(index, word2);
        }
        return list;
    }
}
