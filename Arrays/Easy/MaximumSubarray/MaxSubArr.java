import java.lang.*;
/* 
LeetCode
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
    // public static int largestSum(int[] arr){
    //     //Brute force apporach
    //     int maxSum=Integer.MIN_VALUE;
    //     for(int st=0;st<arr.length;st++){
    //         int currSum=0;
    //         for(int end=0;end<arr.length;end++){
    //             currSum+=arr[end];
    //             maxSum=Math.max(currSum,maxSum);
    //         }
    //     }
    //     return maxSum;
    // }
    //timecomplexity =O(n^2)
    public static int largestSum(int[] nums){
        //Kadane's algorithm apporach
        int maxSum=Integer.MIN_VALUE;
        int currSum=0;
        for(int i:nums){
            currSum+=i;
            maxSum=Math.max(currSum,maxSum);
            if(currSum<0){
                currSum=0;
            }
        }
        return maxSum;
    }
    //timecomplexity =O(n)
    public static void main(String[] args){
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {5,4,-1,7,8};
        int[] nums2 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("MaxSubArraySum="+MaxSubArr.largestSum(nums));
        System.out.println("MaxSubArraySum="+MaxSubArr.largestSum(nums2));
    }
}

/*
//Kadane's Algorithm | Maximum Subarray Sum (notes)
Max subarray sum

1 2 3 4 5

what is sub Array -> continuous part of a given array 

1 2 3 4 5
 
{ {1},{2},{3},{4},{5},   
  {1,2},{2,3},{3,4},{4,5},     All Possible Sub arrays
  {1,2,3},{2,3,4},{3,4,5},
  {1,2,3,4},{2,3,4,5},
  {1,2,3,4,5},      
}

for a given array N the possible sub arrays are (N*(N+1)/2)
if N=5
=5*(5+1)/2
=5*6/2
=30/2 = 15//-

how to print sub arrays -
we need to find start and end points of sub array
eg : 1 2 3 4 5 
       1   3    start=1 end=3
find all possible start and end
start	end(start to n-1)
0        0,1,2,3,4 n-1
1        1,2,3,4  n-1
2        2,3,4
3        3,4
4        4

for(st=0;st<n;st++){
    for(end=st;end<n;end++){
		
    }
}

public static void printSubArray(int[] arr,int size){
        //brute force method to Print Sub Array
        for(int st=0;st<size;st++){
            for(int end=st;end<size;end++){
                for(int i=st;i<=end;i++){
                    System.out.print(arr[i]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

output:
Print Sub Arrays
1 12 123 1234 12345 
2 23 234 2345 
3 34 345 
4 45 
5 


Max SubArray Sum (BruteForce):
{3, -4, 5, 4, -1, 7, -8}

for(int st=0;st<n;st++){
    for(int end=st;end<n;end++){
        for(int i=st;i<=end;i++){ // third loop removed for optimization
            System.out.print(arr[i]);
        }
        System.out.print(" ");
    }
    System.out.println();

}

O(n^3)

Slight optimization: O(n^2)

{3, -4, 5, 4, -1, 7, -8}

1)3 sum=3
2)3+(-4) sum= //optimization add newNum to previous sum
  = previousSum(3) += (-4)
3) previousSum(3,-4) += (5) 

logic:
for(st=0;st<n;st++){
    currSum=0 //add a variable to store current sum.
    for(end=st;end<n;end++){
	    currSum+=arr[end] //add newNum to previous sum, Hence arr[end]
    }
} 

//Dry run.
cs=0 //init
0.cs=0+3=3 end++
1.cs=3+(-4)=-1 end++
2.cs=(-1)+5=4 end++
3.cs=4+4=8 end++
4.cs=8+(-1)=7 end++
5.cs=7+7=14 end++
6.cs=14+(-8) end++
// array end reached currSum reinitialized currSum=0
start increamented. st++

maxSum=0 //store the max sum for each subarray
for(st=0;st<n;st++){
    currSum=0
    for(end=st;end<n;end++){
	    currSum+=arr[end]
	    maxSum=max(currSum,maxSum)
    }
} 
return maxSum; 11:33
*/

/* 
Kadane's Algorithm (optimized solution)     

//intution
3 + 4 = 7 (Positive + Positive)
-5 + (-2) = -7 (Negative + Negative)
5 + (-3) = 2 (Positive + Negative, 5 - 3 = 2, positive because 5 is larger)
*-7 + 2 = -5 (Positive + Negative, 7 - 2 = 5, negative because 7 is larger)

+ve + +ve = +

-ne + -ne(big) = +

+ve(small) + -ne(big) = - //Kadane's algo works on this logic
if 
-ne(small) + -ne(big) = will decrease the value
when ever your sub Array sum becomes (-neg) reset to 0

{3,-4,5,4,-1,7,-8}
 
currSum		maxSum

Kadana's algo says to use a single for loop
and add the elements one by one into currentSum 
and if currSum val = <0(neg)  reset to =0

eg:
cs=0
0.cs=0+3=3
1.cs=3+(-4)=-1 Kadana's algo (you can never add these two numbers bcoz the sum(-1))
	       and if there is any positive val ahead(5)
               MaxSub Array will make the sum smaller

{3,-4,5,4,-1,7,-8}
 -  - st 
skip currSum(3) and -4 reset currSum to =0 and start the fresh new subarray from 5

currSum=0 //init
maxSum=INT_MIN //init Java Integer.MIN_VALUE (-2,147,483,648)
for(i=0;i<n;i++){
    currSum+=arr[i]
    maxSum=max(currSum,maxSum)
    if(currSum<0){
        currSum=0
    }
}

//Dry Run
{3,-4,5,4,-1,7,-8}
cs=0
ms=-infinity

0. cs=0+3=3     ms=3,(-infinity)=3   if(cs<0)false cs=3
1. cs=3+(-4)=-1 ms=-1,(3) ms=3       if(cs<0)true cs=0
2. cs=0+5=5     ms=5,3 ms=5  	     if(cs<0)false cs=5
3. cs=5+4=9     ms=9,5 ms=9          if(cs<0)false cs=9
4. cs=9+(-1)=8  ms=8,9 ms=9          if(cs<0)false cs=8
5. cs=8+7=15    ms=15,9 ms=15        if(cs<0)false cs=15
6. cs=15+(-8)=7 ms=7,15 ms=15        if(cs<0)false cs=7
//end.
ans=ms=15;

//EdgeCase:
the reset condition(if(cs<0)) should be before calculating maxSum=max(currSum,maxSum) or after calculating maxSum.

//visual
for(i=0;i<n;i++){
    currSum+=arr[i]
    -> if(currSum<0){
        currSum=0   // should be here 
    }
    maxSum=max(currSum,maxSum)
    -> if(currSum<0){
        currSum=0  // or. should be here 
    }
}

Edge Case : a array which contains all neg Values {-1,-2,-3,-4,-5}
maxSubArraySum=-neg
so : if we keep the reset condition (if(cs<0)) before calculating maxSum the ans=0 and not get actual neg value.
hence : we keep the reset condition (if(cs<0)) after calculating maxSum.

Time complexity =O(n) linear time
Kadane's algorithm is a type of Dynamic Programming algo
Dynamic Programming algo : is divide big problem into smaller problems and then sol the big problem.
*/
