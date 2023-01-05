package lesson03;
import java.util.HashMap;
import java.util.Map;

public class InitHuman {
    public Map<Integer, FamilyTies> getInitHuman(){
        Map<Integer, FamilyTies> mapHuman = new HashMap<>();
        String[] surnames = {"Иванов", "Иванова"};
        String[] names = {"Сергей", "Иван", "Андрей"};
        String[] patronymics = {"Сергеевич", "Андреевна", "Владимировна", "Михайловна", "Иванович"};

        FamilyTies h1 = new FamilyTies(
            surnames[0], names[0], patronymics[0], 0, "12.08.1952");
        FamilyTies h2 = new FamilyTies(
            surnames[1], "Татьяна", patronymics[2], 1, "08.08.1952");
        h1.initStatus(h2);
        h2.initStatus(h1);

        FamilyTies h3 = new FamilyTies(
            surnames[0], names[1], patronymics[0], 0, "09.09.1971");
        h1.initChild(h3);
        h2.initChild(h3);
        h3.initParent(h1, h2);

        FamilyTies h4 = new FamilyTies(
            surnames[1], "Елена", patronymics[2], 1, "10.10.1972");
        h3.initStatus(h4);
        h4.initStatus(h3);

        FamilyTies h5 = new FamilyTies(
            surnames[0], names[2], patronymics[4], 0, "15.07.1995");
        h3.initChild(h5);
        h4.initChild(h5);
        h5.initParent(h3, h4);

        FamilyTies h6 = new FamilyTies(
            surnames[0], "Никита", patronymics[4], 0, "14.01.1998");
        h3.initChild(h6);
        h4.initChild(h6);
        h6.initParent(h3, h4);
        h5.initBroOrSister(h6);
        h6.initBroOrSister(h5);

        FamilyTies h7 = new FamilyTies(
            surnames[1], "Дарья", patronymics[3], 1, "17.12.1996");
        h5.initStatus(h7);
        h7.initStatus(h5);

        FamilyTies h8 = new FamilyTies(
            surnames[1], "Мария", patronymics[1], 1, "10.05.2020");
        h8.initParent(h5, h7);
        h5.initChild(h8);
        h7.initChild(h8);






        mapHuman.put(h1.getId(), h1);
        mapHuman.put(h2.getId(), h2);
        mapHuman.put(h3.getId(), h3);
        mapHuman.put(h4.getId(), h4);
        mapHuman.put(h5.getId(), h5);
        mapHuman.put(h6.getId(), h6);
        mapHuman.put(h7.getId(), h7);
        mapHuman.put(h8.getId(), h8);

        return mapHuman;

    }
    
}
