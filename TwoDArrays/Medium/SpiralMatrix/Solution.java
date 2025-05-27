
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
        List<Integer> output=new ArrayList<>();
        int srow=0,erow=matrix.length-1;
        int scol=0,ecol=matrix[0].length-1;
        //top boundry
        for(int i=scol;i<=ecol;i++){
            output.add(matrix[srow][i]);
        }
        //right boundry
        for(int i=srow+1;i<=erow;i++){
            output.add(matrix[i][ecol]);
        }
        //bottom boundry
        for(int i=ecol-1;i>=srow;i--){
            output.add(matrix[erow][i]);
        }
        //left boundry
        for(int i=erow-1;i>=srow+1;i--){
            output.add(matrix[i][scol]);
        }
        System.out.println(output);
        return output;
        

    }
    public static void main(String[] args) {
        // 1 2 3 4
        // 5 6 7 8
        // 9 10 11 12
        // 13 14 15 16
        int[][] mat={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
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
 * (3:07)
 * for top and bottom our row is fixed
 * for right and left our col is fixed
 * 
 * srow=0  scol=0
 * erow=m-1 ecol=n-1
 * top boundry for j=scol to ecol
 *                  mat[srow][j]
 * right boundry for j=srow+1 to erow
 *                  mat[j][ecol]
 * bottom boundry for j=ecol-1 to scol
 *                  mat[erow][j]
 * left boundry for j=erow-1 to srow+1
 *                  mat[j][scol]
 * 
 * shift boundries
 * srow=0+1  scol=0+1
 * erow=m-1-1 ecol=n-1-1
 * 
 * steps 
 * 1.find boundries
 * 2.while loop condition (stopping)
 * 3.corner case.
 * (10:40)
*/