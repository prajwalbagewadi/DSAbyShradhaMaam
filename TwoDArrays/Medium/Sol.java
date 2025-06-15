public class Sol {
    public static int trailingZeroes(int n) {
        if(n<=1){
            return 1;
        }
        int ans = n*trailingZeroes(n-1);
        String num=String.valueOf(ans);
        
        return  0;
    }
    public static void main(String[] args){
        int num=6;
        System.out.println("factorial="+trailingZeroes(num));
    }
}
