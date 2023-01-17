package lesson05;

import lesson05.FileHand.FileName;
import lesson05.FileHand.ReadingFile;
import java.io.IOException;
import lesson05.FileHand.RecordFile;
import java.util.Scanner;



public class Menu {
    public void mainMenu() throws IOException{
        Phonebook phoneBook = new ReadingFile().readFile(FileName.namePB);
        try (Scanner input = new Scanner(System.in)) {
            boolean ex = true;
            while (ex) {
                System.out.println(" 1 - все контакты\n 2 - просмотр контакта по номеру\n" +
                                    " 3 - добавление контакта\n 4 - удаление контакта\n" +
                                    " 5 - запись в фаил в одну строку\n 6 - запись в фаил в несколько сьтрок\n" +
                                    " 7 - Выход");
                String key = input.next();
                switch (key) {
                    case "1":
                        for(int i = 0; i < phoneBook.getPhonebook().size(); i++){
                            System.out.print(i+1 +") " + phoneBook.getContact(i).toString());
                        }
                        break;
                    case "2":
                        System.out.println("Введите порядковый номер контакта");
                        int numContact = input.nextInt() - 1;
                        phoneBook.getInfoContact(numContact);
                        break;
                    case "3":
                        this.contactEditing(phoneBook);
                        break;
                    case "4":
                        System.out.println("Введите порядковый номер контакта");
                        int indexContact = input.nextInt() - 1;
                        phoneBook.deletContact(indexContact);
                        break;
                    case "5":
                        new RecordFile().oneLinerRecord(phoneBook, FileName.namePB);
                        break;
                    case "6":
                        new RecordFile().multilinerRecord(phoneBook, FileName.namePB);
                        break;
                    case "7":
                        ex = false;
                        input.close();
                        break;
                    default:
                        System.out.println("Такой команды нет");
                }
            }
        }
    }

    public void contactEditing(Phonebook pB){
        InputDataScanner scn = new InputDataScanner();
        scn.getInput();
        String fContact = scn.inputString("Фамилию");
        String iContact = scn.inputString("Имя");
        String oContact = scn.inputString("Отчество");
        pB.addContact(fContact, iContact, oContact);
        String nContact = scn.inputString("номер");
        String cContact = scn.inputString("комментарий");
        pB.getContact(pB.getSize()-1).addTelephone(nContact, cContact);
    }

}
