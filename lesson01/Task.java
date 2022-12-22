/**
 * Прошу вас написать приложение,
 * 1. которое хранит информацию о фильмах
 * 2. позволяет получaть все детали о них.
 * 3. реализовать поиск по части имени фильма
 * 
 * Основа: проектирование
 * в конце семинара объяснение
 */
package lesson01;
import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * Task
 */
public class Task {
    public static void main(String[] args) throws IOException{
        ArrayList<String> arrFile = new ArrayList<>();
        file arF = new file();
        arrFile = arF.readFile("lesson01/Film.txt");

        Map<String, Film> mapFilm = new HashMap<>();

        Film flm0 = new Film(arrFile.get(0));
        mapFilm.put(flm0.name, flm0);
        Film flm1 = new Film(arrFile.get(1));
        mapFilm.put(flm1.name, flm1);
        Film flm2 = new Film(arrFile.get(2));
        mapFilm.put(flm2.name, flm2);
        Film flm3 = new Film(arrFile.get(3));
        mapFilm.put(flm3.name, flm3);
        Film flm4 = new Film(arrFile.get(4));
        mapFilm.put(flm4.name, flm4);
        Film flm5 = new Film(arrFile.get(5));
        mapFilm.put(flm5.name, flm5);
        Film flm6 = new Film(arrFile.get(6));
        mapFilm.put(flm6.name, flm6);
        
        Set<String> keys = mapFilm.keySet();
        boolean exFerst = true;
        Scanner imput = new Scanner(System.in);
        while(exFerst){
            System.out.println("Фильмотека:\n1. Общий списко фильмов,\n" +
                             "2. Информация по имени мильма,\n" +
                             "3. Выход.\nВведите число для перехода: ");
            int numMen = imput.nextInt();
            if(numMen == 1){
                commonListMenu(mapFilm);
            }else if(numMen == 2){
                nameSearch(mapFilm, keys);
            }else if(numMen == 3){
                exFerst = false;
            }else{
                System.out.println("Введено не верное значение");
            }
        }
        imput.close();
    }      
    
    public static void nameSearch(Map<String, Film> mapFlm, Set<String> keys){
        System.out.println("Введите название фильма: ");
        Scanner scn = new Scanner(System.in);
        String nFlm = scn.nextLine();
        int count = 0;
        for(Object k : keys){
            if(mapFlm.get(k).nameFlm(nFlm)){
                System.out.println(mapFlm.get(k).getInfo());
            }else{
                count++;
            }
        }
        if(count == mapFlm.size()){
            System.out.printf("Фильма с названием %s не имеется\n", nFlm);
        }
    }

    public static void commonListMenu(Map<String, Film> mapFlm){
        for(Map.Entry<String, Film> item : mapFlm.entrySet()){
            System.out.printf("%s\n", item.getKey());
        }
    }
}