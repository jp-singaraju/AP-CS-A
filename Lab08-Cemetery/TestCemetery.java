import java.util.*;
import java.io.*;

public class TestCemetery {
    public static void main(String[] args) throws FileNotFoundException {
        Cemetery cemetery = new Cemetery("cemetery.txt");
        
        double avgAge = 0;
        int count = 0;
        for (Tombstone tomb : cemetery.getList()) {
            if (tomb.getAddress().contains("Little Carter Lane")) {
                double days = tomb.getAge();
                avgAge += (days / 365);
                count++;
            }
        }
        System.out.println("Average Age (years) >>> " + Math.round(avgAge / count * 10) / 10.0);
    }
}