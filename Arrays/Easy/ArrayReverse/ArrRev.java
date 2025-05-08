import java.lang.*;
import java.util.Arrays;
/*
Given an array arr[], the task is to reverse the array. 
Reversing an array means rearranging the elements such that the first element becomes the last, 
the second element becomes second last and so on.
*/
public class ArrRev{
    public static int[] ReverseArray(int[] arr){
        int[] rev=new int[arr.length];
        int j=0;
        for(int i=arr.length-1;i>=0;i--){
            rev[j]=arr[i];
            j++;
        }
        return rev;
    }
    public static void main(String[] args){
        int[] arr={1, 4, 3, 2, 6, 5};
        int[] arr2={4, 5, 1, 2};
        int[] res=new int[arr.length];
        int[] res2=new int[arr2.length];
        res=ArrRev.ReverseArray(arr);
        res2=ArrRev.ReverseArray(arr2);
        System.out.println("reverse array="+(Arrays.toString(res)));
        System.out.println("reverse array="+(Arrays.toString(res2)));
    }
}
//complexity O(n)