package com.example.demo.Pr4;

import java.io.*;

public class FileToFileReplacement {

    public static void replaceNumbers(){
        String inputFile = "D:\\maga1kurs\\2 сем\\Управление информацией в процессе разработки программного обеспечения\\pr4\\repoPractice\\src\\main\\java\\com\\example\\demo\\Pr4\\input.txt";
        String outputFile = "D:\\maga1kurs\\2 сем\\Управление информацией в процессе разработки программного обеспечения\\pr4\\repoPractice\\src\\main\\java\\com\\example\\demo\\Pr4\\output.txt";

        try {
            replaceNumbersFiles(inputFile, outputFile);
            System.out.println("Числа успешно заменены!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void replaceNumbersFiles(String inputFile, String outputFile) throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(Converter.replaceNumbers(line));
                writer.newLine();
            }
        }
    }

}
