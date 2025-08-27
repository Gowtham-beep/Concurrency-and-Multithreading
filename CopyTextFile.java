import java.io.*;

public class CopyTextFile {
    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destinationFile = "outputChar.txt";

        try(
            FileReader reader = new FileReader(sourceFile);
            FileWriter writer = new FileWriter(destinationFile);
        ) {
            char[] buffer = new char[1024];
            int charRead;

            while((charRead = reader.read(buffer))!=1){
                writer.write(buffer,0,charRead);
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error: "+e.getMessage());
        }
    }
}
