package lesson01;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;


public class file {

    public ArrayList<String> readFile(String nameFile) throws IOException{
        ArrayList<String> arrFile = new ArrayList<>();
        try (FileReader fileRead = new FileReader(nameFile)){
            Scanner scan = new Scanner(fileRead);
            while(scan.hasNextLine()){
                arrFile.add(scan.nextLine());
            }
            scan.close();
        } catch(Exception e){
            System.out.println("Parsing error" + e.toString());
        }
        return arrFile;
    }    
}
