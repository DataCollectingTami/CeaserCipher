public class CeaserCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;



    public CeaserCipherTwo(int key1, int key2){
        alphabet = "abcdefghijklmnopqrstuvwxyz";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }

    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder("");
        for (int i = 0; i < input.length(); i++){

            String ch = Character.toString(input.charAt(i));
            if (i % 2 == 0){
                CeaserCipher cc1 = new CeaserCipher(mainKey1);
                encrypted.append(cc1.encrypt(ch));
            }
            else {
                CeaserCipher cc2 = new CeaserCipher(mainKey2);
                encrypted.append(cc2.encrypt(ch));
            }

        }
        return encrypted.toString();
    }

    public String decrypt(String input){
        StringBuilder decrypted = new StringBuilder();
        for (int k = 0; k<input.length();k++){
            String ch = Character.toString(input.charAt(k));
            if (k%2==0){
                CeaserCipher cc1 = new CeaserCipher(26-mainKey1);
                decrypted.append(cc1.encrypt(ch));
            }
            else{
                CeaserCipher cc2= new CeaserCipher(26-mainKey2);
                decrypted.append(cc2.encrypt(ch));
            }
        }
        return decrypted.toString();
    }


public static void main(String[] args){
        CeaserCipherTwo test = new CeaserCipherTwo(21,8);
        //test.decrypt("WUVH FRNV ZQ WYH FFQWHIHEFV IRFP!");
       String result= test.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
       System.out.println(result);
}
}




