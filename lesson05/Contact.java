package lesson05;

import java.util.ArrayList;

public class Contact {
    private String fName;
    private String iName;
    private String oName;
    private ArrayList<Telephone> telephones = new ArrayList<>();

    Contact(String fN, String iN, String oN){
        fName = fN;
        iName = iN;
        oName = oN;
    }

    Contact(){    }

    public void addTelephone(String tel, String com){
        telephones.add(new Telephone(tel, com));
    }

    @Override
    public String toString() {
        return String.format("%s %s %s\n", fName, iName, oName);
    }

    public void getInfo(){
        System.out.print(this.toString());
        for(int i = 0; i < telephones.size(); i++){
            System.out.println(i + 1 + " - " + telephones.get(i).toString());
        }
        System.out.println();
    }

    public boolean equalsCon(String fN, String iN, String oN) {
        if(this.fName.toString() == fN
        && this.iName.toString() == iN
        && this.oName.toString() == oN){
            System.out.println(this.toString() + "true");
            return true;
        }else{
            System.out.println(this.toString() + "false");
            return false;
        }
    }

    public String getFName(){
        return fName;
    }

    public String getIName(){
        return iName;
    }

    public String getOName(){
        return oName;
    }

    public int sizeTelephon(){
        return telephones.size();
    }

    public Telephone getTelephon(int index){
        return telephones.get(index);
    }   
}
