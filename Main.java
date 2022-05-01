import java.util.Random;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream; 

/** Place a speaker next to your annoying neighbours wall and run this script for some fun!
 * Leigh Hobson 2022
 * */
public class Main {
    public static void main(String[] args) throws Exception {
    
        int i = 0;

        while (i==0) {
        int values[] = randomValue();

        playSoundFile(values[0], values[1]);
        Thread.sleep(values[1]);
        
    }
}

    public static int[] randomValue(){
        
        Random value = new Random();

        int valueWait = value.nextInt(3600000);
        int valueBarkDuration = value.nextInt(300000);

        int[] values = {valueWait,valueBarkDuration};

        return values;

        }

    public static void playSoundFile(int duration, int waitTime) throws Exception {

        String barkFile = "dogwav10min.wav";
        InputStream in = new FileInputStream(barkFile);

        AudioStream audioStream = new AudioStream(in);

    System.out.println("Starting audio, will yap for " + duration/1000 + " seconds...");
        AudioPlayer.player.start(audioStream);
        Thread.sleep(duration);
        System.out.println("Stopping audio, next yapping session in " + waitTime/1000 + " seconds!");
        AudioPlayer.player.stop(audioStream);
  }
}
