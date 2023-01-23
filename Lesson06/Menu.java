package Lesson06;

import Lesson06.Preservation.ReadSave;
import Lesson06.Preservation.WriteSave;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Menu {
    private boolean ex;
    private InputScanner scn;
    private Model model;
    private Integer candis;
    private WriteSave save;
    private ReadSave rSave;

    Menu(){
        ex = true;
        scn = new InputScanner();
        model = new Model();
        save = new WriteSave();
        rSave = new ReadSave();
        candis = 2021;
    }

    public void mainMenu() throws IOException{
        scn.getInput();
        while(ex){
            System.out.println("1 Новая игра \n2 Продолжить \n3 Выход");
            String moveNum = scn.inputString("номер");
            switch (moveNum) {
                case "1":
                    this.newGameMenu();
                    break;
                
                case "2":
                    this.continGameMenu(rSave.readFile());
                    break;

                case "3":
                    ex = false;
                    scn.closeInput();
                    break;
                default:
                    System.out.println("Такой команды нет");
            }
        }
    }

    public void  newGameMenu() throws IOException{
        boolean exNewGame = true;
        while (exNewGame) {
            System.out.println("1 Игрок с игроком \n2 Игрок с роботом \n3 Выход");
            String moveNum = scn.inputString("номер");
            Game games = new Game();
            Random rnd = new Random();
            int move;
            switch (moveNum) {
                case "1":
                    int playerGame = scn.inputNumber("количество игроков");
                    for(int i = 0; i < playerGame; i++){
                        String name = scn.inputString("имя игрока");
                        games.addPlayer(name);
                    }
                    save.newWriteSave(games, "1");
                    move = rnd.nextInt(games.sizePlayer());
                    model.movePlayer(games, candis, save, move);
                    break;
                case "2":
                    String name = scn.inputString("имя игрока");
                    games.addPlayer(name);
                    games.addRobot();
                    save.newWriteSave(games, "2");
                    move = rnd.nextInt(2);
                    model.moveRobot(games, candis, save, move);
                    break;
                case "3":
                    exNewGame = false;
                    break;
                default:
                    System.out.println("Такой команды нет");
            }
        }
    }

    public void continGameMenu(ArrayList<String> arrList) throws IOException{
        Game games = new Game();
        int indexEnd;
        String moveNum = "";
        int indexStart = 0;
        char[] dts;
        StringBuilder strBuil = new StringBuilder();
        strBuil.append(arrList.get(0));
        for(int i = 0; i < strBuil.length(); i++){
            if(strBuil.charAt(i) == '|'){
                indexEnd = i;
                dts = new char[indexEnd - indexStart];
                strBuil.getChars(indexStart, indexEnd, dts, 0);
                games.addPlayer(new String(dts).toUpperCase());
                indexStart = i + 1;
            }else if(strBuil.charAt(i) == ':'){
                indexEnd = i;
                dts = new char[indexEnd - indexStart];
                strBuil.getChars(indexStart, indexEnd, dts, 0);
                moveNum = new String(dts).toUpperCase();
            }
        }
        strBuil = new StringBuilder();
        strBuil.append(arrList.get(arrList.size()-1));
        indexStart = 0;
        int[] numPrm = new int[3];
        int count = 0;
        for(int j = 0; j < strBuil.length(); j++){
            String str = new String();
            if(strBuil.charAt(j) == '|' || strBuil.charAt(j) == ';'){
                indexEnd = j;
                dts = new char[indexEnd - indexStart];
                strBuil.getChars(indexStart, indexEnd, dts, 0);
                str = new String(dts).toUpperCase();
                indexStart = j + 1;
                numPrm[count] = Integer.valueOf(str);
                count++;
            }
        }
        int indexPl = numPrm[0];
        int candis = numPrm[2];
        int movePl = numPrm[1];
        System.out.println("Ход игрока " + games.getPlayer(0).toString());
        System.out.println(movePl);
        System.out.println("Оставшееся количество конфет " + candis);
        switch (moveNum) {
            case "1":
                model.movePlayer(games, candis, save, indexPl);
                break;
            case "2":
                model.moveRobot(games, candis, save, indexPl);
                break;
            default:
                System.out.println("Такой команды нет");
        }
    }
}
