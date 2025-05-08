import java.lang.*;
/* 
Given an integer array nums, 
find the subarray with the largest sum, and return its sum. 
Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
*/

public class MaxSubArr{
    public static void largestSum(int[] arr){
        int subarr=arr.length/2;
        int sum=0,temp=0;
        for(int j=0;j<subarr;j++){
            sum+=arr[j];
        }
        for(int i=0;i<arr.length && i!=arr.length-1 ;i++){
            for(int j=i;j<subarr;j++){
                temp+=arr[j];
            } 
            if(temp>sum){
                sum=temp;
            }
            temp=0;
        }
        System.out.println(sum);
    }
    public static void main(String[] args){
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {5,4,-1,7,8};
        MaxSubArr.largestSum(nums);
    }
}