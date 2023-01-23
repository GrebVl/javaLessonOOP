package Lesson06;

public class Player {
    private String names;
    private int serialNumber;
    
    public Player(String name){
        names = name;
    }

    public void initNumber(int number){
        serialNumber = number;
    }

    public String getName() {
        return names;
    }

    public void setName(String name) {
        this.names = name;
    }

    @Override
    public String toString() {
        return String.format("%d  %s", serialNumber, names);
    }
}
