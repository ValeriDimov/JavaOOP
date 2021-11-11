package interfacesAndAbstraction.t03BirthdayCelebrations;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Birthable>> birthMap = new HashMap<>();

        while (!input.equals("End")) {
            String[] inputDetails = input.split("\\s+");
            String typeClass = inputDetails[0];

            switch (typeClass) {
                case "Citizen":
                    String name = inputDetails[1];
                    int age = Integer.parseInt(inputDetails[2]);
                    String id = inputDetails[3];
                    String birthdate = inputDetails[4];
                    String[] bData = birthdate.split("/");
                    String currentYear = bData[2];
                    Birthable citizen = new Citizen(name, age, id, birthdate);
                    birthMap.putIfAbsent(currentYear, new ArrayList<>());
                    birthMap.get(currentYear).add(citizen);
                    break;
                case "Robot":
                    String model = inputDetails[1];
                    String robotId = inputDetails[2];
                    Robot robot = new Robot(robotId, model);
                    break;
                case "Pet":
                    name = inputDetails[1];
                    birthdate = inputDetails[2];
                    bData = birthdate.split("/");
                    currentYear = bData[2];
                    Birthable pet = new Pet(name, birthdate);
                    birthMap.putIfAbsent(currentYear, new ArrayList<>());
                    birthMap.get(currentYear).add(pet);
                    break;
            }

            input = scanner.nextLine();
        }

        String yearToCheck = scanner.nextLine();

        birthMap.entrySet()
                .stream()
                .filter(e -> e.getKey().equals(yearToCheck))
                .forEach(e -> e.getValue().forEach(p -> {
                    System.out.println(p.getBirthDate());
                }));

    }
}
