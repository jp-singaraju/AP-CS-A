import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a field containing rabbits and foxes.
 */
public class Simulator
{
    /* Constants representing configuration information for the simulation. */

    private static final int    DEFAULT_HEIGHT = 50; //size of field by default
    private static final int    DEFAULT_WIDTH  = 50; 
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;    

    /* Instance variables */

    private Field field;
    private int   step;

    private SimulatorView view; //graphical view of the Simulator, don't mess with this

    /**
     * Construct a simulation field with default size.
     */
    public Simulator()
    {
        this(Simulator.DEFAULT_HEIGHT, Simulator.DEFAULT_WIDTH);
    }

    /**
     * Create a simulation field with the given size.
     * @param height Depth of the field. Must be greater than zero.
     * @param width Width of the field. Must be greater than zero.
     */
    public Simulator(int height, int width)
    {
        this.step = 0;
        field = new Field(height, width);

        // Create a view of the state of each location in the field, don't mess with this
        view = new SimulatorView(height, width);
        view.setColor(Rabbit.class, Color.orange);
        view.setColor(Fox.class, Color.blue);

        // Setup a valid starting point, don't mess with this
        reset();
    }

    /**
     * Run the simulation from its current state for a reasonably long period,
     * e.g. 500 steps.
     */
    public void runLongSimulation()
    {
        simulate(1000);
    }

    /**
     * Run the simulation from its current state for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     * @param numSteps The number of steps to run for.
     */
    public void simulate(int numSteps)
    {
        for (int step = 1; step <= numSteps && view.isViable(field); step++) {
            simulateOneStep();
        }
    }

    /**
     * Run the simulation from its current state for a single step.
     * Iterate over the whole field updating the state of each
     * fox and rabbit.
     */
    public void simulateOneStep()
    {
        try { Thread.sleep(50); } catch (Exception e) {} // Slow it down a bit, don't remove

        this.step++;

        for (int row = 0; row < field.getHeight(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                Animal animal = field.getObjectAt(row, col);
                if (animal != null) {
                    animal.act();
                }
            }
        }

        view.showStatus(step, field); // Display the new field on screen, don't remove
    }

    /**
     * Reset the simulation to a starting position.
     */
    public void reset()
    {
        step = 0;

        field.clear();

        this.populate();

        // Show the starting state in the view
        view.showStatus(step, field);
    }

    /**
     * Populate a field with foxes and rabbits.
     */
    private void populate()
    {
        Random random = new Random();
        field.clear();

        for (int row = 0; row < field.getHeight(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                if(random.nextDouble() < FOX_CREATION_PROBABILITY) {
                    Animal animal = new Fox(field, new Location(row, col));
                    field.place(animal, row, col);
                } else if (random.nextDouble() < RABBIT_CREATION_PROBABILITY) {
                    Animal animal = new Rabbit(field, new Location(row, col));
                    field.place(animal, row, col);
                }
            }
        }
    }
}