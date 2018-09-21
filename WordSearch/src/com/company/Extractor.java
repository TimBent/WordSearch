package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Extractor {

    public static HashMap<String, Integer> list = new HashMap<>();
    public static Map<String, Integer> result;

    public Extractor() {

    }

    /**
     * @param filename
     * @throws FileNotFoundException This method retrieves the lines of text from a text file and inserts the unique values into a HashSet.
     */

    public void getString(String filename) throws FileNotFoundException {
        File file = new File(filename);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufread = new BufferedReader(fileReader);
        String curLine = "";
        try {
            while (bufread.readLine() != null) {
                curLine = bufread.readLine();
                String[] wordsInLine = curLine.split("[^a-zA-Z]+");
                for (String word : wordsInLine) {
                    String curWord = word.toLowerCase();
                    if (!list.containsKey(curWord)) {
                        list.put(curWord, 1);
                    } else {
                        list.replace(curWord, list.get(curWord), list.get(curWord) + 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param filename
     * @throws FileNotFoundException This method retrieves the lines of text from a text file and inserts the unique values into a HashSet.
     */

    protected void getData(String[] sArray) {
        for (String s : sArray) {
            if (list.containsKey(s)) list.replace(s, list.get(s), list.get(s) + 1);
            else list.put(s, 1);
        }
    }

    public void analyse() {
           result = list.entrySet().stream()
                   .collect(Collectors.groupingBy(e -> e.getValue()))
                   .entrySet().stream()
                   .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                   .findFirst()
                   .get().getValue().stream()
                   .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
    }

    public void printTopThree(){
        for (String name: result.keySet()) {
            list.remove( name );
            String value = result.get( name ).toString();
            System.out.println( "       " + name );
        }
    }



    public String[] parseS(String s) {
        //TODO: Find the regex for only numbers and chars
        String nString = s.replaceAll("[^\\p{L}]", "");
        return s.split(" ");
    }

    /*public void splitFiles(String filepath) throws IOException {
        split(filepath, 100000000);
        for (String fp : filenames) {
            getStringScan(fp);
            System.out.println("File " + filepath + " has been checked");
        }
    }

    public void split(String FilePath, long splitlen) {
        long leninfile = 0, leng = 0;
        int count = 1, data;
        try {
            File filename = new File(FilePath);
            String newFileNames = FilePath.split("\\.")[0];
            //RandomAccessFile infile = new RandomAccessFile(filename, "r");
            InputStream infile = new BufferedInputStream(new FileInputStream(filename));
            data = infile.read();
            while (data != -1) {
                filenames.add(newFileNames + count + ".txt");
                System.out.println(newFileNames + count + ".txt");
                filename = new File(newFileNames + count + ".txt");

                //RandomAccessFile outfile = new RandomAccessFile(filename, "rw");
                OutputStream outfile = new BufferedOutputStream(new FileOutputStream(filename));
                while (data != -1 && leng < splitlen) {
                    outfile.write(data);
                    leng++;
                    data = infile.read();
                }
                leninfile += leng;
                leng = 0;
                outfile.close();
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

