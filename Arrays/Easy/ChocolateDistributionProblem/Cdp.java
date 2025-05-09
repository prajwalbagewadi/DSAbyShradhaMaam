import java.lang.*;
/* 
Chocolate Distribution Problem
Given an array arr[] of n integers where arr[i] represents the number of chocolates in ith packet. 
Each packet can have a variable number of chocolates. 
There are m students, the task is to distribute chocolate packets such that: 

1.Each student gets exactly one packet.
2.The difference between the maximum and minimum number of chocolates in the packets 
  given to the students is minimized.

Examples:
Input: arr[] = {7, 3, 2, 4, 9, 12, 56}, m = 3 
Output: 2 
Explanation: If we distribute chocolate packets {3, 2, 4}, we will get the minimum difference, that is 2. 

Input: arr[] = {7, 3, 2, 4, 9, 12, 56}, m = 5 
Output: 7
Explanation: If we distribute chocolate packets {3, 2, 4, 9, 7}, we will get the minimum difference, that is 9 – 2 = 7. 
*/
public class Cdp {
    public static void distribute(int[] arr,int k){
        for(int st=0;st<arr.length;st++){
            if((st+k)<=arr.length){
                for(int end=st;end<st+k;end++){
                    System.out.print(arr[end]+" ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args){
        int[] pack={7, 3, 2, 4, 9, 12, 56};
        Cdp.distribute(pack, 5);
    }
}

/*
Sliding Window :(fixed window size)
A way to print or operate on a portion of array or list, 
and then move that portion(window) forward step by step 
to cover the whole input, 
often used to improve performance in problems involving sequences.

eg: 
array = {1,2,3,4,5}
window size k=3; //fixed size.
for(st=0;st<n;st++){
    if(st+k<=arr.length){ //prevents st+k from exceding arr.length
        for(end=st;end<st+k;end++){ //current start + k
            //prints the window
        }
    }
}
*/