/*
Given a sentence in the form of a string, convert it into its equivalent mobile numeric keypad sequence. 
Mobile-keypad
|  1    |  ABC 2  |  DEF 3  |
| GHI 4 |  JKL 5  |  MNO 6  |
|PQRS 7 |  TUV 8  | WXYZ 9  |
|   *   |   0     |   #     |


Examples : 
Input: GEEKSFORGEEKS
Output: 4333355777733366677743333557777
Explanation: For obtaining a number, we need to press a number corresponding to that character for a number of times equal to the position of the character. For example, for character E, press number 3 two times and accordingly.

Input : HELLO WORLD
Output : 4433555555666096667775553
*/

public class Csemnks {
    public static String charToNum(char c){
        String ctn="";
        switch(c){
            case 'A':
                ctn="2";
                break;
            case 'B':
                ctn="22";
                break;
            case 'C':
                ctn="222";
                break;
            case 'D':
                ctn="3";
                break;
            case 'E':
                ctn="33";
                break;
            case 'F':
                ctn="333";
                break;
            case 'G':
                ctn="4";
                break;
            case 'H':
                ctn="44";
                break;
            case 'I':
                ctn="444";
                break;
            case 'J':
                ctn="5";
                break;
            case 'K':
                ctn="55";
                break;
            case 'L':
                ctn="555";
                break;
            case 'M':
                ctn="6";
                break;
            case 'N':
                ctn="66";
                break;
            case 'O':
                ctn="666";
                break;
            case 'P':
                ctn="7";
                break;
            case 'Q':
                ctn="77";
                break;
            case 'R':
                ctn="777";
                break;
            case 'S':
                ctn="7777";
                break;
            case 'T':
                ctn="8";
                break;
            case 'U':
                ctn="88";
                break;
            case 'V':
                ctn="888";
                break;
            case 'W':
                ctn="9";
                break;
            case 'X':
                ctn="99";
                break;
            case 'Y':
                ctn="999";
                break;
            case 'Z':
                ctn="9999";
                break;
            case ' ':
                ctn="0";
                break;
            default:
                ctn="Error in input.";
        }
        return ctn;
    }
    public static String convertStrToKeypad(String s){
        char[] in=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<in.length;i++){
            String temp=Csemnks.charToNum(in[i]);
            System.out.print("char:"+in[i]+":");
            System.out.print("temp:"+temp+" ");
            sb.append(temp);
        }
        System.out.println();
        return sb.toString();
    } 
    public static void main(String[] args) {
       String s="HELLOWORLD"; //uppercase.
       System.out.println("String input:"+s);
       System.out.println("Keypad number="+Csemnks.convertStrToKeypad(s));
       String s1="GEEKSFORGEEKS"; //uppercase.
       System.out.println("String input:"+s1);
       System.out.println("Keypad number="+Csemnks.convertStrToKeypad(s1));
    }
}