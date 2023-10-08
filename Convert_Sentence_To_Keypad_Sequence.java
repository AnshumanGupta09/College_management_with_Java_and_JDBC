package dsa_practice_questions;

public class Convert_Sentence_To_Keypad_Sequence {
    static String printSequence(String S) 
    {
        //String[] alpha = {"A","B","C","D","E","F","G","H","I","J","K","","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String[] numeric = {"2","22","222","3","33","333","4","44","444","5","55","555","6","66","666","7","77","777","7777","8","88","888","9","99","999","9999"};
        // code here
        String output = "";
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == '1'){
                output = output + "1";
            }
            else if(S.charAt(i) == ' '){
                output = output + "0";
            }
            else if(S.charAt(i) == '*'){
                output = output + "*";
            }
            else{
                int num = S.charAt(i) -'A';
                output = output + numeric[num];
            }
        }
        return output;
    }
    public static void main(String[] args) {
        String in  = "AEI";
        String output = printSequence(in);
        System.out.println(output);
    }
    
}
