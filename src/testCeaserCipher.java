import edu.duke.FileResource;


public class testCeaserCipher {
public int[] countLetters(String messsage){
    String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    alph=alph.toLowerCase();
    int[] counts = new int[26];
    int index =0;
    for(int k=0;k<messsage.length();k++){
        char ch = Character.toLowerCase(messsage.charAt(k));
        index = alph.indexOf(ch);
        if (index!=-1){
            counts[index] +=1;
        }
    }
    return counts;
}

    public int maxIndex(int[] values){
        int maxLength =0;
        int indexOfMax =0;

        for (int k=0; k<values.length; k++){
            if (values[k]>maxLength){
                maxLength =values[k];
                indexOfMax = k;
            }
        }
        return indexOfMax;
    }

    public String breakCeaserCipher(String input){
        int[] freqs= countLetters(input);
        int maxIndex = maxIndex(freqs);
        //4 is index of e, the most common letter
        int dkey = maxIndex-4;
        //count backwards
        if (maxIndex<4){
            dkey = 26-(4-maxIndex);
        }
        CeaserCipher cc = new CeaserCipher(26-dkey);
        System.out.println("Key is: "+dkey);
        return cc.encrypt(input);

    }



public void simpleTests(){
    FileResource fr = new FileResource();
    String input= fr.asString();
    CeaserCipher cc = new CeaserCipher(18);
    String encryptedMsg= cc.encrypt(input);
    System.out.println(encryptedMsg);
    //System.out.println(cc.decrypt(encryptedMsg));
    System.out.println(breakCeaserCipher(encryptedMsg));

}

public static void main(String[] args){
    testCeaserCipher tcc = new testCeaserCipher();
    tcc.simpleTests();
}
}
