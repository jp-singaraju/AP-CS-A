import java.util.*;

public class Tombstone
{
    private String name;
    private String burialDate;
    private int age;
    private String address;

    public Tombstone(String name, String burialDate, int age, String address) {
        this.name = name;
        this.burialDate = burialDate;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String burialDate() {
        return this.burialDate;
    }

    public int getAge() {
        return this.age;
    }

    public String getAddress() {
        return this.address;
    }
}
