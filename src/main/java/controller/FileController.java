package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileController {

    public static String readFromFile(final String path) {

        String sCurrentLine;
        String sCurrentLine2 = "";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            while ((sCurrentLine = br.readLine()) != null) {
                sCurrentLine2 += sCurrentLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sCurrentLine2;
    }

    public static void writeToFile(final String path, final String text) {

        try{
            final FileWriter fw = new FileWriter(path);
            fw.write(text);
            fw.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public static String getPath(final String inputStream) {
        return inputStream.substring(7);
    }
}
