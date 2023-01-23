package Lesson06.Preservation;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadSave {
    private ArrayList<String> readSave;

    public ReadSave(){
        readSave = new ArrayList<>();
    }

    public ArrayList<String> readFile() throws IOException{
        try (FileReader fileRead = new FileReader(FileSave.savePB)){
            Scanner scan = new Scanner(fileRead);
            while(scan.hasNextLine()){
                readSave.add(scan.nextLine().trim());
            }
            scan.close();
            fileRead.close();
        } catch(Exception e){
            System.out.println("Parsing error " + e.toString());
        }
        return readSave;
    }
}
