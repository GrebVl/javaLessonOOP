package Lesson06;
import java.util.List;
import java.util.ArrayList;

public class Game {
    private List<Player> names;

    public Game(){
        names = new ArrayList<>();
    }

    public int sizePlayer(){
        return names.size();
    }

    public Player getPlayer(int index) {
        return names.get(index);
    }

    public void addPlayer(String name){
        names.add(new Player(name));
        names.get(names.size()-1).initNumber(names.size());
    }

    public void addRobot(){
        names.add(new Player("Robot"));
        names.get(names.size()-1).initNumber(names.size());
    }
}
