package test;

public class weilai_02 {
    public int minNumberInRotateArray(int [] array) {
        int index = array.length-1;
        while (index > 0 && array[index] >= array[index-1]){
            index --;
        }
        return array[index];
    }
}
