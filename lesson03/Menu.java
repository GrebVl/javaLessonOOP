package lesson03;
import java.util.Map;
import java.util.Set;

public class Menu {
    public Menu(){
        InitHuman mapH = new InitHuman();
        Map<Integer, FamilyTies> mapHuman = mapH.getInitHuman();
        Set<Integer> keys = mapHuman.keySet();
        boolean ex = true;
        InputDataScanner scn = new InputDataScanner();
        scn.getInput();
        while(ex){
            System.out.print("\n Генеологическое древо\n" +
                "1.Вывод общих данных с порядковым номером\n" +
                "2. Вывод полных данных всех членов семьи\n" +
                "3. Вывод данных по порядковому номеру\n" +
                "4. Выход\n" + "Введите номер  ");
            int input = scn.inputNumber();
            if(input == 1){
                for(Object k : keys){
                    System.out.printf("%d: ", mapHuman.get(k).getId());
                    mapHuman.get(k).getInfo();
                }
            }else if(input == 2){
                for(Object k : keys){
                    System.out.printf("\n%d: ", mapHuman.get(k).getId());
                    mapHuman.get(k).getInfoComplete();
                }
            }else if(input == 3){
                System.out.println("Введите порядковый номер  ");
                int index = scn.inputNumber();
                mapHuman.get(index).getInfoComplete();
            }else if(input == 4){
                System.out.println("Завершение работы");
                ex = false;
                scn.closeInput();
            }else{
                System.out.println("Введен не верный номер");
            }   
        }
    }

}
