package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

public class Main {

    ExtractorFaster ex = new ExtractorFaster();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        // write your code here

        Thread task3 = new Thread(new ExtractorThreaded( "C:\\Users\\tim-b\\Desktop\\aLargeFile.txt" ));
        task3.start();

        /*for (Map.Entry<String, Integer> r : ex.list.entrySet()) {
            String key = r.getKey();
            Integer value = r.getValue();
            System.out.println(key + " is found " + value + " times");
        }*/
    }

    public void firstTask() throws FileNotFoundException{
        System.out.println("Task has started " + new java.util.Date(System.currentTimeMillis()));
        ex.getString("C:\\Users\\tim-b\\Desktop\\aLargeFile.txt");
        System.out.println("Task Completed at " + new java.util.Date(System.currentTimeMillis()));
    }

    public void secondTask() throws IOException{
        Date start = new java.util.Date( System.currentTimeMillis() );
        System.out.println( "Task has started " + new java.util.Date( System.currentTimeMillis() ) );
        ex.getStringScan( "C:\\Users\\tim-b\\Desktop\\aLargeFile.txt" );
        Date end = new java.util.Date( System.currentTimeMillis() );
        System.out.println( "Task Completed at " + new java.util.Date( System.currentTimeMillis() ) );
        System.out.println( "=========================================\n" +
                "          THE THREE TOP WORDS ARE        \n" +
                "=========================================");
        for (int i = 0; i < 3; i++) {
            ex.analyse();
            ex.printTopThree();
        }
    }
}
