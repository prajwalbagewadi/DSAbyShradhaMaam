
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
        ArrayList<int[]> cord=new ArrayList<>();
        for(int r=0;r<matrix.length;r++){
            for(int c=0;c<matrix[0].length;c++){
                if(matrix[r][c]==0){
                    int temp[]=new int[2];
                    temp[0]=r;
                    temp[1]=c;
                    cord.add(temp);
                }
            }
        }
        for(int[] e:cord){
            System.out.println("coordinate:r:"+e[0]+" coordinate:c:"+e[1]);
            int i=0;
            while(i<matrix.length){
                matrix[e[0]][i]=0; //row const col changes
                i++;
            }
            i=0;    
            while(i<matrix.length){
                matrix[i][e[1]]=0; //row changes col const
                i++;
            }
        }
        for(int[] row:matrix){
            for(int i:row){
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[][] matrix={{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix2={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix); 
        setZeroes(matrix2);      
    }
}
