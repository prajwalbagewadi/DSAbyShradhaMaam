
import java.util.ArrayList;
import java.util.List;
/*
 * Given an m x n matrix, return all elements of the matrix in spiral order.

 

Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        // int top = 0;
        // int bottom = rows - 1;
        // int left = 0;
        // int right = columns - 1
        //top <= bottom && left <= right 
        List<Integer> out=new ArrayList<>();
        int top=0,bottom=matrix.length-1;
        int left=0,right=matrix[0].length-1;
        while(top<=bottom && left<=right){
            //left to right
            for(int i=0;i<=right;i++){
                out.add(matrix[top][i]);
                System.out.println("top:"+top);
            }
            top++;
            System.out.println("top:"+top);
            //top to bottom
            for(int i=0;i<=bottom;i++){
                out.add(matrix[i][bottom]);
                System.out.println("bottom:"+bottom);
            }
            //right to left
            for(int i=right;i>=left;i--){
                out.add(matrix[bottom][i]);
            }
            //bottom to top
            
        }
        System.out.println(out);
        return out;
    }
    public static void main(String[] args) {
        int[][] mat={{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(mat);
    }
}
/* 
 * notes:
 * 1  2  3  4
 * 5  6  7  8    n*m
 * 9  10 11 12
 * 13 14 15 16
 * 
 * top to right
 * 1 2 3 4 
 * top(right) to bottom
 * 8 12 16
 * bottom(right) to left
 * 15 14 13
 * bottom(left) to top
 * 9 5
 * 6 7 10 11
 * 
 * top, right, bottom, left 
 * 
 * we need to cover matrix boundries:
 * top boundry 0[0] to 0[n-1]
 * right boundry n-1[0] to n-1[m-1] 
 * bottom boundry m-1[n-1] to m-1[0]
 * left boundry 0[m-1] to 0[0]
 *  
 * 
*/