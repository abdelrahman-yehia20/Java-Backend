package model;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        //--------------------------1-Divide Two Numbers------------------
        DivideByTwo divideByTwo = new DivideByTwo();
        Scanner scanner = new Scanner(System.in);
        System.out.println("plz add first number");
        divideByTwo.setNum1(scanner.nextInt());
        System.out.println("plz add second number");
        divideByTwo.setNum2(scanner.nextInt());
        try {
            System.out.println(divideByTwo.divideTwoInteger(divideByTwo.getNum1(),divideByTwo.getNum2()));
        } catch (ArithmeticException e) {
            System.out.println("number is divided by zero");
        }

    }

        //----------------------------2-Convert String to Integer-----------------------------------------
//        ConvertStringIntoNumber convertStringIntoNumber = new ConvertStringIntoNumber();
//        convertStringIntoNumber.test();

        //-------------------------------3-convert string to upper case --------------------------------------

//        NullPointer nullPointer = new NullPointer();
//        nullPointer.covertStringToUpperCase(null);


//-----------------------------------4-Access array element--------------------------------
//        ArrayIndex arrayIndex = new ArrayIndex();
//        arrayIndex.getValueOfArrayIndex(5);

//-----------------------------------5-Read File---------------------------
//        ReadFile readFile = new ReadFile();
//        readFile.ReadFile("text.xlx");

//-----------------------------------6-MultiCatchBlock------------------------
//        MultipleCatchBlocks multipleCatchBlocks =  new MultipleCatchBlocks();
//        multipleCatchBlocks.multipleCatch();

//----------------------------------7-custom Exception-----------------
//        CustomException customException  = new CustomException();
//        Scanner scanner = new Scanner(System.in);
//        try {
//            System.out.println("plz add your age ");
//            customException.getAge(scanner.nextInt());
//        } catch (AgeException e) {
//            System.out.println(e.getMessage());
//        }

//--------------------------------9-Propagate Exception----------------
//        try {
//            PropagateException propagateException = new PropagateException();
//            propagateException.callingMethod();
//        } catch (Exception e) {
//            System.out.println("Exception Message: " + e.getMessage());
//        }

//------------------------------10-Throws Keyword------------------------------------------------
//        ThrowsKeyword throwsKeyword = new ThrowsKeyword();
//        try {
//            throwsKeyword.readFile("text.exe");
//        } catch (IOException e) {
//            System.out.println("Exception Message: " + e.getMessage());
//        }

//--------------------------------Bonus / Challenging Tasks---------------------------------
//--------------------------------Task 11: Finally Block Demo---------------------------

//        try {
//            System.out.println("case 1 (Exception happened)");
//            int x = 10/0;
//            System.out.println("result " + x);
//        }catch (ArithmeticException e){
//            System.out.println("Exception is happen for case 1");
//        }finally {
//            System.out.println("finally is happened for case 1");
//        }
//
//        try {
//            System.out.println("case 2 (normal case happened)");
//            int y = 10/2;
//            System.out.println("result = " + y);
//        }catch (ArithmeticException e){
//            System.out.println("Exception is happen for case 2");
//        }finally {
//            System.out.println("finally is happened for case 2");
//        }

//---------------------------------Task 12-Nested Try-Catch-----------------------------
//
//        try {
//            try {
//                System.out.println("Nested Try-Catch");
//            int x = 10/0;
//            System.out.println("result " + x);
//            }catch (InputMismatchException e){
//                System.out.println("input mismatch exception");
//            }
//        }catch (ArithmeticException e){
//            System.out.println("result is divided by 0");
//        }

}

