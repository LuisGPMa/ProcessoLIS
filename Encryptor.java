import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Encryptor {

    //removes all special characters using the regular expression that matches everything which is not a letter, and then removes those matches
    public static String removeSpecialCharacters(String message){
        message = message.replaceAll("[^a-zA-Z]", "");
        return message;
    }

    public static void encryptMessage(String message){
        double lengthSquareRoot = Math.sqrt(message.length());

        int rows = (int)Math.floor(lengthSquareRoot);
        int columns = (int)Math.ceil(lengthSquareRoot);

        char[][] matrix = new char[rows][columns];
        int charpointer=0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){ 
                if(charpointer >= message.length()){
                    break;
                }     
                matrix[i][j] = message.charAt(charpointer);
                charpointer++;
            }
            if(charpointer >= message.length()){
                break;
            }
        }
        messageWriter(matrix, rows, columns);
    }

    public static void messageWriter(char[][] matrix, int rows, int columns){
        String message = "";
        for(int i=0; i<columns; i++){
            for(int j=0; j<rows; j++){   
                if(String.valueOf(matrix[j][i]).matches("[a-zA-Z]")){           
                    message = message + matrix[j][i];
                }
                if(j==rows-1){
                    message = message + " ";
                }
            }
        }
        message = message.strip();
        try{
            writeOnFile(message);
        }catch(IOException e){
            System.out.println("error writing to file");
        }
    }

    private static void writeOnFile(String message) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write(message);
        writer.close();
    }
}