public class Main {
    public static int cnt=1;
    static void generatePermutations(String prefix,String remaining){
        if(remaining.isEmpty()){ //Stopping Condition
            System.out.println("cnt="+cnt+" output Prefix="+prefix); //output
            cnt++;
            return;
        }
        for(int i=0;i<remaining.length();i++){
            char ch=remaining.charAt(i);//extract a single char from string
            //System.out.println("ch="+ch);
            String rest1=remaining.substring(0,i);
            //System.out.println("rest1="+rest1);
            String rest2=remaining.substring(i+1);
            //System.out.println("rest2="+rest2);
            generatePermutations(prefix+ch, rest1+rest2);
        }
    }
    public static void main (String[] args){
        String str="ABC123";
        generatePermutations("", str);
    }
}
