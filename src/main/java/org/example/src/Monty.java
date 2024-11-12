package org.example.src;

import org.example.src.logger.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Monty {
    private Logger log = new Logger();
    private int switchWins = 0;
    private int stayWins = 0;
    private Random gen = new Random();
    private Map<Integer, String> result = new HashMap<>();

    public void start(){
        int[] doors;
        int choice;
        int shown; //дверь, которую показали
        for(int plays = 0; plays < 1000; plays++ ){
            doors = new int[]{0, 0, 0};
            doors[gen.nextInt(3)] = 1;
            choice = gen.nextInt(3); //выбор рандомной двери
            do {
                shown = gen.nextInt(3);
            } while (doors[shown] == 1 || shown == choice);

            if (doors[choice] == 0){
                saveResultStep(plays, "Staying wins");
            } else {
                saveResultStep(plays, "Switching wins");
            }
            stayWins += doors[choice];
            switchWins += doors[3 - choice - shown];
        }
        showStatistics();
        saveToLog();
    }

    private void showStatistics(){
        System.out.println("Switching wins " + switchWins + " times.");
        System.out.println("Staying wins " + stayWins + " times.");
    }

    private void saveToLog(){
        for (Map.Entry<Integer, String> entry : result.entrySet()){
            log.save(entry.getKey() + " step: " + entry.getValue());
        }
    }

    private void saveResultStep(Integer step, String res){
        result.put(step, res);
    }
}
