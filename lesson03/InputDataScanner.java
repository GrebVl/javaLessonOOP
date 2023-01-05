package lesson03;

import java.util.Scanner;

public class InputDataScanner {
    private static Scanner scn;

    public Scanner getInput(){
        if(scn == null){
            scn = new Scanner(System.in);
        }
        return scn;
    }
    public Integer inputNumber(){
        return scn.nextInt();
    }

    public void closeInput(){
        if(scn != null){
            scn.close();
        }
    }
}
