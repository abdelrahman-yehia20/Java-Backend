package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

    public void ReadFile(String filePath){
        try{
            File file =new File(filePath);
            Scanner scanner = new Scanner(file);
            if(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        }catch (FileNotFoundException file){
            System.out.println(file.getMessage());
        }

    }
}
