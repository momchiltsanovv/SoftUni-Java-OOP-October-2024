package hierarchy;

public class Animal {
    private String name;
    private int age;
    private String gender;


    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }


    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
            this.gender = gender;
            return;
        }
        throw new IllegalArgumentException("Invalid input!");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }


    public String produceSound() {return "";}

    @Override
    public String toString() {
        return String.format("""
                             %s
                             %s %d %s
                             %s""",
                             super.getClass().getSimpleName(),
                             this.name,
                             this.age,
                             this.gender,
                             this.produceSound());
    }
}
