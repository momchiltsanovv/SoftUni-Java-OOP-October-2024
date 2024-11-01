package Birthday_Celebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split("\\s+");
        List<Birthable> birthables = new ArrayList<>();
        while (!tokens[0].equals("End")) {

            switch (tokens[0]) {
                case "Pet" -> {
                    String name = tokens[1];
                    String birthDate = tokens[2];
                    Pet pet = new Pet(name, birthDate);
                    birthables.add(pet);
                }
                case "Robot" -> {
                    String model = tokens[1];
                    String id = tokens[2];
                    Robot robot = new Robot(model, id);
                }
                case "Citizen" -> {
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDate = tokens[4];
                    Citizen citizen = new Citizen(name, age, id, birthDate);
                    birthables.add(citizen);
                }
            }


            tokens = sc.nextLine().split("\\s+");
        }

        String year = sc.nextLine();

        birthables.stream()
                  .filter(birthable -> birthable.getBirthDate()
                                                .endsWith(year))
                  .forEach(birthable -> System.out.println(birthable.getBirthDate()));

    }
}
