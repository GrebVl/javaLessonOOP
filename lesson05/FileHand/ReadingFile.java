package lesson05.FileHand;

import lesson05.Phonebook;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadingFile{
    public Phonebook readFile(String nameFile) throws IOException{
        Phonebook phonBook = new Phonebook();
        try (FileReader fileRead = new FileReader(nameFile)){
            Scanner scan = new Scanner(fileRead);
            int indexContact = 0;
            while(scan.hasNextLine()){
                int indexEnd;
                int indexStartTep = 0;
                int indexStart = 0;
                char[] dts;
                StringBuilder strBuil = new StringBuilder();
                strBuil.append(scan.nextLine().trim());
                for(int i = 0; i < strBuil.length(); i++){
                    if(strBuil.charAt(i) == ':'){
                        indexStartTep = i;
                        String[] fullName = new String[3];
                        int countN = 0;
                        for(int j = 0; j <= i; j++){
                            if(strBuil.charAt(j) == '|' || j == i){
                                indexEnd = j;
                                dts = new char[indexEnd - indexStart];
                                strBuil.getChars(indexStart, indexEnd, dts, 0);
                                fullName[countN] = new String(dts).toUpperCase();
                                indexStart = j + 1;
                                countN ++;
                            }
                        }
                        boolean addBool = true;
                        int entry = 0;
                        while (addBool) {
                            if(phonBook.getSize() - 1 > 0 && entry == 0){
                                for(int k = 0; k < phonBook.getSize(); k++){
                                    if(fullName[0].compareTo(phonBook.getContact(k).getFName()) == 0
                                        && fullName[1].compareTo(phonBook.getContact(k).getIName()) == 0
                                        && fullName[2].compareTo(phonBook.getContact(k).getOName()) == 0){
                                        indexContact = k;
                                        addBool = false;
                                    }
                                }
                                entry++;
                            }else{
                                phonBook.addContact(fullName[0], fullName[1], fullName[2]);
                                indexContact = phonBook.getSize() - 1;
                                addBool = false;
                            }
                        }
                    }else if(strBuil.charAt(i) == ',' || strBuil.charAt(i) == ';'){
                        String[] fullTelephone = new String[2];
                        int countT = 0;
                        indexStart = indexStartTep + 1;
                        if(indexStart == 1){
                            indexStart -= 1;
                        }
                        for(int j = indexStartTep; j <= i; j++){
                            if(strBuil.charAt(j) == '|' || j == i){
                                indexEnd = j;
                                dts = new char[indexEnd - indexStart];
                                strBuil.getChars(indexStart, indexEnd, dts, 0);
                                fullTelephone[countT] = new String(dts);
                                indexStart = j + 1;
                                countT++;
                            }
                        }
                        indexStartTep = i;
                        phonBook.getContact(indexContact).addTelephone(fullTelephone[0], fullTelephone[1]);                       
                    }
                }
            }
            scan.close();
            fileRead.close();
        } catch(Exception e){
            System.out.println("Parsing error " + e.toString());
        }
        return phonBook;
    }
}
