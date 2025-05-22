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