package org.example.src.logger;

import java.io.FileWriter;

public class Logger implements Repository<String> {
    private static final String LOG_PATH = "src/main/resources/files/history.txt";

    @Override
    public void save(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
