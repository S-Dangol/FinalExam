package finalexam;

import java.io.*;
import java.util.Random;

public class FinalExam {

    public static void main(String[] args) {
        File file = new File("originalText.txt");
        String origin = "";
        String encrypt = "";
        int key = 1;
        char[] chars;
        char[] char2 = new char[1000];
        char[] char3 = new char[1000];
        String zxc = "";
        int a = 0, randomKey;

        String header = "A1B2";
        String trailer = "END";

        //Random Key generated "randomKey"
        Random r = new Random(8);
        randomKey = r.nextInt(9);
        System.out.println(randomKey);

        // read originalText.txt
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("originalText.txt"));
            origin = br.readLine();
        } catch (Exception e) {
            return;
        }

        System.out.println(origin);

        chars = origin.toCharArray();
        for (char c : chars) {
            c += randomKey;
            System.out.print(c);
            char2[a] = c;
            a++;
        }

        zxc = new String(char2);
        StringBuilder sb = new StringBuilder(zxc);
        sb.reverse();
        encrypt = header + sb + trailer;

//        for (char z : ){
//            
//        }
        System.out.println("");
        System.out.println("zzz");
        System.out.println(encrypt);
        System.out.println("zzz");

        char3 = encrypt.toCharArray();
        // Write on ecnryptText.txt
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("ecnryptedText.txt"));
            for (char b : char3) {
                System.out.print(b);
                bw.write(b);
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
        System.out.println(encrypt);

        //Decrypting encryptText.txt
//        int[] randomNumbers = new int[FinalExam.arrlength()];
//        for (int i = 0; i < randomNumbers.length; i++) {
//            randomNumbers[i] = 1 + r.nextInt(8);
//        }
//         for (char c : ch) {
//            for (int i : RandomGenerator.gen()) {
//                c += RandomGenerator.gen()[i];
//                System.out.print(c);
//            }
//        }
    }

}
