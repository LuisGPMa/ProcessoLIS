import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        String inputFile = "";
        try{
            inputFile = fileReader("message.txt");
        }catch(IOException e){
            System.out.println("Error reading file");
        }
        Scanner sc = new Scanner(inputFile);
        String message = sc.nextLine();
        int option = sc.nextInt();
        if(option==0){
            message = Encryptor.removeSpecialCharacters(message);
            Encryptor.encryptMessage(message);
            System.out.println("Message encrypted and written to file output.txt");
        }else if(option==1){
            Decryptor.messageRecover(message);            
            System.out.println("Message decrypted and written to file output.txt");
        }
    }

    public static String fileReader(String arquivo) throws IOException{
        return new String(Files.readAllBytes(Paths.get(arquivo)), Charset.forName("ASCII"));
    }
}
