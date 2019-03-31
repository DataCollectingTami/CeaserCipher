import edu.duke.FileResource;

public class testCeaserCipherTwo {
private String alph;
    public int[] countLetters(String messsage){
        alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
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

    public String halfOfString(String message, int start){
        StringBuilder sb = new StringBuilder();

        for (int i=start;i<message.length();i+=2) sb.append(message.charAt(i));

        return sb.toString();
    }

    public String breakCeaserCipher(String input){
    String halfString1 = halfOfString(input,0);
    String halfString2 = halfOfString(input,1);

    int maxIndex1 = maxIndex(countLetters(halfString1));
    int maxIndex2 = maxIndex(countLetters(halfString2));
    int key1 = maxIndex1-4;
    int key2 = maxIndex2-4;
    if (maxIndex1 < 4) key1 = 26- (4-maxIndex1);
    if (maxIndex2 < 4) key2 = 26- (4-maxIndex2);
    System.out.println("Key 1 is: "+key1);
    System.out.println("Key 2 is: "+key2);

    CeaserCipherTwo ccTwo= new CeaserCipherTwo(key1,key2);

    return ccTwo.decrypt(input);
    }


    public void simpleTests(){
        FileResource fr = new FileResource();
        String input = fr.asString();
        //CeaserCipherTwo ccTwo = new CeaserCipherTwo(17,3);
        //String encryptedMsg = ccTwo.encrypt(input);
        //System.out.println(encryptedMsg);
        //System.out.println(ccTwo.decrypt(encryptedMsg));
        System.out.println(breakCeaserCipher(input));
    }

    public static void main(String[] args){
        testCeaserCipherTwo test = new testCeaserCipherTwo();
        test.simpleTests();
        //String result=test.breakCeaserCipher("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
        //System.out.println(result);
    }

}
