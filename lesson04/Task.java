package lesson04;

public class Task {
    public static void main(String[] args) {
        MouseGo lb = new MouseGo();
        lb.resLab(10);
        lb.printLabyrinth(lb.labyrinth);
        lb.mouseGo();
        lb.mouseWay();
    }
}
