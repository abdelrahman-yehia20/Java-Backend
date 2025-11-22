package model;

public class ArrayIndex {

    int[] arr ={1,2,3,4,5};
    public void getValueOfArrayIndex(int index){
        try{
            System.out.println(arr[index]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array Index Out Of Bounds");
        }
    }
}
