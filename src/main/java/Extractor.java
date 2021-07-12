package main.java;

import java.io.*;

public class Extractor {

    private static final String ONE_LINE_COORD_LIST_OUTPUT_FILE_PATH = "C:\\Users\\James\\Documents\\Projects\\TWCoordExtractor\\src\\main\\resources\\output\\outputOneLine.txt";
    private static final String MULTIPLE_LINES_COORD_LIST_OUTPUT_FILE_PATH = "C:\\Users\\James\\Documents\\Projects\\TWCoordExtractor\\src\\main\\resources\\output\\outputMultipleLines.txt";
    private static final String INPUT_FILE_PATH = "C:\\Users\\James\\Documents\\Projects\\TWCoordExtractor\\src\\main\\resources\\input\\input.txt";

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_PATH))) {
            String strCurrentLine;
            StringBuilder coordListOneLine = new StringBuilder();
            StringBuilder coordListMultipleLines = new StringBuilder();

            while ((strCurrentLine = br.readLine()) != null) {
                String[] splitString = strCurrentLine.split(" ");

                for (String s : splitString) {
                    if (s.matches(".*\\d{3}\\|\\d{3}.*")) {
                        s = s.replace("(", "");
                        s = s.replace(")", "");
                        coordListOneLine.append(s).append(", ");
                        coordListMultipleLines.append(s).append(", ").append("\n");
                    }
                }
            }

            writeCoordListToFile(coordListOneLine, ONE_LINE_COORD_LIST_OUTPUT_FILE_PATH);
            writeCoordListToFile(coordListMultipleLines, MULTIPLE_LINES_COORD_LIST_OUTPUT_FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeCoordListToFile(StringBuilder coordListOneLine, String s2) throws IOException {
        if (coordListOneLine.length() != 0) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(s2));
            writer.write(coordListOneLine.toString());

            writer.close();
        }
    }
}
