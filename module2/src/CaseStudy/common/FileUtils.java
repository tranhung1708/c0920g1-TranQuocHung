package CaseStudy.common;

import CaseStudy.model.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class FileUtils {
    public static void writeFile(String pathFile, String line, Boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(pathFile,append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> read(String pathFile) {
        List<String> listLine = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(pathFile);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                listLine.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listLine;
    }
    public static void writeFile1(String pathFile, String line, Boolean append) {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(pathFile);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(line);
            bufferedWriter.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
