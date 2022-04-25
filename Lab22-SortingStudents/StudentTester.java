import java.util.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class StudentTester {
    public static void main(String[] args) throws FileNotFoundException {
        List<Student> list = new ArrayList<>();

        Scanner scanner = new Scanner(new File("names.csv"));
        
        Random random = new Random();
        
        while (scanner.hasNext()) {
            int number = random.nextInt(900000) + 100000;
            list.add(new Student(scanner.next(), number));
        }
        
        list.get(0).insertionSort(list);

        System.out.println(list);
        
        System.out.println(indexOf(list, new Student("Lily", 982173)));
    }
    
    public static int indexOf(List<Student> list, Student s) {
        int min = 0;
        int max = list.size() - 1;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (s.compareTo(list.get(mid)) < 0) {
                max = mid - 1;
            } else if (s.compareTo(list.get(mid)) > 0) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
