public class CeaserCipher {

private static final String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
private int key;
private String shiftedAlphabet="";

public CeaserCipher(int key){
    this.key=key;
  shiftedAlphabet = alphabet.substring(key)+
            alphabet.substring(0,key);

}
    public String encrypt(String input) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //make double alphabet with lower case letters too
        String lowerAlphabet = alphabet.toLowerCase();
        String lowerShiftedAlphabet = shiftedAlphabet.toLowerCase();

        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            int idx=0;
            if (Character.isUpperCase(currChar)) {
                //Find the index of currChar in the alphabet (call it idx)
                idx = alphabet.indexOf(currChar);
                //If currChar is not in the alphabet
                if (idx != -1) {
                    //Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabet.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
            }
            if (Character.isLowerCase(currChar)) {
                idx = lowerAlphabet.indexOf(currChar);

                if (idx != -1) {
                    //Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = lowerShiftedAlphabet.charAt(idx);
                    //Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar);
                }
            }
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }

public String decrypt(String input){
int mainKey=key;
CeaserCipher cc= new CeaserCipher(26-mainKey);
String decrypted= cc.encrypt(input);
return decrypted;
}



    public static void main(String[] args){
        CeaserCipher tcc = new CeaserCipher(15);
        System.out.println(tcc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
    }

}
