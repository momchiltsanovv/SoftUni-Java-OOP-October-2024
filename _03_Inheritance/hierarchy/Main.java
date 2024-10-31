package hierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String input = sc.nextLine();
        while (!input.equals("Beast!")) {
            String[] tokens = sc.nextLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];
            switch (input) {
                case "Cat" -> {
                    Cat cat = new Cat(name, age, gender);
                    System.out.println(cat);
                }
                case "Dog" -> {
                    Dog dog = new Dog(name, age, gender);
                    System.out.println(dog);
                }
                case "Frog" -> {
                    Frog frog = new Frog(name, age, gender);
                    System.out.println(frog);
                }
                case "Kitten" -> {
                    Kitten kitten = new Kitten(name, age);
                    System.out.println(kitten);
                }
                case "Tomcat" -> {
                    Tomcat tomcat = new Tomcat(name, age);
                    System.out.println(tomcat);
                }
            }

            input = sc.nextLine();
        }


    }
}
