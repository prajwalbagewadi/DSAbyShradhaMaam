public class Solution{
    public static void rotate(int[][] matrix) {
        for(int[] row:matrix){
            for(int e:row){
                System.out.print(e+" ");
            }
            System.out.println();
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix.length;j++){
                //j=i+1 as to not swap [0][1] again with [1][0]
                matrix[i][j]=matrix[i][j]^matrix[j][i];
                matrix[j][i]=matrix[i][j]^matrix[j][i];
                matrix[i][j]=matrix[i][j]^matrix[j][i];
            }
        }
       
        for(int i=0;i<matrix.length;i++){
            int scol=0,ecol=matrix.length-1;
            while(scol<ecol){
                // if(scol==ecol){
                //     break;
                // }
                matrix[i][scol]=matrix[i][scol]^matrix[i][ecol];
                matrix[i][ecol]=matrix[i][scol]^matrix[i][ecol]; 
                matrix[i][scol]=matrix[i][scol]^matrix[i][ecol];
                scol++;
                ecol--;
            }
        }
        for(int[] row:matrix){
            for(int e:row){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // 1 2 3   
        // 4 5 6   
        // 7 8 9  
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        rotate(matrix2);
    }
}
/*
 * algorithm/Pseudocode :
 * 1.(Transpose the matrix)
 * for each row 0 to n
 *      for each col=row+1 to n
 *          swap(matrix[row][col],matrix[col][row])
 * 2. (swap columns)
 *      for each row=0 to n
 *          init startcol=0 and endcol=matrix.length-1
 *              while(scol<ecol)
 *                  swap(matrix[row][startcol],matrix[row][endcol])
 *                  startcol++
 *                  endcol--
 * 
 * corrected Pseudocode 
 *  1. Transpose the matrix:
    for row = 0 to n - 1
        for col = row + 1 to n - 1
            swap(matrix[row][col], matrix[col][row])            
            
            
    2. Reverse each row (swap columns):
    for row = 0 to n - 1
        startcol = 0
        endcol = n - 1
        while (startcol < endcol)
            swap(matrix[row][startcol], matrix[row][endcol])
            startcol++
            endcol--

*/