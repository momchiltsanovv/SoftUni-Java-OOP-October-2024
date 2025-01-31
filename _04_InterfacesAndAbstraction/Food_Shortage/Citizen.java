package Food_Shortage;

public class Citizen implements Person, Identifiable, Birthable, Buyer {
    private final String name;
    private final int age;
    private final String id;
    private final String birthDate;
    private int food = 0;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food += 10;
    }

    @Override
    public String getBirthDate() {
        return this.birthDate;
    }

}
