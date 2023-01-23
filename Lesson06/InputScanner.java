package Lesson06;

import java.util.Scanner;

public class InputScanner {
    private static Scanner scn;

    public Scanner getInput(){
        if(scn == null){
            scn = new Scanner(System.in);
        }
        return scn;
    }
    public Integer inputNumber(String name){
        System.out.printf("Введите %s\n", name);
        return scn.nextInt();
    }

    public String inputString(String name){
        System.out.printf("Введите %s\n", name);
        return scn.nextLine();
    }

    public void closeInput(){
        if(scn != null){
            scn.close();
        }
    }
}
