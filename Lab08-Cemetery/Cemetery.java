import java.util.*;
import java.io.*;

public class Cemetery
{
    private ArrayList<Tombstone> list;

    public Cemetery(String filename) throws FileNotFoundException {
        list = new ArrayList<Tombstone> ();
        Scanner reader = new Scanner(new File(filename));

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            Scanner tokenizer = new Scanner(line);
            String name = "";
            String burialDate = "";
            int age = 0;
            String address = "";
            int x = 0;
            while (tokenizer.hasNextInt() == false) {
                name += (tokenizer.next() + " ");
            }
            while (x < 3) {
                burialDate += (tokenizer.next() + " ");
                x++;
            }
            age = parseAge(tokenizer.next());
            address = tokenizer.nextLine();
            list.add(new Tombstone(name.trim(), burialDate.trim(), age, address.trim()));
        }
    }

    public ArrayList<Tombstone> getList() {
        return this.list;
    }

    public static int parseAge(String ageString)
    {
        if (ageString.contains("d")) { //age supplied in days
            ageString = ageString.replaceAll("d", "");
            return Integer.parseInt(ageString);
        }

        int result = 0;

        boolean done = true;

        try { result = Integer.parseInt(ageString); } //is the String a whole number of years?

        catch (NumberFormatException n) { done = false; }

        if (done) //successfully parsed as an int, return value
            return 365 * result; //ignoring leap years

        double ageDouble = 0;

        done = true;

        try { ageDouble = Double.parseDouble(ageString); } //is the String a floating point number of years?

        catch (NumberFormatException n) { done = false; }

        if (done) { //successfully parse as a double, String doesn't contain any text
            return (int)(ageDouble * 365); //ignoring leap years, using 30 for days in a month
        }

        if (ageString.contains("w")) { //age is supplied in weeks, return appropriately
            ageString = ageString.replaceAll("w", "");
            return Integer.parseInt(ageString) * 7;
        }

        return 0;
    }
}
