public static int[] ReverseArray(int[] arr){
        int[] rev=new int[arr.length];
        int j=0;
        for(int i=arr.length-1;i>=0;i--){
            rev[j]=arr[i];
            j++;
        }
        return rev;
    }