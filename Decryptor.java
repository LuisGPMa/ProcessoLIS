import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Decryptor {
    
    public static String messageRecover(String encryptedMessage){
        //if the encrypted message is in the correct format, the length of the first word will be equal to the
        //amount of rows in the original matrix, and the amound of words will be equal to the amount of columns
        int rows=0;
        encryptedMessage = encryptedMessage.strip();
        //count how many characters until the first space to determine length of first word
        while(!String.valueOf(encryptedMessage.charAt(rows)).equals(" ")){
            rows++;
        }
        int columns = 1;
        //amount of words is the amount of spaces + 1
        for(int i=0; i<encryptedMessage.length(); i++){
            if(encryptedMessage.charAt(i) == ' '){
                columns++;
            }
        }
        String message = "";
        String[] wordsVector = encryptedMessage.split(" ");
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if(i<wordsVector[j].length())
                    message += wordsVector[j].charAt(i);
            }    
        }
        try{
            writeOnFile(message);
        }catch(IOException e){
            System.out.println("Error writing to file");
        }
        return message;
    }

    private static void writeOnFile(String message) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(message);
        writer.close();
    }
}
