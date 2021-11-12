package t04FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> allPeople = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);

            if (info.length == 4) {
                String id = info[2];
                String birthdate = info[3];
                Buyer citizen = new Citizen(name, age, id, birthdate);
                allPeople.putIfAbsent(name, citizen);

            } else if (info.length == 3) {
                String group = info[2];
                Buyer rebel = new Rebel(name, age, group);
                allPeople.putIfAbsent(name, rebel);
            }
        }

        String buyerName = scanner.nextLine();

        while (!buyerName.equals("End")) {
            if (allPeople.containsKey(buyerName)) {
                allPeople.get(buyerName).buyFood();
            }

            buyerName = scanner.nextLine();
        }

        int purchasedFood = 0;
        for (Buyer value : allPeople.values()) {
           purchasedFood += value.getFood();
        }

        System.out.println(purchasedFood);
    }
}
