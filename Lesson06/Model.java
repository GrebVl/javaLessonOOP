package Lesson06;

import java.util.Random;

import Lesson06.Preservation.WriteSave;
import java.io.IOException;

public class Model {
    public static int numMax = 28;
    private Random rnd = new Random();
    private InputScanner input;

    Model(){
        rnd = new Random();
        input = new InputScanner();
    }

    public void movePlayer(Game gem, int candis, WriteSave save, int moves) throws IOException{
        input.getInput();
        for(int j = moves; j < gem.sizePlayer(); j++){
            System.out.println("Ход игрока " + gem.getPlayer(j).toString());
            int num = this.inputNamberGame(candis);
            candis -= num;
            System.out.println("Оставшееся количество конфет " + candis);
            save.writeSave(num, candis, j);
        }
        while(candis > 0){
            for(int i = 0; i < gem.sizePlayer(); i++){
                System.out.println("Ход игрока " + gem.getPlayer(i).toString());
                int num = this.inputNamberGame(candis);
                candis -= num;
                System.out.println("Оставшееся количество конфет " + candis);
                save.writeSave(num, candis, i);
            }
        }
    }

    public void moveRobot(Game gem, int candis, WriteSave save, int moves) throws IOException{
        InputScanner input = new InputScanner();
        input.getInput();
        int move = moves;
        while(candis > 0){
            if(move == 0){
                System.out.println("Ход игрока " + gem.getPlayer(0).toString());
                int num = this.inputNamberGame(candis);
                candis -= num;
                save.writeSave(num, candis, move);
                move = 1;
            }else if(move == 1){
                System.out.println("Ход игрока " + gem.getPlayer(1).toString());
                int num = inputNamberRobot(candis);
                System.out.println(num);
                candis -= num;
                save.writeSave(num, candis, move);
                move = 0;
            }
            System.out.println("Оставшееся количество конфет " + candis);
        }
    }

    public int inputNamberRobot(int candis){
        if(candis < numMax){
            System.out.println("Победил робот");
            return candis;
        }else if(candis < numMax*2){
            return candis - numMax - 1;
        }else{
            return rnd.nextInt(27) + 1;
        }
    }

    public int inputNamberGame(int candis){
        boolean exNum = true;
        int num = -1;
        while(exNum){
            num = input.inputNumber("число от 0 до 28");
            if(num > 0 && num < 29 && num <= candis){
                exNum = false;
                if(num == candis){
                    System.out.println("Победа");
                }
                return num;
            }else{
                System.out.println("Введите число повторно");
            }
        }
        return num;
    }
}
