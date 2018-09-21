package com.company;

import java.io.*;
import java.util.*;

public class ExtractorFaster extends Extractor{

    Set<String> input = new HashSet<>();
    public static HashMap<String, Integer> list = new HashMap<>();
    ArrayList<String> filenames = new ArrayList<>();

    public ExtractorFaster(){

    }

    public void getStringScan(String fileName) throws FileNotFoundException, IOException {
        InputStream infile = new BufferedInputStream(new FileInputStream(fileName));
        Scanner scan = new Scanner(infile, "UTF-8");
        String[] sArray;
        while (scan.hasNextLine()) {
            if (scan.nextLine().equals("")) {
            } else {
                sArray = this.parseS(scan.nextLine());   //Parsing line and inserting into a String array
                this.getData(sArray);
            }
        }
    }


}
