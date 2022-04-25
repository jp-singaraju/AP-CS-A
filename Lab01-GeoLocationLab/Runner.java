import java.util.*;

public class Runner
{
    public static void main(String[] args)
    {
        GeoLocation geo = new GeoLocation(33.123961, -96.798735);
        Place adminBuilding = new Place("Frisco ISD Admin Building", "5515 Ohio Dr, Frisco, TX 75035", geo);
        Place mySchool = new Place("Independece High School", "10555 Independence Pkwy, Frisco, TX 75035", 33.1644746, -96.753769);
        
        //Print admin building info
        System.out.println(adminBuilding.toString());
        System.out.println();
        
        //Print my school info
        System.out.println(mySchool.toString());
        System.out.println();
        
        //Print the distance between them
        System.out.println("Distance apart: ~ " + adminBuilding.distanceTo(mySchool) + " miles");
    }
}