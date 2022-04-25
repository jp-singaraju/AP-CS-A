import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import java.util.*;

/**
 * A class that represents a picture made up of a rectangle of {@link Pixel}s
 */
public class Picture {

    /** The 2D array of pixels that comprise this picture */
    private Pixel[][] pixels;

    /**
     * Creates a Picture from an image file in the "images" directory
     * @param picture The name of the file to load
     */
    public Picture(String picture) {
        File file = new File("./images/"+picture);
        BufferedImage image;
        if (!file.exists()) throw new RuntimeException("No picture at the location "+file.getPath()+"!");
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        pixels = new Pixel[image.getHeight()][image.getWidth()];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                int rgb = image.getRGB(x, y);
                /*
                 * For the curious - BufferedImage saves an image's RGB info into a hexadecimal integer
                 * The below extracts the individual values using bit-shifting and bit-wise ANDing with all 1's
                 */
                pixels[y][x] = new Pixel((rgb>>16)&0xff, (rgb>>8)&0xff, rgb&0xff);
            }
        }
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param red The red value of the color
     * @param green The green value of the color
     * @param blue The blue value of the color
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int red, int green, int blue, int height, int width) {
        pixels = new Pixel[height][width];
        for (int y = 0; y<pixels.length; y++) {
            for (int x = 0; x<pixels[y].length; x++) {
                pixels[y][x] = new Pixel(red, green, blue);
            }
        }
    }

    /**
     * Creates a solid white Picture of a given width and height
     * @param color The {@link Color} of the Picture
     * @param height The height of the Picture
     * @param width The width of the Picture
     */
    public Picture(int height, int width) {
        this(Color.WHITE, height, width);
    }

    /**
     * Creates a solid-color Picture of a given color, width, and height
     * @param color The {@link Color} of the Picture
     * @param width The width of the Picture
     * @param height The height of the Picture
     */
    public Picture(Color color, int height, int width) {
        this(color.getRed(), color.getGreen(), color.getBlue(), height, width);
    }

    /**
     * Creates a Picture based off of an existing {@link Pixel} 2D array
     * @param pixels A rectangular 2D array of {@link Pixel}s. Must be at least 1x1
     */
    public Picture(Pixel[][] pixels) {
        if (pixels.length==0 || pixels[0].length==0) throw new RuntimeException("Can't have an empty image!");
        int width = pixels[0].length;
        for (int i = 0; i<pixels.length; i++) if (pixels[i].length!=width)
                throw new RuntimeException("Pictures must be rectangles. pixels[0].length!=pixels["+i+"].length!");
        this.pixels = new Pixel[pixels.length][width];
        for (int i = 0; i<pixels.length; i++) {
            for (int j = 0; j<pixels[i].length; j++) {
                this.pixels[i][j] = new Pixel(pixels[i][j].getColor());
            }
        }
    }

    /**
     * Creates a Picture based off of an existing Picture
     * @param picture The Picture to copy
     */
    public Picture(Picture picture) {
        this(picture.pixels);
    }

    /**
     * Gets the width of the Picture
     * @return The width of the Picture
     */
    public int getWidth() {
        return pixels[0].length;
    }

    /**
     * Gets the height of the Picture
     * @return The height of the Picture
     */
    public int getHeight() {
        return pixels.length;
    }

    /**
     * Gets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @return The {@link Pixel} at the given location
     */
    public Pixel getPixel(int x, int y) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        return pixels[y][x];
    }

    /**
     * Sets the {@link Pixel} at a given coordinate
     * @param x The x location of the {@link Pixel}
     * @param y The y location of the {@link Pixel}
     * @param pixel The new {@link Pixel}
     */
    public void setPixel(int x, int y, Pixel pixel) {
        if (x>=getWidth() || y>=getHeight() || x<0 || y<0) throw new RuntimeException("No pixel at ("+x+", "+y+")");
        if (pixel==null) throw new NullPointerException("Pixel is null"); //guard is required because pixel's value isn't used in this method
        pixels[y][x] = pixel;
    }

    /**
     * Opens a {@link PictureViewer} to view this Picture
     * @return the {@link PictureViewer} viewing the Picture
     */
    public PictureViewer view() {
        return new PictureViewer(this);
    }

    /**
     * Save the image on disk as a JPEG
     * Call programmatically on a Picture object, it will prompt you to choose a save location
     * In the save dialogue window, specify the file AND extension (e.g. "lilies.jpg")
     * Extension must be .jpg as ImageIO is expecting to write a jpeg
     */
    public void save()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch(Exception e) {
            e.printStackTrace();
        }

        BufferedImage image = new BufferedImage(this.pixels[0].length, this.pixels.length, BufferedImage.TYPE_INT_RGB);

        for (int r = 0; r < this.pixels.length; r++)
            for (int c = 0; c < this.pixels[0].length; c++)
                image.setRGB(c, r, this.pixels[r][c].getColor().getRGB());

        //user's Desktop will be default directory location
        JFileChooser chooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");

        chooser.setDialogTitle("Select picture save location / file name");

        File file = null;

        int choice = chooser.showSaveDialog(null);

        if (choice == JFileChooser.APPROVE_OPTION)
            file = chooser.getSelectedFile();

        //append extension if user didn't read save instructions
        if (!file.getName().endsWith(".jpg") && !file.getName().endsWith(".JPG") && !file.getName().endsWith(".jpeg") && !file.getName().endsWith(".JPEG"))
            file = new File(file.getAbsolutePath() + ".jpg");

        try {
            ImageIO.write(image, "jpg", file);
            System.out.println("File created at " + file.getAbsolutePath());
        }
        catch (IOException e) {
            System.out.println("Can't write to location: " + file.toString());
        }
        catch (NullPointerException|IllegalArgumentException e) {
            System.out.println("Invalid directory choice");
        }
    }

    /********************************************************
     *************** STUDENT METHODS BELOW ******************
     ********************************************************/

    /** remove all blue tint from a picture */
    public void zeroBlue()
    {
        int width = getWidth();
        int height = getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[y][x].setBlue(0);
            }
        }
    }

    /** remove everything BUT blue tint from a picture */
    public void keepOnlyBlue()
    {
        int width = getWidth();
        int height = getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[y][x].setRed(0);
                pixels[y][x].setGreen(0);
            }
        }
    }

    /** invert a picture's colors */
    public void negate()
    {
        int width = getWidth();
        int height = getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[y][x].setRed((255 - pixels[y][x].getRed()));
                pixels[y][x].setGreen((255 - pixels[y][x].getGreen()));
                pixels[y][x].setBlue((255 - pixels[y][x].getBlue()));
            }
        }
    }

    /** simulate the over-exposure of a picture in film processing */
    public void solarize(int threshold)
    {
        int width = getWidth();
        int height = getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (pixels[y][x].getRed() < threshold) {
                    pixels[y][x].setRed((255 - pixels[y][x].getRed()));
                }

                if (pixels[y][x].getGreen() < threshold) {
                    pixels[y][x].setGreen((255 - pixels[y][x].getGreen()));
                }

                if (pixels[y][x].getBlue() < threshold) {
                    pixels[y][x].setBlue((255 - pixels[y][x].getBlue()));
                }
            }
        }
    }

    /** convert an image to grayscale */
    public void grayscale()
    {
        int width = getWidth();
        int height = getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int sum = pixels[y][x].getRed() + pixels[y][x].getGreen() + pixels[y][x].getBlue();
                int value = (int)(sum / (double) 3);

                pixels[y][x].setRed(value);
                pixels[y][x].setGreen(value);
                pixels[y][x].setBlue(value);
            }
        }
    }

    /** change the tint of the picture by the supplied coefficients */
    public void tint(double red, double blue, double green)
    {
        int width = getWidth();
        int height = getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double redVal = pixels[y][x].getRed() * red;
                double greenVal = pixels[y][x].getGreen() * green;
                double blueVal = pixels[y][x].getBlue() * blue;

                if (redVal > 255) {
                    pixels[y][x].setRed(255);
                } else {
                    pixels[y][x].setRed((int) redVal);
                }

                if (greenVal > 255) {
                    pixels[y][x].setGreen(255);
                } else {
                    pixels[y][x].setGreen((int) greenVal);
                }

                if (blueVal > 255) {
                    pixels[y][x].setBlue(255);
                } else {
                    pixels[y][x].setBlue((int) blueVal);
                }
            }
        }
    }

    /** reduces the number of colors in an image to create a "graphic poster" effect */
    public void posterize(int span)
    {
        int width = getWidth();
        int height = getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[y][x].setRed((int) (pixels[y][x].getRed() / span) * span);
                pixels[y][x].setGreen((int) (pixels[y][x].getGreen() / span) * span);
                pixels[y][x].setBlue((int) (pixels[y][x].getBlue() / span) * span);
            }
        }
    }

    /** mirror an image about a vertical midline, left to right */
    public void mirrorVertical()
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < width / 2; c++)
            {
                leftPixel  = pixels[r][c];
                rightPixel = pixels[r][(width - 1) - c];

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** mirror about a vertical midline, right to left */
    public void mirrorRightToLeft()
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < pixels.length; r++)
        {
            for (int c = 0; c < width / 2; c++)
            {
                rightPixel  = pixels[r][c];
                leftPixel = pixels[r][(width - 1) - c];

                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** mirror about a horizontal midline, top to bottom */
    public void mirrorHorizontal()
    {
        Pixel topPixel  = null;
        Pixel bottomPixel = null;

        int height = pixels.length;

        for (int r = 0; r < height / 2; r++)
        {
            for (int c = 0; c < pixels[0].length; c++)
            {
                topPixel  = pixels[r][c];
                bottomPixel = pixels[(height - 1) - r][c];

                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /** flip an image upside down about its bottom edge */
    public void verticalFlip()
    {
        Pixel topPixel  = null;
        Pixel bottomPixel = null;
        Color temp = null;

        int height = pixels.length;

        for (int r = 0; r < height / 2; r++)
        {
            for (int c = 0; c < pixels[0].length; c++)
            {
                topPixel  = pixels[r][c];
                bottomPixel = pixels[(height - 1) - r][c];
                temp = pixels[r][c].getColor();

                topPixel.setColor(bottomPixel.getColor());
                bottomPixel.setColor(temp);
            }
        }
    }

    /** fix roof on greek temple */
    public void fixRoof()
    {
        Pixel leftPixel  = null;
        Pixel rightPixel = null;

        int width = pixels[0].length;

        for (int r = 0; r < 100; r++)
        {
            for (int c = 15; c < width / 2; c++)
            {
                rightPixel  = pixels[r][c];
                leftPixel = pixels[r][(width - 15) - c];

                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /** detect and mark edges in an image */
    public void edgeDetection(int dist)
    {
        int width = getWidth();
        int height = getHeight();

        //combination of both left to right and top to bottom
        for (int y = 0; y < height - 1; y++) {
            for (int x = 0; x < width - 1; x++) {
                double hVal = pixels[y][x].colorDistance(pixels[y + 1][x].getColor());
                double wVal = pixels[y][x].colorDistance(pixels[y][x + 1].getColor());
                if (hVal > dist || wVal > dist) {
                    pixels[y][x].setColor(Color.BLACK);
                } else {
                    pixels[y][x].setColor(Color.WHITE);
                }
            }
        }
    }

    /** copy another picture's pixels into this picture, if a color is within dist of param Color */
    public void chromakey(Picture other, Color color, int dist)
    {
        int width = getWidth();
        int height = getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double val = pixels[y][x].colorDistance(color);
                if (val < dist) {
                    pixels[y][x] = other.pixels[y][x];
                }
            }
        }
    }

    /** steganography encode (hide the message in msg in this picture) */
    public void encode(Picture msg)
    {
        int width = getWidth();
        int height = getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (pixels[y][x].getRed() % 2 != 0) {
                    pixels[y][x].setRed(pixels[y][x].getRed() - 1);
                }
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double val = msg.pixels[y][x].colorDistance(Color.BLACK);
                if (val < 50) {
                    pixels[y][x].setRed(pixels[y][x].getRed() + 1);
                }
            }
        }
    }

    /** steganography decode (return a new Picture containing the message hidden in this picture) */
    public Picture decode()
    {
        Picture msg = new Picture(getHeight(), getWidth());

        int width = msg.getWidth();
        int height = msg.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (pixels[y][x].getRed() % 2 != 0) {
                    msg.pixels[y][x].setColor(Color.BLACK);
                }
            }
        }
        return msg;
    }

    /** perform a simple blur using the colors of neighboring pixels */
    public Picture simpleBlur()
    {
        Picture update = new Picture(getHeight(), getWidth());

        int width = update.getWidth();
        int height = update.getHeight();

        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                int redAverage = pixels[y][x].getRed();
                redAverage += pixels[y][x + 1].getRed();
                redAverage += pixels[y][x - 1].getRed();
                redAverage += pixels[y + 1][x].getRed();
                redAverage += pixels[y - 1][x].getRed();
                redAverage = (int) ((double) redAverage / 5);
                int blueAverage = pixels[y][x].getBlue();
                blueAverage += pixels[y][x + 1].getBlue();
                blueAverage += pixels[y][x - 1].getBlue();
                blueAverage += pixels[y + 1][x].getBlue();
                blueAverage += pixels[y - 1][x].getBlue();
                blueAverage = (int) ((double) blueAverage / 5);
                int greenAverage = pixels[y][x].getGreen();
                greenAverage += pixels[y][x + 1].getGreen();
                greenAverage += pixels[y][x - 1].getGreen();
                greenAverage += pixels[y + 1][x].getGreen();
                greenAverage += pixels[y - 1][x].getGreen();
                greenAverage = (int) ((double) greenAverage / 5);
                update.pixels[y][x].setColor(redAverage, greenAverage, blueAverage);
            }
        }

        return update;
    }

    /** perform a blur using the colors of pixels within radius of current pixel */
    public Picture blur(int radius)
    {
        Picture update = new Picture(getHeight(), getWidth());

        int width = update.getWidth();
        int height = update.getHeight();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double redAverage = 0;
                double greenAverage = 0;
                double blueAverage = 0;
                for (int i = y - radius; i < y + radius + 1; i++) {
                    for (int j = x - radius; j < x + radius + 1; j++) {
                        if (i >= 0 && i < height && j >= 0 && j < width) {
                            Pixel pixel = pixels[i][j];
                            redAverage += pixel.getRed();
                            greenAverage += pixel.getGreen();
                            blueAverage += pixel.getBlue();
                        }
                    }
                }
                redAverage /= Math.pow(radius * 2 + 1, 2);
                greenAverage /= Math.pow(radius * 2 + 1, 2);
                blueAverage /= Math.pow(radius * 2 + 1, 2);
                update.pixels[y][x].setColor((int) redAverage, (int) greenAverage, (int) blueAverage);
            }
        }
        return update;
    }

    /**
     * Simulate looking at an image through a pane of glass
     * @param dist the "radius" of the neighboring pixels to use
     * @return a new Picture with the glass filter applied
     */
    public Picture glassFilter(int dist) 
    {
        int width = getWidth();
        int height = getHeight();

        Picture newPic = new Picture(height, width);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel pixel = pixels[y][x];
                int xPos = x;
                int yPos = y;
                int xNeighbor = randomNum(xPos - dist, xPos + dist);
                int yNeighbor = randomNum(yPos - dist, yPos + dist);
                
                if (yNeighbor >= 0 && yNeighbor < height && xNeighbor >= 0 && xNeighbor < width) {
                    pixels[y][x].setColor(pixels[yNeighbor][xNeighbor].getColor());
                } else{
                    int xNP = 0;
                    int yNP = 0;
                    if (yNeighbor < 0) {
                        yNP = height - dist;
                    } else if (yNeighbor > height) {
                        yNP = dist;
                    }
                    if (xNeighbor < 0) {
                        xNP = width - dist;
                    } else if (xNeighbor > width) {
                        xNP = dist;
                    }
                    pixels[y][x].setColor(pixels[yNP][xNP].getColor());
                }
            }
        }
        newPic.pixels = pixels;
        return newPic;
    }

    public int randomNum(int low, int high) {
        Random random = new Random();
        int rand = low + random.nextInt((high - low) + 1);
        return rand;
    }
}
