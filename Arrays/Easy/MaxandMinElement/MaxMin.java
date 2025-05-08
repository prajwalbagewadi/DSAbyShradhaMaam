import java.lang.*;
//import java.util.*;
//import java.io.*;

/* 
Question Maximum and minimum of an array using minimum number of comparisons
Last Updated : 14 Sep, 2024
Given an array of size N. The task is to find the maximum and the minimum element of the array using the minimum number of comparisons.
*/

public class MaxMin{
   public static int maxi(int[] arr){
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
   }
   public static int mini(int[] arr){
        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return min;
   }
    public static void main(String[] args){
        int[] arr={22, 14, 8, 17, 35, 3};
        int[] arr2={ 4, 9, 6, 5, 2, 3 };
        System.out.println("max Element="+MaxMin.maxi(arr));
        System.out.println("min Element="+MaxMin.mini(arr));
        System.out.println("max Element="+MaxMin.maxi(arr2));
        System.out.println("min Element="+MaxMin.mini(arr2));
    }
}
// Complexity O(n)