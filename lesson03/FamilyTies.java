package lesson03;
import java.util.ArrayList;

public class FamilyTies extends Human{
    private Human fathers;
    private Human mothers;
    private Human husband;
    private Human wife;
    private ArrayList<Human> son = new ArrayList<>();
    private ArrayList<Human> daughter = new ArrayList<>();
    private ArrayList<Human> brother = new ArrayList<>();
    private ArrayList<Human> sister = new ArrayList<>();

    public FamilyTies(String surname, String name, String patronymic, int gender,
    String dateOfBirth){
        super(surname, name, patronymic, gender, dateOfBirth);       
    }

    public FamilyTies(){          
    }

    public void initParent(Human father, Human mother){
        this.fathers = father;
        this.mothers = mother;
    }

    public void initFather(Human father){
        this.fathers = father;
    }
    public void initMother(Human mother){
        this.mothers = mother;
    }

    public void infoParent(){
        if(mothers != null){
            System.out.print("Мать " + mothers.toString());
        }if(fathers != null){
            System.out.print("Отец " + fathers.toString());
        }else if(mothers == null || fathers == null){
            System.out.println("Информация о родителе отсутствует");
        }
    }

    public ArrayList<Human> getDaughter(){
        return this.daughter;
    }

    public ArrayList<Human> getSon(){
        return this.son;
    }

    public void initChild(Human child){
        if(child.gender == typesGenders[0]){
            this.son.add(child);
        }else if(child.gender == typesGenders[1]){
            this.daughter.add(child);
        }
    }

    public void initStatus(Human spouse){
        if(spouse.gender == typesGenders[0]){
            this.husband = spouse;
        }else if(spouse.gender == typesGenders[1]){
            this.wife = spouse;
        }
    }

    public void getInfoStatus(){
        if(husband != null){
            System.out.print("Муж " + husband.toString());
        }else if(wife != null){
            System.out.printf("Жена " + wife.toString());
        }else{
            System.out.println("Вбраке не состоит");
        }
    }

    public void getInfoChild(){
        if(son.size() != 0){
            for(int i = 0; i < son.size(); i++){
                System.out.print("Сын " + son.get(i).toString());
            }
        }if(daughter.size() != 0){
            for(int i = 0; i < daughter.size(); i++){
                System.out.print("Дочь " + daughter.get(i).toString());
            }
        }else if(son.size() == 0 && daughter.size() == 0){
            System.out.println("Детей не имеет");
        }
    }

    public void initBroOrSister(FamilyTies BroOrSister){
        if(BroOrSister.gender == typesGenders[0]){
            this.brother.add(BroOrSister);
        }else if(BroOrSister.gender == typesGenders[1]){
            this.sister.add(BroOrSister);
        }
    }

    public void getInfoBroAndSister(){
        if(brother.size() != 0){
            for(int i = 0; i < brother.size(); i++){
                System.out.print("Брат " + brother.get(i).toString());
            }
        }if(sister.size() != 0){
            for(int i = 0; i < sister.size(); i++){
                System.out.print("Сестра " + sister.get(i).toString());
            }
        }else if(brother.size() == 0 && sister.size() == 0){
            System.out.println("Братьев и сестер не имеет");
        }
    }

    public void getInfoComplete(){
        super.getInfo();
        this.infoParent();
        this.getInfoBroAndSister();
        this.getInfoStatus();
        this.getInfoChild();
    }   
}
