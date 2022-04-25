public class SoundClip
{
    double[] clip;

    public SoundClip()
    {
        clip = null;
    }
    
    public SoundClip(double[] value)
    {
        clip = value;
    }
    
    void adjustVolume(double factor) {
        for (int index = 0; index < clip.length; index++) {
            clip[index] *= factor;
        }
    }
    
    void mix(double[] clip1, double[] clip2) {
        for (int i = 0; i < clip1.length; i++) {
            clip[i] = clip1[i] + clip2[i];
        }
    }
    
    void append(double[] other) {
        double[] result = new double[clip.length + other.length];
        int pos = 0;
        for (double element : clip) {
            result[pos] = element;
            pos++; 
        }
        for (double element : other) {
            result[pos] = element;
            pos++; 
        }
        clip = result;
    }
    
    void fadeIn(double seconds) {
        for (int index = 0; index < clip.length; index++) {
            clip[index] /= (double)clip.length;
        }
        // What do we use seconds for?
    }
    
    void fadeOut(double seconds) {
        for (int index = clip.length - 1; index <= 0; index--) {
            clip[index] /= (double)clip.length;
        }
        // The instructions aren't clear, I don't understand what
        // to do for these two methods.
    }
    
    void reverse() {
        double[] arr = new double[clip.length];
        int increment = 0;
        for (int index = clip.length - 1; index >= 0; index--) {
            arr[increment] = clip[index];
            increment++;
        }
        clip = arr;
    }
    
    void speedUp(double factor) {
        for (int index = 0; index < clip.length; index++) {
            clip[index] /= factor;
        }
    }
}
