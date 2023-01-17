package lesson05.FileHand;

import lesson05.Phonebook;
import java.io.FileWriter;
import java.io.IOException;

public class RecordFile {
    public void oneLinerRecord(Phonebook phonBook, String nameFile) throws IOException{
        try(FileWriter fileWrit = new FileWriter(nameFile, false))
        {
            for(int i = 0; i < phonBook.getSize(); i++){
                StringBuilder strBld = new StringBuilder();
                strBld.append(phonBook.getContact(i).getFName() + "|");
                strBld.append(phonBook.getContact(i).getIName() + "|");
                strBld.append(phonBook.getContact(i).getOName() + ":");
                for(int j = 0; j < phonBook.getContact(i).sizeTelephon(); j++){
                    strBld.append(phonBook.getContact(i).getTelephon(j).getPhone() + "|");
                    strBld.append(phonBook.getContact(i).getTelephon(j).getComment());
                    if(j == phonBook.getContact(i).sizeTelephon() - 1){
                        strBld.append(";\n");
                    }else{
                        strBld.append(",");
                    }
                }
                String str = new String(strBld);
                fileWrit.write(str);
            }
             
            fileWrit.flush();
            fileWrit.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    }

    public void multilinerRecord(Phonebook phonBook, String nameFile) throws IOException{
        try(FileWriter fileWrit = new FileWriter(nameFile, false))
        {
            for(int i = 0; i < phonBook.getSize(); i++){
                StringBuilder strBld = new StringBuilder();
                strBld.append(phonBook.getContact(i).getFName() + "|");
                strBld.append(phonBook.getContact(i).getIName() + "|");
                strBld.append(phonBook.getContact(i).getOName() + ":\n");
                for(int j = 0; j < phonBook.getContact(i).sizeTelephon(); j++){
                    strBld.append(phonBook.getContact(i).getTelephon(j).getPhone() + "|");
                    strBld.append(phonBook.getContact(i).getTelephon(j).getComment());
                    if(j == phonBook.getContact(i).sizeTelephon() - 1){
                        strBld.append(";\n");
                    }else{
                        strBld.append(",\n");
                    }
                }
                strBld.append("\n");
                String str = new String(strBld);
                fileWrit.write(str);
            }
             
            fileWrit.flush();
            fileWrit.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    }


}
