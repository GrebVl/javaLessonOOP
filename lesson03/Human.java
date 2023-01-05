package lesson03;

public abstract class Human {
    protected String surname;
    protected String name;
    protected String patronymic;
    protected String gender;
    protected String dateOfBirth;
    private Integer id;

    public static int count = 0;
    public static String[] typesGenders = {"М", "Ж"}; 

    protected Human(String surname, String name, String patronymic, int intGender,
                String dateOfBirth){
        count++;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.gender = initGender(intGender);
        this.dateOfBirth = dateOfBirth;
        this.id = count;

    }
    public Human(){
        count++;
        this.id = count;
    }

    public Integer getId(){
        return this.id;
    }

    public String initGender(int index){
        return typesGenders[index];
    }


    public void getInfo(){
        System.out.printf("%s %s %s %s %s\n",
         surname, name, patronymic, gender, dateOfBirth);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s\n",
        surname, name, patronymic, gender, dateOfBirth);
    }
}
