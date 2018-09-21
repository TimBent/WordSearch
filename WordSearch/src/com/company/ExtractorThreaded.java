package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExtractorThreaded extends ExtractorFaster implements Runnable {

    String filename;

    public ExtractorThreaded(String s) {
        super();
        this.filename = s;
    }

    @Override
    public void getStringScan(String filename) throws IOException {
        super.getStringScan( filename );
    }

    @Override
    protected void getData(String[] sArray) {
        super.getData( sArray );
    }

    @Override
    public void analyse() {
        super.analyse();
    }

    @Override
    public void printTopThree() {
        super.printTopThree();
    }

    @Override
    public void run() {
        //Date start = new java.util.Date( System.currentTimeMillis() );
        System.out.println( "Task has started " + new java.util.Date( System.currentTimeMillis() ) );
        try {
            this.getStringScan( "C:\\Users\\tim-b\\Desktop\\aLargeFile.txt" );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Date end = new java.util.Date( System.currentTimeMillis() );
        System.out.println( "Task Completed at " + new java.util.Date( System.currentTimeMillis() ) );
        System.out.println( "=========================================\n" +
                "          THE THREE TOP WORDS ARE        \n" +
                "=========================================");
        for (int i = 0; i < 3; i++) {
            analyse();
            printTopThree();
        }

    }
}
