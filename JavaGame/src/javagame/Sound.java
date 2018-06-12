package javagame;

import java.io.File;
import javax.sound.sampled.*;


public class Sound 
{
    private Clip clip; 
    
    public void setFile(String fileName)
    {
        try
        {
            File file = new File(fileName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void play()
    {
        clip.setFramePosition(0);
        clip.start();
    }
}