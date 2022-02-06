package edu.isu.cs2263.hw02;

/**
 * @author Chris Blaser
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class batchRead extends Calc{

    //@param path is the path to the desired file to be read in
    //This method will read in chosen file, check for some basic formatting
    //and if the check passes proceeds to evaluate and print results
    public void Read(String path){
        try {
            int lineCounter = 1;
            File batch = new File("" + path);
            Scanner reader = new Scanner(batch);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if (check(data)) {
                    eval(data);
                    lineCounter ++;
                }else{
                    System.out.println("Line " + lineCounter + " does not contain proper formatting.");
                    lineCounter ++;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. Make sure you used an actual file.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args){

        }
}
