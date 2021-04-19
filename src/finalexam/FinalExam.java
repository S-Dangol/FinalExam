package finalexam;

import java.io.*;

public class FinalExam {

    public static void main(String[] args) {
        File file = new File("originalText.txt");
        String origin = "";
        String encrypt = "";
        int key = 1;
        char[] chars;
        
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
            c += 1;
        }

        
        // Write on ecnryptText.txt
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("ecnryptedText.txt"));
            for (char c : chars) {
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
        System.out.println(encrypt);

    }

}
