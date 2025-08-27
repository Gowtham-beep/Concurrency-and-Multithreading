import java.io.*;

public class FileCopyDemo {
    public static void main(String[] args) {
        String sourceFile="input.txt";
        String destinationfile="output.txt";

        try(FileInputStream fis = new FileInputStream(sourceFile);
         FileOutputStream fos = new FileOutputStream(destinationfile)){

         byte[] buffer = new byte[1024];
         int bytesRead;

         while((bytesRead = fis.read(buffer))!=1){
            fos.write(buffer,0,bytesRead);
         }
         System.out.println("File copied successfully");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
