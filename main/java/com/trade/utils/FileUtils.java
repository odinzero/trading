package com.trade.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class FileUtils {

    public static void writeToFile(String text) {

        try (FileWriter fw = new FileWriter("./src/main/resources/history/log.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println(text);
            out.close();
        } catch (IOException e) {
            System.out.println("write order to log.txt error: " + e);
        }
    }

    public static void readFromFile(String filePath) {

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {

//                if (!line.equals("")) {
                System.out.println(line);
//                }

                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("read order to log.txt error: " + e);
        }
    }

    public static ArrayList<String> readLinesFromFile(String filePath) {

        ArrayList<String> flines = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {

                if (!line.equals("")) {
                    flines.add(line);
                }
                // read next line
                line = reader.readLine();

                // System.out.println("lines: " + line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("read order to log.txt error: " + e);
        }

        return flines;
    }

    public static String[][] fetchFileDataToTableData(String filePath, int headerNum) {

        String[][] fileRows;
        String[] tlines;

        ArrayList<String> flines = FileUtils.readLinesFromFile(filePath);

        fileRows = new String[flines.size()][headerNum];

        int cntLine = -1;
        for (Iterator<String> iterator = flines.iterator(); iterator.hasNext();) {
            String fline = iterator.next();

            cntLine++;
            //  System.out.println("fline: " + fline);
            // divide line by whitespace
            tlines = fline.split(" ");

            for (int i = cntLine; i < fileRows.length; i++) {
                for (int j = 0; j < tlines.length; j++) {
                    String tcell = tlines[j];

                    fileRows[i][j] = tcell;

                    System.out.println("L: " + fileRows[i][j]);
                }
            }

        }
        return fileRows;
    }

    public static void writeFromTableToFile(String[][] columns) {

        String line = "";
        for (int i = 0; i < columns.length; i++) {
            String[] trow = columns[i];
            for (int j = 0; j < trow.length; j++) {
                String tcell = trow[j];
                line += tcell + " ";

                if (j == trow.length - 1) {
                    FileUtils.writeToFile(line);
                    // System.out.println(line);
                }
            }
            line = "";
        }
    }

    public static void writeFromFileToTable() {

        FileUtils.readLinesFromFile("./src/main/resources/history/log.txt");

    }

    public static void main(String[] args) {

        // FileUtils.writeToFile("-3-");
        // FileUtils.readFromFile("./src/main/resources/history/log.txt");
//        String[][] columns = new String[][]{{"1", "REN/USDT", "-", "-", "(B)", "1.05", "500"},
//        {"2", "REN/USDT", "-", "-", "(B)", "1.08", "600"}};
//
//        FileUtils.writeFromTableToFile(columns);
        //   FileUtils.fetchFileDataToTableData("./src/main/resources/history/log.txt", 7);
    }
}
