import java.lang.*;
import java.util.Arrays;
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
    public static int distribute(int[] arr,int k){
        Arrays.sort(arr); // Sorts the array in ascending order
        int minDist=arr[k-1]-arr[0]; //init min dist of 0 to k
        System.out.println("minDist="+minDist);
        int currDist;
        for(int st=0;st<arr.length;st++){
            currDist=0;
            if((st+k)<arr.length){ //prevents st+k from exceding arr.length
                for(int end=st;end<st+k;end++){  //current start + k
                    System.out.print(arr[end]+" "); //print window
                }
                System.out.println();
                currDist=arr[st+k]-arr[st]; //arr[st+k] = end arr[st] = current start
                currDist=arr[st+k-1]-arr[st]; //[st+k] But this is off by one. make [st+k-1]
                System.out.println("currDist="+currDist);
                minDist=Math.min(currDist,minDist);
            }
        }
        /*
        Arrays.sort(arr); // Step 1
        Time Complexity: O(n log n)
        Sorting the array of n elements.

        Inner Loops:
        The outer loop runs up to n times, but the inner logic (window of size k) only runs when st + k < n → so it runs (n - k) times effectively.
        The inner loop prints k elements → takes O(k) time per iteration.

        | Part               | Time Complexity                |
        | ------------------ | ------------------------------ |
        | Sorting            | `O(n log n)`                   |
        | Outer + Inner Loop | `O((n - k) * k)`               |
        | Total              | **`O(n log n + (n - k) * k)`** |

        Final Time Complexity
        O(n log n + (n - k) * k)
        If k is small compared to n, the total complexity approaches O(n log n).
        If k is close to n, it could approach O(n^2).
        */
        //System.out.println("minDist="+minDist);
        return minDist;
    }
    public static void main(String[] args){
        int[] pack={7, 3, 2, 4, 9, 12, 56};
        int m = 3;//number of students
        System.out.println("min diff="+Cdp.distribute(pack, m));       
    }
}

/*
notes:

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

sorting array in ascending order:
Arrays.sort() — 
for Arrays Part of Java's utility library, 
not a Collection class, 
but often used in collection-related tasks.
usage : Arrays.sort(arrayToSort) //Sorts the array in ascending order

To find the difference between the maximum and minimum number:
1.as the input is a sorted array
2.get the start and end of the window
3.find the distance on number line (arr[end] - arr[st])
4.compare the distances.
*/