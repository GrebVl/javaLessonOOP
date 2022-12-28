package lesson02;
import java.util.ArrayList;

public class FamilyTies extends Human{
    private Human father;
    private Human mother;
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
        this.father = father;
        this.mother = mother;          
    }

    public void initFather(Human father){
        this.father = father;
    }
    public void initMother(Human mother){
        this.mother = mother;
    }

    public void infoParent(){
        if(mother != null){
            System.out.printf("Мать %s %s %s %s %s\n",
             mother.surname, mother.name, mother.patronymic, mother.gender, mother.dateOfBirth);
        }if(father != null){
            System.out.printf("Отец %s %s %s %s %s\n",
             father.surname, father.name, father.patronymic, father.gender, father.dateOfBirth);
        }else if(mother == null || father == null){
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
            System.out.printf("Муж %s %s %s %s %s\n",
            husband.surname, husband.name, husband.patronymic, husband.gender, husband.dateOfBirth);
        }else if(wife != null){
            System.out.printf("Жена %s %s %s %s %s\n",
            wife.surname, wife.name, wife.patronymic, wife.gender, wife.dateOfBirth);
        }else{
            System.out.println("Вбраке не состоит");
        }
    }

    public void getInfoChild(){
        if(son.size() != 0){
            for(int i = 0; i < son.size(); i++){
                System.out.printf("Сын %s %s %s %s %s\n",
                 son.get(i).surname, son.get(i).name, son.get(i).patronymic, son.get(i).gender, son.get(i).dateOfBirth);
            }
        }if(daughter.size() != 0){
            for(int i = 0; i < daughter.size(); i++){
                System.out.printf("Дочь %s %s %s %s %s\n",
                daughter.get(i).surname, daughter.get(i).name, daughter.get(i).patronymic, daughter.get(i).gender, daughter.get(i).dateOfBirth);
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
                System.out.printf("Брат %s %s %s %s %s\n",
                brother.get(i).surname, brother.get(i).name, brother.get(i).patronymic, brother.get(i).gender, brother.get(i).dateOfBirth);
            }
        }if(sister.size() != 0){
            for(int i = 0; i < sister.size(); i++){
                System.out.printf("Сестра %s %s %s %s %s\n",
                sister.get(i).surname, sister.get(i).name, sister.get(i).patronymic, sister.get(i).gender, sister.get(i).dateOfBirth);
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
