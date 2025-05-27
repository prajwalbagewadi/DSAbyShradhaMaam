/*
Given a 2D matrix of size n*m, the tasks is to print all elements of the given matrix in diagonal order.

Example:

Input: mat[][] = [[ 1, 2, 3, 4 ],
                            [5, 6, 7, 8 ],
                            [9, 10, 11, 12],
                           [13, 14, 15, 16],
                          [17, 18, 19, 20]]
Output: 1 5 2 9 6 3 13 10 7 4 17 14 11 8 18 15 12 19 16 20

follow image.

Diagonal-Traversal-of-a-Matrix-2
Using Line by Line Diagonal Traversal - O(n*m) time and O(n*m) space
The idea is to traverse the matrix diagonally from bottom-left to top-right, one diagonal at a time. Since a matrix with R rows and C columns has exactly R+C-1 diagonals,
we iterate through each diagonal line and identify the starting position, number of elements, and the indices of elements belonging to that diagonal, collecting them in sequence to produce the desired diagonal ordering.
*/
public class Dtm{
    public static void main(String[] args) {
        int[][] mat={{1,2,3,4},
                     {5,6,7,8},
                     {9,10,11,12},
                     {13,14,15,16},
                     {17,18,19,20},
                    };
        for(int i=0;i<mat.length-1;i++){ //start 0th row
            int r=i;//row
            int c=0;//col
            while(r>=0){ //runs till row reaches 0th row
                System.out.print(mat[r][c]+",");
                r--;
                c++;
            }
            System.out.println();
        }
        for(int i=1;i<mat[0].length;i++){ //start nth row 1st col
            int r=mat.length-1;//row
            int c=i; //col
            while(c<=mat[0].length-1){ //runs till col reaches col.length-1
                System.out.print(mat[r][c]+",");
                r--;
                c++;
            }
            System.out.println();
        }
    }
    
}

/*
notes:
{1, 2, 3, 4},
{5, 6, 7, 8},
{9,10,11,12},
{13,14,15,16},
{17,18,19,20},

Diagonals:
r:1[0,0]
r:5[1,0],2[0,1]
r:9[2,0],6,3
r:13[3,0],10,7,4
r:c:17[4,0],14,11,8  total number of diagonals totalrows+totalcols-1(5+4-1)
c:18[4,1],15,12
c:19[4,2],16
c:20[4,3]

  0 1 2
0:1,2,3
1:4,5,6
2:7,8,9
i=1,j=0 -> i-1=0 j+1=1 (formula to find the diagonals)

start of diagonals
create a for loop which start with col[0]
create a for loop which start with nth row[m-1] col[1]
*/ 