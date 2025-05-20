
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Solution {
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> diag = new ArrayList<>();
        for(int i=0;i<nums.size();i++){ //for row starting
            int r=i;//row init 0
            int c=0;//col init 0
            while(r>=0){ //check if row reaches 0th row
                    //System.out.print(nums.get(r).get(c));
                diag.add(nums.get(r).get(c));
                r--;
                c++;
            }
            //System.out.println();
        }
        for(int i=1;i<nums.get(0).size();i++){ //for nth row col[1] starting
            int r=nums.size()-1;//row init last row 1st col
            int c=i;//col init 1
            while(c<=nums.get(0).size()-1){ //check if col reaches nth col
                //System.out.print(nums.get(r).get(c));
                diag.add(nums.get(r).get(c));
                r--;
                c++;
            }
            //System.out.println();
        }
        //System.out.println(arr[st]);
        System.out.println(diag);
        int[] arr=new int[diag.size()];
        for(int i=0;i<arr.length;i++){
            arr[i]=diag.get(i);
        }
        return arr;
    }
    public static void main(String[] args) {
        //1 2 3
        //4 5 6
        //7 8 9 
        //2d list
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
        // for(List<Integer> row:list2d){
        //     for(int i:row){
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }
        int[] arr=findDiagonalOrder(list2d);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        List<List<Integer>> list2d1 = new ArrayList<>();
        //[[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]];
        list2d1.add(Arrays.asList(1,2,3,4,5)); 
        list2d1.add(Arrays.asList(6,7));
        list2d1.add(Arrays.asList(8));
        list2d1.add(Arrays.asList(9,10,11));
        list2d1.add(Arrays.asList(12,13,14,15,16));
        int bigSize=0;
        for(List<Integer>row:list2d1){
            if(row.size()>bigSize){
                bigSize=row.size();
            }
        }    
        System.out.println("BigSize:"+bigSize);
        int[][] arr1=new int[list2d1.size()][bigSize];
        for(int i=0;i<list2d1.size();i++){
            for(int j=0;j<bigSize;j++){
                if(list2d1.get(i).get(j)!=null){
                    arr1[i][j]=list2d1.get(i).get(j);
                }else{
                    arr1[i][j]=0;
                }
            }
        }
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[0].length;j++){
                System.out.print(arr1[i][j]);
            }
            System.out.println();
        }
    }
}
/*
 * notes:
 * formula to move diagonally across a 2d array is i--,j++;
*/