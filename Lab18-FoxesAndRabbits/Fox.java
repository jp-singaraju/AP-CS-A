import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fox extends Animal
{
    /* Characteristics shared by all foxes (static fields). */

    private static final int    BREEDING_AGE = 10;
    private static final int    MAX_AGE = 20;
    private static final double BREEDING_PROBABILITY = 0.17;
    private static final int    MAX_LITTER_SIZE = 4;
    private static final int    RABBIT_FOOD_VALUE = 8;

    private int foodLevel;

    /**
     * Create a fox. A fox is created as a new born (age zero
     * and not hungry).
     */
    public Fox(Field field, Location location)
    {
        super(field, location);
        this.foodLevel = Fox.RABBIT_FOOD_VALUE;
    }

    /**
     * This is what the fox does most of the time: it hunts for rabbits. 
     * In the process, it might breed, die of hunger, or die of old age.
     */
    public void act()
    {
        incrementHunger();
        if (isActive() == false) {
            return;
        }
        
        incrementAge();
        if (isActive() == false) {
            return;
        }

        int births = breed();

        for (int i = 0; i < births; i++) {
            Location otherLoc = getField().freeAdjacentLocation(getLocation());
            if (otherLoc != null) {
                getField().place(new Fox(getField(), otherLoc), otherLoc);
            }
        }

        Location newLoc = findFood();
        Location newLoc2 = getField().freeAdjacentLocation(getLocation());
        if (newLoc != null) {
            getField().move(getLocation(), newLoc);
            setLocation(newLoc);
        } else if (newLoc2 != null) {
            getField().move(getLocation(), newLoc2);
            setLocation(newLoc2);
        } else {
            setDead();
        }
    }

    /**
     * Increase the age. This could result in the fox's death.
     */
    private void incrementAge()
    {
        if (getAge() < Fox.MAX_AGE) {
            setAge(1);
        } else {
            setDead();
        }
    }

    /**
     * Make this fox more hungry. This could result in the fox's death.
     */
    private void incrementHunger()
    {
        if (this.foodLevel > 0) {
            this.foodLevel--;
        } else {
            setDead();
        }
    }

    /**
     * Tell the fox to look for rabbits adjacent to its current location.
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood()
    {
        List<Location> adjacentLocations = getField().adjacentLocations(getLocation());

        for (Location where : adjacentLocations) //look for Rabbits in adjacent locations
        {
            Object animal = getField().getObjectAt(where);

            if (animal instanceof Rabbit) { //if this object is a rabbit...
                Rabbit rabbit = (Rabbit) animal;

                rabbit.setDead();

                this.foodLevel = Fox.RABBIT_FOOD_VALUE; //Foxes goes back to full

                return where;
            }
        }
        return null;
    }

    /**
     * Generate a number representing the number of births, if it can breed.
     * @return The number of births (may be zero).
     */
    private int breed()
    {
        Random rand = new Random();
        if (canBreed() && rand.nextDouble() < Fox.BREEDING_PROBABILITY) {
            return (int) (rand.nextDouble() * Fox.MAX_LITTER_SIZE);
        }
        return 0;
    }

    /**
     * A fox can breed if it has reached breeding age.
     */
    private boolean canBreed()
    {
        if (getAge() >= Fox.BREEDING_AGE) {
            return true;
        }
        return false;
    }
}
