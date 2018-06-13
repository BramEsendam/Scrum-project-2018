package javagame;

import java.io.File;
import javax.sound.sampled.*;

public class Sound extends Thread
{

    private Clip clip;

    Sound(String fileName)
    {
        try
        {
            File file = new File(fileName);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Exception e)
        {

        }
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
            }
        }
    }

    public void play()
    {
        clip.setFramePosition(0);
        clip.start();
    }

    public void playBackgroundMusic()
    {
        if (this.isAlive())
        {
            clip.setFramePosition(0);
            clip.start();
            clip.loop(10);
        }
    }

    public void stopMusic()
    {
        clip.stop();
    }
}
