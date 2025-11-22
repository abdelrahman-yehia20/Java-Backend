package model;

import java.util.Scanner;

public class MultipleCatchBlocks {

    public void multipleCatch(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("plz add first number");
            int num1 = scanner.nextInt();
            System.out.println("plz add second number");
            int num2 = scanner.nextInt();
            System.out.println(num1/num2);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
