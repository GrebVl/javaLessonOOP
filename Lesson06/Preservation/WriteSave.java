package Lesson06.Preservation;

import Lesson06.Game;
import java.io.FileWriter;
import java.io.IOException;

public class WriteSave {
    public WriteSave(){}
    public void newWriteSave(Game gm, String comand) throws IOException{
        try(FileWriter fileWrit = new FileWriter(FileSave.savePB, false))
        {
            StringBuilder strBld = new StringBuilder();
            for(int i = 0; i < gm.sizePlayer(); i++){
                strBld.append(gm.getPlayer(i).getName() + "|");
            }
            strBld.append(comand);
            strBld.append(":\n");
            String str = new String(strBld);
            fileWrit.write(str);            
            fileWrit.flush();
            fileWrit.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
    }
    
    public void writeSave(int moveNum, int candis, int indexPlayer) throws IOException{
        try(FileWriter fileWrit = new FileWriter(FileSave.savePB, true))
        {
            StringBuilder strBld = new StringBuilder();
            strBld.append(indexPlayer + "|");
            strBld.append(moveNum + "|");
            strBld.append(candis + ";\n");
            String str = new String(strBld);
            fileWrit.write(str);            
            fileWrit.flush();
            fileWrit.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
