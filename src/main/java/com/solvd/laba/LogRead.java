package com.solvd.laba;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


import static org.apache.commons.io.FileUtils.writeStringToFile;

public class LogRead {
    public void countUniqueWords(String countUniqueWords) {
        File text = new File("src/main/resources/text.txt");
        try (FileInputStream fis = new FileInputStream(text);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isr)) {

            String content = reader.readLine();
            String[] arr = content.split("[^a-zA-Z]+");
            Set<String> set = new HashSet<>(Arrays.asList(arr));
            writeStringToFile(new File(countUniqueWords), "The number of unique words is:" + set.size());
            System.out.println("Result written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

}
