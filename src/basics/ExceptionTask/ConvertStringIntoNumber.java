package model;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class ConvertStringIntoNumber {
        public void test(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("plz enter a number ");
            String num = scanner.next();
            try{
                Integer.parseInt(num) ;
            }catch (NumberFormatException e){
                System.out.println("plz add number");
            }


        }
}
