namespace LESSON07
{
    using System.Collections.Generic;
    using System.Collections;
    public class Wave
    {
        private Labyrint lb;
        private int[] start;
        private int[] finish;
        public Wave(int size){
            lb = new Labyrint(size);
            //start = new int[2];
            start = lb.pointStart;
            //finish = new int[2];
            finish = lb.pointFinish;
        }
        public void exitWave()
        {
            int[,] newLab = lb.mapLabyrint;
            int count = newLab[start[0], start[1]];
            while (newLab[finish[0], finish[1]] == 100)
            {
                for (int i = 1; i < lb.sizeLibyrint  - 1; i++)
                {
                    for (int j = 1; j < lb.sizeLibyrint  - 1; j++)
                    {
                        if (newLab[i, j] == count)
                        {
                            if (newLab[i - 1, j] != -1 && newLab[i - 1, j] == 0 || newLab[i - 1, j] == 100)
                            {
                                newLab[i - 1, j] = count + 1;
                            }
                            if (newLab[i + 1, j] != -1 && newLab[i + 1, j] == 0 || newLab[i + 1, j] == 100)
                            {
                                newLab[i + 1, j] = count + 1;
                            }
                            if (newLab[i, j - 1] != -1 && newLab[i, j - 1] == 0 || newLab[i, j - 1] == 100)
                            {
                                newLab[i, j - 1] = count + 1;
                            }
                            if (newLab[i, j + 1] != -1 && newLab[i, j + 1] == 0 || newLab[i, j + 1] == 100)
                            {
                                newLab[i, j + 1] = count + 1;
                            }
                        }
                    }
                }
                count++;
            }
            lb.mapLabyrint = newLab;
            lb.printLabyrint();
        }
        public void entryWvae()
        {
            int[,] lab = lb.mapLabyrint;
            int count = lab[finish[0], finish[1]];
            if (lab[finish[0], finish[1]] != 100)
            {
                ArrayList mWay = new ArrayList();
                ArrayList arr = new ArrayList();
                arr.Add(finish[0]);
                arr.Add(finish[1]);
                mWay.Add(arr);
                int i = finish[0];
                int j = finish[1];
                while (count != 1)
                {
                    if (lab[i - 1, j] != -1 && lab[i - 1, j] == count - 1)
                    {
                        i -= 1;
                    }
                    else if (lab[i + 1, j] != -1 && lab[i + 1, j] == count - 1)
                    {
                        i += 1;
                    }
                    else if (lab[i, j - 1] != -1 && lab[i, j - 1] == count - 1)
                    {
                        j -= 1;
                    }
                    else if (lab[i, j + 1] != -1 && lab[i, j + 1] == count - 1)
                    {
                        j += 1;
                    }
                    arr = new ArrayList();
                    arr.Add(i);
                    arr.Add(j);
                    mWay.Add(arr);
                    count--;
                }
                
                int[] point = new int[2];
                int index = 0;
                foreach(ArrayList arrPoint in mWay)
                {
                    foreach(Object obj in arrPoint){
                        point[index] = (int)obj;
                        index++;
                    }
                    index = 0;
                    lab[point[0] , point[1]] = 150;
                }
                lb.mapLabyrint = lab;
                lb.printLabyrint();
            }
        }
    }
}