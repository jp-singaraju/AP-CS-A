import java.util.*;

public class Runner {
    public static void main(String[] args) {
        //2
        SoundLabProbs runner = new SoundLabProbs();
        
        //3
        System.out.println(runner.LastIndexOf(new int[] {8, 2, 4, 6, 8}, 8));
        System.out.println(runner.LastIndexOf(new int[] {2, 4, 6, 12}, 8));
        
        /*4
            > Fill up 3g, pour into 5g, empty out 3g
            > Fill up 3g, pour into 5g, left with 1 in 3g
            > Empty out 5g, pour 1 from 3g into 5g
            > Fill up 3g, pour into 5g, has 4g */
        
        //5
        System.out.println(runner.range(new int[] {8, 3, 5, 7, 2, 4}));
        System.out.println(runner.range(new int[] {15, 22, 8, 19, 31}));
        
        //6
        System.out.println(runner.minDifference(new int[] {4, 8, 6, 1, 5, 9, 4}));
        
        //7
        System.out.println(runner.reverseWords("hello world"));
        System.out.println(runner.reverseWords("the sky is blue"));
        
        //8
        System.out.println(runner.priceIsRight(new int[] {900, 885, 990, 1}, 800));
        System.out.println(runner.priceIsRight(new int[] {1500, 1600, 2000, 2500}, 1900));
        
        //9
        String str = Arrays.toString(runner.productExceptSelf(new int[] {1, 2, 3, 4}));
        System.out.println(str);
        
        //Sound Lab
        //double[] clip = {0.5, 1, 0, -1};
        //Sound.show(clip);
        //Sound.play(clip);
        double[] clip = Sound.pureTone(3.0, 1.0);
        Sound.show(clip);
        Sound.play(clip);
    }
}