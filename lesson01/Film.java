package lesson01;
import java.util.ArrayList;

public class Film {
    protected String name;
    protected String relData;
    protected String genre;
    protected String director;
    protected String rating;

    public Film(){
    }

    public Film(String str){
        ArrayList<String> arrLst = new ArrayList<>();
        int start;
            int end;
            char[] dst;
            int index = 0; 
            for(int j = 0; j < str.length(); j++){
                start = index;
                if(str.charAt(j) == ':'){
                    end = j;
                    dst = new char[end - start];
                    str.getChars(start, end, dst, 0);
                    String nameStr = new String(dst);
                    arrLst.add(nameStr.trim());
                    index = j + 1;
                }else if(str.charAt(j) == ',' || str.charAt(j) == ';'){
                    end = j;
                    dst = new char[end - start];
                    str.getChars(start, end, dst, 0);
                    String nameStr = new String(dst);
                    arrLst.add(nameStr.trim());
                    index = j + 1;
                }
            }
            name = arrLst.get(0);
            relData = arrLst.get(1);
            genre = arrLst.get(2);;
            director = arrLst.get(3);
            rating = arrLst.get(4);
    }
    
    public String getInfo(){
        return String.format("%s, дата выхода %s, жанр %s, режисер %s, рейтинг %s",
                name, relData, genre, director, rating);
    }

    public boolean nameFlm(String nameF){
        if(this.name == nameF){
            return true;
        }else if(nameF.length() >= 0) {
            for(int i = 0; i < nameF.length(); i++){
                if(name.charAt(i) != nameF.charAt(i)){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }

    
}
