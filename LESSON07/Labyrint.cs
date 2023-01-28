namespace LESSON07
{
    public class Labyrint
    {
        private int[,] labyrints;
        private int[] dotStart;
        private int[] dotFinish;
        private Random rand;
        private int count;

        public Labyrint(int size)
        {
            labyrints = new int[size, size];
            dotStart = new int[2];
            dotFinish = new int[2];
            count = size;
            rand = new Random();
            this.resLabyrint();
        }

        public int[] pointStart
        {
            get { return dotStart; }
            set { dotStart = value; }
        }

        public int[] pointFinish
        {
            get { return dotFinish; }
            set { dotFinish = value; }
        }

        public int[,] mapLabyrint
        {
            get { return labyrints; }
            set { labyrints = value; }
        }

        public int sizeLibyrint
        {
            get { return count; }
            set { count = value; }
        }


        public void resLabyrint()
        {
            if (this.count > 3)
            {
                for (int i = 0; i < this.count; i++)
                {
                    for (int j = 0; j < this.count; j++)
                    {
                        if (i == 0 || j == 0 || i == count - 1 || j == count - 1)
                        {
                            this.labyrints[i, j] = -1;
                        }
                        else
                        {
                            this.labyrints[i, j] = 0;
                        }
                    }
                }

                for (int k = 0; k < this.count * 2; k++)
                {
                    bool ex = true;
                    while (ex)
                    {
                        int line = rand.Next(this.count);
                        int column = rand.Next(this.count);
                        if (this.labyrints[line, column] != -1)
                        {
                            if (this.labyrints[line - 1, column - 1] != -1
                            && this.labyrints[line - 1, column + 1] != -1
                            || this.labyrints[line + 1, column - 1] != -1
                            && this.labyrints[line + 1, column + 1] != -1)
                            {
                                this.labyrints[line, column] = -1;
                                ex = false;
                            }
                        }
                    }
                }
                this.dotPoint();
                this.printLabyrint();
            }
        }

        public void dotPoint()
        {
            int size = count - 2;
            int num = count / 2;
            bool ex = true;
            while (ex)
            {
                dotStart[0] = rand.Next(1, num);
                dotStart[1] = rand.Next(1, num);
                dotFinish[0] = rand.Next(num, size) + 1;
                dotFinish[1] = rand.Next(num, size) + 1;
                if (dotStart[0] != dotFinish[0] && dotStart[1] != dotFinish[1])
                {
                    if (this.passageCheck(dotStart) && this.passageCheck(dotFinish))
                    {
                        labyrints[dotStart[0], dotStart[1]] = 1;
                        labyrints[dotFinish[0], dotFinish[1]] = 100;
                        ex = false;
                    }
                }
            }
        }

        private bool passageCheck(int[] location)
        {
            if (this.labyrints[location[0] + 1, location[1]] != -1 && this.labyrints[location[0], location[1] + 1] != -1)
            {
                return true;
            }
            else if ((this.labyrints[location[0] - 1, location[1]] != -1 && this.labyrints[location[0], location[1] - 1] != -1))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public void printLabyrint()
        {
            for (var i = 0; i < this.count; i++)
            {
                for (int j = 0; j < this.count; j++)
                {
                    if (this.labyrints[i, j] == -1)
                    {
                        Console.ForegroundColor = ConsoleColor.Yellow;
                        Console.Write(" # ");
                        Console.ResetColor();
                    }
                    else if (i == dotStart[0] && j == dotStart[1])
                    {
                        Console.ForegroundColor = ConsoleColor.Blue;
                        Console.Write(" s ");
                        Console.ResetColor();
                    }
                    else if (i == dotFinish[0] && j == dotFinish[1])
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.Write(" f ");
                        Console.ResetColor();
                    }
                    else if (this.labyrints[i, j] == 150)
                    {
                        Console.ForegroundColor = ConsoleColor.Green;
                        Console.Write(" p ");
                        Console.ResetColor();
                    }
                    else if(this.labyrints[i, j] == 0)
                    {
                        Console.Write("   ");
                    }else{
                        Console.Write(" {0} ", this.labyrints[i, j]);
                    }
                }
                Console.WriteLine();
            }
            Console.WriteLine();
        }
    }
}