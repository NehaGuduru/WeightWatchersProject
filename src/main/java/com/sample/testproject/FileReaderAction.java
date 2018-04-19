package com.sample.testproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileReaderAction {
	
    public static void main(String args[]){
    	String fileName = "words.txt";
        String line = null;
    	try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                StringBuilder output = new StringBuilder(line.split("–")[0]);
                String meanings[] = line.split("–")[1].split(",");
                for(String meaning : meanings){
                	output.append("\n" + meaning.trim());
                }
                System.out.println(output.toString() + "\n");
            }   
            bufferedReader.close();         
        }catch(FileNotFoundException e) {
            System.out.println(e.getMessage() + " Unable to open file '" +fileName + "'");                
        }
    	catch(Exception e) {
            System.out.println(e.getMessage() + " Unable to read file '" +fileName + "'");                
        }
    }
}
