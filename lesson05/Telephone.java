package lesson05;

public class Telephone {
    private String phoneNumber;
    private String comment;

    Telephone(String pNum, String com){
        phoneNumber = pNum;
        comment = com;
    }

    Telephone(){    }

    @Override
    public String toString() {
        return String.format("%s : %s", phoneNumber, comment);
    }

    public String getPhone(){
        return phoneNumber;
    }

    public String getComment(){
        return comment;
    }
    
}
