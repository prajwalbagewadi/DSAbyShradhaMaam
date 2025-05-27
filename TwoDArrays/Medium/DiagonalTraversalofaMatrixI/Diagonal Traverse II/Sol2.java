import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/*
 Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.

Example 1:
image:sample_1_1784.png

Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]

Example 2:
image:sample_2_1784.png

Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i].length <= 105
1 <= sum(nums[i].length) <= 105
1 <= nums[i][j] <= 105
*/
public class Sol2 {
    public static void findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=nums.size()-1;i>=0;i--){ //goes from bottom row to top row
            for(int j=0;j<nums.get(i).size();j++){ //goes left to right in each row
                map.computeIfAbsent(i+j,k->new ArrayList<>()).add(nums.get(i).get(j));
                //map.get(i+j).add(nums.get(i).get(j));
            }
        } 
        System.out.println("forward diagonal from bottom-left to top-right");
        System.out.println(map);
    }
    public static void findDiagonalOrder1(List<List<Integer>> nums) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.size();i++){ //goes from bottom row to top row
            for(int j=0;j<nums.get(i).size();j++){ //goes left to right in each row
                map.computeIfAbsent(i-j,k->new ArrayList<>()).add(nums.get(i).get(j));
                //map.get(i-j).add(nums.get(i).get(j));
            }
        } 
        System.out.println("backward diagonal from top-left to bottom-right");
        List<Integer> unsortedKeys = new ArrayList<>(map.keySet());//collect all keys in a list
        Collections.sort(unsortedKeys); //sort the list in ascending
        for(Integer key:unsortedKeys){
            System.out.print(key+"="+map.get(key)+" ");
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> list2d = new ArrayList<>();
        list2d.add(new ArrayList<>()); //creates a new row
        list2d.get(0).add(1);//add 1 to row 0
        list2d.get(0).add(2);//add 2 to row 0
        list2d.get(0).add(3);//add 3 to row 0
        list2d.add(new ArrayList<>()); //creates a new row
        list2d.get(1).add(4);//add 4 to row 1
        list2d.get(1).add(5);//add 5 to row 1
        list2d.get(1).add(6);//add 6 to row 1
        list2d.add(new ArrayList<>()); //creates a new row
        list2d.get(2).add(7);//add 7 to row 2
        list2d.get(2).add(8);//add 8 to row 2
        list2d.get(2).add(9);//add 9 to row 2
        findDiagonalOrder(list2d);
        findDiagonalOrder1(list2d);
    }
}
/*notes:
 * map.computeIfAbsent(i + j, k -> new ArrayList<>());
 * This line means:
 * “If the map does not already have a list at key i + j, then:
 * Create a new empty list (new ArrayList<>())
 * Put it in the map at key i + j
 * Return that list (whether newly created or already existing)”
 * 
 * formulas:
 * i + j → used to group diagonals from top-right to bottom-left.
 * i - j → used to group diagonals from top-left to bottom-right.
*/

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int maxSum=0; 
        int totalLen=0;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=nums.size()-1;i>=0;i--){
	        for(int j=0;j<nums.get(i).size();j++){
		        map.computeIfAbsent(i+j,k->new ArrayList<>()).add(nums.get(i).get(j));
                totalLen++;
		        maxSum=Math.max(maxSum,i+j);
            }
        }
        int[] ans=new int[totalLen];
        int index=0;
        for(int i=0;i<=maxSum;i++){
            List<Integer> list=map.get(i);
            if(list!=null){
                for(int e:list){
                    ans[index++]=e;
                }
            }
        }
        return ans;
    }
}
/*
 * steps:
 * 1.create two variables to store maxSum of coordinates that can be produced 
 *   and track number of elements for each step
 * 2.create a hashmap <with i+j coordinates as key,and for each key create a list of elements>
 * 2.from last row (for loop)
 * 3.from 0th col (for loop)
 * 4.map.computeIfAbsent(i+j,k->new ArrayList<>()).add(nums.get(i).get(j));
 *   “If the map does not already have a list at key i + j, then:
 *    Create a new empty list (new ArrayList<>())
 *    Put it in the map at key i + j
 *    Return that list (whether newly created or already existing)”
 * 5.add +1 in totalLen
 * 6.find the maxSum
 * 7.create a arr of size(totalLen)
 * 8.create a simple index=0 var
 * 9.for i=0 to i<=maxSum
 * 10.create a list of elements present map.get(i)
 * 11.check if list is not empty 
 * 12.for each element in the list
 * 13.add the element in the array
*/
/*
 time Complexity :
 Sure! Here's the **copy-friendly** version of the complexity analysis:

---

### ✅ Time Complexity:

Let `n` be the number of rows, and let `T` be the total number of elements in all rows:

```
T = sum of nums.get(i).size() for i from 0 to n - 1
```

This loop touches each element once, so the time complexity is:

```
O(T)
```

---

### ✅ Space Complexity:

* The `map` stores each element once in a list: `O(T)`
* The output array `ans[]` also stores `T` elements: `O(T)`
* Variables like `totalLen` and `maxSum` are simple integers: `O(1)`

So overall space complexity is:

```
O(T)
```

---

Let me know if you'd like a Markdown or LaTeX version too.

*/