import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rabbit extends Animal
{
    /* Characteristics shared by all rabbits (static fields). */

    private static final int    BREEDING_AGE = 5;
    private static final int    MAX_AGE = 15;
    private static final double BREEDING_PROBABILITY = 0.22;
    private static final int    MAX_LITTER_SIZE = 6;

    /**
     * Create a new rabbit. A rabbit is created with age zero (a new born).
     */
    public Rabbit(Field field, Location location)
    {
        super(field, location);
    }

    /**
     * This is what the rabbit does most of the time - it runs 
     * around. Sometimes it will breed or die of old age.
     */
    public void act()
    {
        incrementAge();
        if (isActive() == false) {
            return;
        }

        int births = breed();

        for (int i = 0; i < births; i++) {
            Location otherLoc = getField().freeAdjacentLocation(getLocation());
            if (otherLoc != null) {
                getField().place(new Rabbit(getField(), otherLoc), otherLoc);
            }
        }

        Location newLoc = getField().freeAdjacentLocation(getLocation());
        if (newLoc != null) {
            getField().move(getLocation(), newLoc);
            setLocation(newLoc);
        } else {
            setDead();
        }
    }

    /**
     * Increase the Rabbit's age.
     * This could result in the rabbit's death.
     */
    private void incrementAge()
    {
        if (getAge() < Rabbit.MAX_AGE) {
            setAge(1);
        } else {
            setDead();
        }
    }

    /**
     * Generate a number representing the number of births, if it can breed.
     * @return The number of births (may be zero).
     */
    private int breed()
    {
        Random rand = new Random();
        if (canBreed() && (rand.nextDouble() < Rabbit.BREEDING_PROBABILITY)) {
            return (int) (rand.nextDouble() * Rabbit.MAX_LITTER_SIZE);
        }
        return 0;
    }

    /**
     * A rabbit can breed if it has reached breeding age.
     * @return true if the rabbit can breed, false otherwise.
     */
    private boolean canBreed()
    {
        if (getAge() >= Rabbit.BREEDING_AGE) {
            return true;
        }
        return false;
    }
}
