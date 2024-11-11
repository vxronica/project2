import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class XOREncryption {
    public static void main(String[] args) {
        try {
            File dataFile = new File("data.txt");
            File keyFile = new File("key.txt");
            File outputFile = new File("output.txt");

            //initialize byte arrays
            byte[] dataBytes = new byte[(int) dataFile.length()];
            byte[] keyBytes = new byte[(int) keyFile.length()];

            FileInputStream dataStream = new FileInputStream(dataFile);
            FileInputStream keyStream = new FileInputStream(keyFile);
            dataStream.read(dataBytes);
            dataStream.read(keyBytes);

            for(int i = 0; i < dataBytes.length; i++){
                int keyIndex = i % keyBytes.length;
                System.out.println(dataBytes[i]);
                System.out.println(keyIndex);
                dataBytes[i] ^= keyBytes[keyIndex];

            }
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(dataBytes);
            outputStream.close();



            /*int i;
            while((i = dataStream.read())!=-1) {
         
                // converts integer to character
                char c = (char)i;
                
                // prints character
                System.out.print(c);
            }*/
        } catch (FileNotFoundException e) {
            System.out.println("No file.");
        } catch (IOException e) {
            System.out.println("IO Error.");
        }
    }



}
