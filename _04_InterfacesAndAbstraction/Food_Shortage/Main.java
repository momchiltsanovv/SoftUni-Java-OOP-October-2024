package Food_Shortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());
        Map<String, Buyer> buyers = new HashMap<>();

        handlingInput(num, sc, buyers);
        readingBuyers(sc, buyers);

        int sum = buyers.values()
                        .stream()
                        .mapToInt(Buyer::getFood)
                        .sum();

        System.out.println(sum);
    }

    private static void handlingInput(int num, Scanner sc, Map<String, Buyer> buyers) {
        for (int i = 0; i < num; ++i) {
            String[] input = sc.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            if (input.length == 4) {
                String id = input[2];
                String birthdate = input[3];
                Citizen citizen = new Citizen(name, age, id, birthdate);
                buyers.putIfAbsent(name, citizen);
            } else {
                String group = input[2];
                Rebel rebel = new Rebel(name, age, group);
                buyers.putIfAbsent(name, rebel);
            }
        }
    }

    private static void readingBuyers(Scanner sc, Map<String, Buyer> buyers) {
        String buyer = sc.nextLine();
        while (!buyer.equals("End")) {
            Buyer buyer1 = buyers.get(buyer);

            if(buyer1 != null) {
                buyer1.buyFood();
            }
            buyer = sc.nextLine();
        }
    }
}
