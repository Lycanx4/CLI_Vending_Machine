package com.techelevator;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Utility {
    public static final List<String> KEYS = Arrays.asList("$20","$10","$5","$1","Quarter","Dime","Nickel","Penny");
    public static void logToFile(String description) {
        final String LOG_FILE = "Log.txt";
        LocalDateTime localDate = LocalDateTime.now();
        try (FileWriter fileWriter = new FileWriter(LOG_FILE, true);
             PrintWriter writer = new PrintWriter(fileWriter, true)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            String formattedDate = localDate.format(formatter);
            writer.println(formattedDate + " " + description);
        } catch (IOException e) {
            System.out.println("Fail to log data: " + e.getMessage());
        }
    }
    public static void playSound(String path) {
        try {
            File soundFile = new File("src/main/resources/sound/" + path);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }
}
