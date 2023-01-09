package lesson04;
import java.util.List;
import java.util.ArrayList;

public class MouseGo extends Labyrinth{

    public void mouseGo(){
        
        int[][] newLab = this.labyrinth;
        int count = 1;
        int[] indexFinish = this.getFinish();
        while(newLab[indexFinish[0]][indexFinish[1]] == 100){
            for(int i = 1; i < newLab.length - 1; i++){
                for(int j = 1; j < newLab.length - 1; j++){
                    if(newLab[i][j] == count){
                        if(newLab[i-1][j] != -1 && newLab[i-1][j] == 0 || newLab[i-1][j] == 100){
                            newLab[i-1][j] = count + 1;
                        }
                        if(newLab[i+1][j] != -1 && newLab[i+1][j] == 0 || newLab[i+1][j] == 100){
                            newLab[i+1][j] = count + 1;
                        }
                        if(newLab[i][j-1] != -1 && newLab[i][j-1] == 0 || newLab[i][j-1] == 100){
                            newLab[i][j-1] = count + 1;
                        }
                        if(newLab[i][j+1] != -1 && newLab[i][j+1] == 0 || newLab[i][j+1] == 100){
                            newLab[i][j+1] = count + 1;
                        }
                    }
                }
            }
            count++;
        }
        this.printLabyrinth(newLab);
    }

    public void mouseWay(){
        int[][] lab = this.labyrinth;
        int[] indexFinish = this.getFinish();
        int count = lab[indexFinish[0]][indexFinish[1]];
        if(lab[indexFinish[0]][indexFinish[1]] != 100){
            List<int[]> mWay = new ArrayList<>();
            mWay.add(indexFinish);
            int i = indexFinish[0];
            int j = indexFinish[1];
            while(count != 1){
                if(lab[i-1][j] != -1 && lab[i-1][j] == count - 1){
                    i-=1;
                }
                else if(lab[i+1][j] != -1 && lab[i+1][j] == count - 1){
                    i+=1;
                }else if(lab[i][j-1] != -1 && lab[i][j-1] == count - 1){
                    j-=1;
                }else if(lab[i][j+1] != -1 && lab[i][j+1] == count - 1){
                    j+=1;
                }
                int[] k = {i, j};
                mWay.add(k);
                count--;
            }
            for(int h = 1; h < mWay.size()-1; h++){
                lab[mWay.get(h)[0]][mWay.get(h)[1]] = 150;
            }
            this.printLabyrinth(lab);
        }
    }    
}
