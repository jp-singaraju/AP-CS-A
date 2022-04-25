import java.awt.*;

public class PictureTester 
{
    public static void main(String[] args) 
    {
        //construct a Picture object from a jpg image on disk
        Picture beach = new Picture("beach.jpg");
        Picture koala = new Picture("koala.jpg");
        Picture waterlilies = new Picture("waterlilies.jpg"); 
        Picture gorge = new Picture("gorge.jpg");
        Picture cycle = new Picture("redMotorcycle.jpg");
        Picture temple = new Picture("temple.jpg");
        Picture swan = new Picture("swan.jpg");

        //PUT YOUR TESTS HERE
        //beach.zeroBlue();
        //beach.keepOnlyBlue();
        //koala.negate();
        //waterlilies.solarize(127);
        //gorge.grayscale();
        //beach.tint(1.25, 0.75, 1);
        //beach.posterize(63);
        //cycle.mirrorRightToLeft();
        //cycle.mirrorHorizontal();
        //waterlilies.verticalFlip();
        //temple.fixRoof();
        //swan.edgeDetection(25);
        //testChromakey();
        //testSteganography();
        //koala.simpleBlur().view();
        //waterlilies.blur(5).view();
        waterlilies.glassFilter(5).view();
    }

    /** this method is static, you don't need to call it on an object (just "testChromekey()") */
    public static void testChromakey()
    {
        Picture one = new Picture("blue-mark.jpg");
        Picture two = new Picture("moon-surface.jpg");

        one.view(); //show original mustache guy picture
        two.view(); //show the untouched moon's surface pic

        one.chromakey(two, new Color(10, 40, 75), 60); //replace this color if within 60

        one.view();
    }

    /** this method is static, you don't need to call it on an object (just "testSteganography()") */
    public static void testSteganography()
    {
        Picture msg   = new Picture("msg.jpg");
        Picture beach = new Picture("beach.jpg");

        beach.encode(msg); //hide message in beach picture
        beach.view();      //beach w/ hidden message inside, shouldn't look different

        beach.decode().view(); //see the hidden message in the beach picture
    }
}
