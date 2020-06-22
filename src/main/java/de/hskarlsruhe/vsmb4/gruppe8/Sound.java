package de.hskarlsruhe.vsmb4.gruppe8;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class Sound extends Controller {

private static Clip clip;


        public Sound(String fileName) {
            // specify the sound to play
            // (assuming the sound can be played by the audio system)
            // from a wave File
            try {
                File file = new File(fileName);
                if (file.exists()) {
                    AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                    // load the sound into memory (a Clip)
                    clip = AudioSystem.getClip();
                    clip.open(sound);
                }
                else {
                    throw new RuntimeException("Sound: file not found: " + fileName);
                }
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Sound: Malformed URL: " + e);
            }
            catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
                throw new RuntimeException("Sound: Unsupported Audio File: " + e);
            }
            catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Sound: Input/Output Error: " + e);
            }
            catch (LineUnavailableException e) {
                e.printStackTrace();
                throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
            }


        }
        public static void play(){
            clip.setFramePosition(0);  // Must always rewind!
            clip.start();
        }
        public static void loop(){
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        public static void stop(){
            clip.stop();
            clip.close();
        }
    }

  /*  void Sound(String musiclocation) {


        try {
            File musicPath = new File(musiclocation);

            if (musicPath.exists()) {

                AudioInputStream audioImput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioImput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);


                // JOptionPane.showMessageDialog(null,"press ok to stop");

            } else {
                System.out.println("cant find file");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } */









