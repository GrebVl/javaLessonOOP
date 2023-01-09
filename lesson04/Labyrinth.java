package lesson04;

import java.util.Random;

public abstract class Labyrinth {
    public int[][] labyrinth;
    private int[] dotStart;
    private int[] dotFinish;

    public void resLab(int size){
        this.labyrinth = new int[size][size];
        if(size > 3){
            Random rnd = new Random();
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(i == 0 || i == size - 1){
                        this.labyrinth[i][j] = -1;
                    }else if(j == 0 || j == size - 1){
                        this.labyrinth[i][j] = -1;
                    }else{
                        this.labyrinth[i][j] = 0;
                    }
                }
            }
            int walls = size * 3;
            for(int k = 0; k < walls; k++){
                this.labyrinth[rnd.nextInt(size - 1) + 1][rnd.nextInt(size - 1) + 1] = -1;
            }
            this.mouseStart();
        }
    }

    public void mouseStart(){
        Random rnd = new Random();
        int size = labyrinth.length - 2;
        dotStart = new int[2];
        dotFinish = new int[2];
        boolean ex = true;
        while(ex){
            dotStart[0] = rnd.nextInt(size) + 1;
            dotStart[1] = rnd.nextInt(size) + 1;
            dotFinish[0] = rnd.nextInt(size) + 1;
            dotFinish[1] = rnd.nextInt(size) + 1;
            if(dotStart[0] != dotFinish[0] && dotStart[1] != dotFinish[1]){
                if(this.passageCheck(dotStart) && this.passageCheck(dotFinish)){
                    labyrinth[dotStart[0]][dotStart[1]] = 1;
                    labyrinth[dotFinish[0]][dotFinish[1]] = 100;
                    ex = false;
                }
            }
        }
    }

    private boolean passageCheck(int[] location){
        if(this.labyrinth[location[0] + 1][location[1]] != -1 && this.labyrinth[location[0]][location[1] + 1] != -1){
            return true;
        }else if((this.labyrinth[location[0] - 1][location[1]] != -1 && this.labyrinth[location[0]][location[1] - 1] != -1)){
            return true;
        }else{
            return false;
        }
    }

    public int[] getStart(){
        return dotStart;
    }

    public int[] getFinish(){
        return dotFinish;
    }

    public void printLabyrinth(int[][] lab){
        for(int i = 0; i < lab.length; i++){
            for(int j = 0 ; j < lab.length; j++){
                if(lab[i][j] == -1){
                    System.out.print(" # ");
                }else if(lab[i][j] == 1){
                    System.out.print(" s ");
                }else if(lab[i][j] == 100 || dotFinish[0] == i && dotFinish[1] == j){
                    System.out.print(" f ");
                }else if(lab[i][j] > 1 && lab[i][j] < 100){
                    System.out.print(" " + lab[i][j] + " ");
                }else if(lab[i][j] == 150){
                    System.out.print(" p ");
                }else{
                System.out.print("   ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

