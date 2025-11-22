package model;

public class CustomException {
    public void getAge(int  age) throws AgeException {
        if(age<18){
            throw new AgeException("age must be more than 18");
        }else{
            System.out.println("The age is : " + age);
        }
    }
}
