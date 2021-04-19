package finalexam;

import java.io.*;
import java.util.Random;

public class FinalExam {

    public static void main(String[] args) {
        File file = new File("originalText.txt");
        String origin = "";
        String encrypt = "";
        
        char[] chars;
        char[] char2 = new char[1000];
        char[] char3 = new char[1000];
        char[] char4 = new char[1000];
        char[] char5 = new char[1000];
        char[] chars6 = new char[1000];
        String zxc = "";
        int a = 0, randomKey;

        String header = "A1B2";
        String trailer = "END";

        randomKey = RandomKey();
 

        // read originalText.txt
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("originalText.txt"));
            origin = br.readLine();
        } catch (Exception e) {
            return;
        }

        System.out.println("Original Text : \n"+origin);

        chars = origin.toCharArray();
        for (char c : chars) {
            c += randomKey;
      
            char2[a] = c;
            a++;
        }
        
        //saving index size of original text
        int s = a;
        
        zxc = new String(char2);
        System.out.println("");
        System.out.println("Encrypted Text : \n"+ zxc);
        StringBuilder sb = new StringBuilder(zxc);
        sb.reverse();
        encrypt = header + sb + trailer;
        System.out.println("");
        System.out.println("Reversed Text : \n"+ encrypt);
        
        // Write on ecnryptText.txt
        char3 = encrypt.toCharArray();
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("ecnryptedText.txt"));
            for (char c : char3) {
              
                bw.write(c);
            }
            bw.close();
        } catch (Exception ex) {
            return;
        }

        // Read encryptText.txt
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("ecnryptedText.txt"));
            encrypt = br.readLine();
        } catch (Exception e) {
            return;
        }
        System.out.println("");
        System.out.println("Encrypted, Reversed and Encapsilated Text : \n"+ encrypt);
        
        
        //Decrypting encryptText.txt
        char4 = encrypt.toCharArray();

        int ss = char4.length;
        ss -= 3;

        int k, i;
        for (i = 0, k = 0; i < char4.length; i++) {
            if (i > 3 && i < ss) {
                char5[k] = char4[i];
                k++;
            }
        }

   
        zxc = new String(char5);
        sb = new StringBuilder(zxc);
        sb.reverse();
        encrypt = sb + "";

        // resultText.txt
        a = 0;
        chars6 = encrypt.toCharArray();
        for (char c : chars6) {
            c -= randomKey;

            char2[a] = c;
            a++;
        }
        

        String result = new String(char2);
 
        
        char[] finalChar = new char[s];
        for (i = 0, k = 0; i < char2.length; i++) {
            if (i < s) {
             finalChar[k] = char2[i];
                k++;
            }
        }

        result = new String(finalChar);
        System.out.println("");
        System.out.println("Result of Decryption Text : \n"+ result);
        
        char3 = result.toCharArray();
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("resultText.txt"));
            for (char c : char3) {
              
                bw.write(c);
            }
            bw.close();
        } catch (Exception ex) {
            return;
        }
        // Write on ecnryptText.txt

    }

    public static int RandomKey() {
        int randomKey;
        //Random Key generated "randomKey"
        Random r = new Random(8);
        randomKey = r.nextInt(9);
        return randomKey;
    }

}
