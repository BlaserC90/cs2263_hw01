/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.isu.cs2263.hw02;

// eval file written by Chris Blaser
// This file handles the command line inputs from the user

import org.apache.commons.cli.*;

public class eval{

    public static void main(String[] args) {

        // Generate the 3 options needed: help, batch and output
        Options options = new Options();
        options.addOption("h", "help", false, "print this message");
        options.addOption("b", "batch", true, "batch file containing expressions to evaluate");
        options.addOption("o", "output", true, "output file");

        // Header and footer statements for the helpFormatter.
        String header = "Evaluation of simple mathematical expressions\n";
        String footer = "\nCopyright (C) 2022 Chris Blaser";

        //This section handles the 4 options: help, batch, output, and the empty
        if ("-h".equals(args[0]) || "--help".equals(args[0])) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("eval", header, options, footer, true);
            System.exit(0);
        } else if ("-b".equals(args[0]) || "--batch".equals(args[0])) {
            System.out.println("Batch value: lib");

        } else if ("-o".equals(args[0]) || "--output".equals(args[0])) {
            System.out.println("Output value: lib");

        }else{ //if the command line is empty
      //      TODO
        }
    }
}
