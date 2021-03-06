package info.doula.concurrency;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Phaser;

/**
 * Mohammed Hossain Doula
 *
 * @hossaindoula | @itconquest
 *
 * skype: mohammedhossaindoularonnie
 *
 * http://hossaindoula.com
 *
 * https://github.com/hossaindoula
 */
public class AdderTask extends Thread {
    private Phaser phaser;
    private String taskName;
    private List<Integer> list;
    private static Random rand = new Random();

    public AdderTask(String taskName, Phaser phaser, List<Integer> list) {
        this.taskName = taskName;
        this.phaser = phaser;
        this.list = list;
    }

    @Override
    public void run() {
        do {
            // Generate a random integer between 1 and 10  
            int num = rand.nextInt(10) + 1;

            System.out.println(taskName + " added " + num);

            // Add the integer to the list  
            list.add(num);

            // Wait for all parties to arrive at the phaser  
            phaser.arriveAndAwaitAdvance();
        } 
        while (!phaser.isTerminated());
    }
}
