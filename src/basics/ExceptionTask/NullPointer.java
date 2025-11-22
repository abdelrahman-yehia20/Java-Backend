package model;

public class NullPointer {
    public String covertStringToUpperCase(String text){
        try {
            return text.toUpperCase();
        }catch (NullPointerException e){
            System.out.println("you can't add null value");
            return "";
        }

    }
}
