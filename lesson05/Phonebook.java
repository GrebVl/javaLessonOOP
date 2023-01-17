package lesson05;

import java.util.ArrayList;

public class Phonebook {
    private ArrayList<Contact> phoneBook = new ArrayList<>();

    public void addContact(String fN, String iN, String oN){
        phoneBook.add(new Contact(fN, iN, oN));
    }

    public void getInfoContact(int index){
        phoneBook.get(index).getInfo();
    }

    public int getSize(){
        return phoneBook.size();
    }


    public Contact getContact(int i){
        return phoneBook.get(i);
    }

    public void getInfoComplit(){
        for(Object k : phoneBook){
            System.out.println(k.toString());
        }
    }

    public ArrayList<Contact> getPhonebook(){
        return phoneBook;
    }
    
    public void deletContact(int index){
        phoneBook.remove(index);
    }
    
}
