package Birthday_Celebrations;

public class Pet implements Birthable {

    private final String name;
    private final String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;

    }

    public String getName() {
        return this.name;
    }


    @Override
    public String getBirthDate() {
        return birthDate;
    }
}
