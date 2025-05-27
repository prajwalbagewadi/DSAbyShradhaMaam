
import java.util.ArrayList;


/*
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

 

Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1
 

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/

public class Solution {
    public static void setZeroes(int[][] matrix) {
        ArrayList<int[]> coor=new ArrayList<>();
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[r].length;c++){
                if(matrix[r][c]==0){
                    coor.add(new int[]{r,c});
                }
            }
        }
        for(int[] c:coor){
            System.out.println("coordinate:"+"r="+c[0]+"c="+c[1]);
            int row=c[0];
            int col=c[1];
            for(int i=0;i<matrix[row].length;i++){
                matrix[row][i]=0;
            }
            for(int i=0;i<matrix.length;i++){
                matrix[i][col]=0;
            }
        }
        for(int[] row:matrix){
            for(int num:row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    // public static void setZeroes(int[][] matrix){
    //     //If matrix[i][0] == 0 or matrix[0][j] == 0, set matrix[i][j] = 0.
    //     for(int row=0;row<matrix.length;row++){
    //         for(int col=0;col<matrix[row].length;col++){
    //             if(matrix[row][0]==0 || matrix[0][col]==0){
    //                 matrix[row][col]=0;
    //             }
    //         }
    //     }
    //     for(int[] row:matrix){
    //         for(int num:row){
    //             System.out.print(num+" ");
    //         }
    //         System.out.println();
    //     }
    // }
    public static void main(String[] args){
        int[][] matrix={{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix2={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix3={{0,1}};
        int[][] matrix4={{0},{1}};
        setZeroes(matrix); 
        setZeroes(matrix2);   
        setZeroes(matrix3);  
        setZeroes(matrix4);   
    }
}
/*Algorithm:
 * create a coordinate ArrayList
 * for row=0 to matrix.len
 * and for col=0 to matrix[row].len
 * check if matrix[row][col]==0 if yes
 * add[row][col] coordinate ArrayList
 * for each element in coordinate ArrayList
 * set row=element[0]
 * set col=element[1]
 * for i=0 to matrix[row].len
 * set matrix[row][i]=0 //row const
 * for i=0 to matrix.len
 * set matrix[i][col]=0 //col const
 * 
 * /* Algorithm:
 * 1. Create a coordinate ArrayList to store positions of zeroes.
 * 2. Loop through the matrix:
 *    - For row = 0 to matrix.length
 *      - For col = 0 to matrix[row].length
 *        - If matrix[row][col] == 0, add [row, col] to the coordinate ArrayList.
 * 3. For each coordinate [row, col] in the ArrayList:
 *    - Set all elements in matrix[row][i] = 0 for i = 0 to matrix[row].length (i.e., set the whole row to zero).
 *    - Set all elements in matrix[i][col] = 0 for i = 0 to matrix.length (i.e., set the whole column to zero).
 */