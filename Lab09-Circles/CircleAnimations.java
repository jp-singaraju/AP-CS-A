import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircleAnimations
{
    private ArrayList<Circle> circles; //the circles to animate
    private int size; //canvas width and height (will be square)
    private Random rng; //use to make random numbers

    /** create a drawing pane of a particular size */
    public CircleAnimations(int s) {
        circles = new ArrayList<>();
        size = s;
        rng = new Random();

        //don't mess with this
        StdDraw.setCanvasSize(size, size); //set up drawing canvas
        StdDraw.setXscale(0, size); //<0, 0> is bottom left.  <size-1, size-1> is top right
        StdDraw.setYscale(0, size);
    }

    public void drawCircles() {
        for (Circle circle : circles) {
            circle.draw();
        }
    }

    public void addCircles() {
        addCircles(3);
    }

    public void addCircles(int numCircles) {
        for (int i = 0; i < numCircles; i++) {
            int radius = rng.nextInt(26) + 5; //radius 5 - 30
            Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
            Circle circle = new Circle(rng.nextInt(size - (2 * radius) - 2) + radius + 1, rng.nextInt(size - (2 * radius) - 2) + radius + 1, radius, color);
            //from (radius + 1) to (size - radius - 1) so not on boundary
            circle.setXY();
            circles.add(circle);
        }
        drawCircles();
    }

    public void noOverlapping(int numbers) {
        for (int index = 0; index < numbers; index++) {
            int radius = rng.nextInt(26) + 5; //radius 5 - 30
            Color color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
            Circle circle = new Circle(rng.nextInt(size + 1), rng.nextInt(size + 1), radius, color);
            while (circle.overlaps(circles) == true) {
                radius = rng.nextInt(26) + 5;
                color = new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
                circle = new Circle(rng.nextInt(size - (2 * radius) - 2) + radius + 1, rng.nextInt(size - (2 * radius) - 2) + radius + 1, radius, color);
            }
            circle.draw();
            circles.add(circle);
        }
    }

    public void movingCircles(int numCircles) {
        addCircles(numCircles);
        while (true) {
            for (Circle circle : circles) {
                circle.draw();
                circle.update();
            }
            StdDraw.show(10);
            StdDraw.clear();
        }
    }

    public void removeClicked(int numCircles) {
        addCircles(numCircles);
        while (circles.size() > 0) {
            checkCircle();
        }
    }

    public void checkCircle() {
        double mouseX;
        double mouseY;
        if (StdDraw.isMousePressed()) {
            mouseX = StdDraw.mouseX();
            mouseY = StdDraw.mouseY();
            for (int i = 0; i < circles.size(); i++) {
                if (circles.get(i).isPressed(mouseX, mouseY)) {
                    circles.remove(i);
                    i--;
                    StdDraw.clear();
                    drawCircles();
                }
            }
        }
    }
}
