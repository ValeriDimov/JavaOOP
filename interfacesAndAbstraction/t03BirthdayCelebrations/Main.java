package interfacesAndAbstraction.t03BirthdayCelebrations;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        //Map<String, List<Birthable>> birthMap = new HashMap<>();
        List<Birthable> citizensAndPets = new ArrayList<>();

        while (!input.equals("End")) {
            String[] inputDetails = input.split("\\s+");
            String typeClass = inputDetails[0];

            switch (typeClass) {
                case "Citizen":
                    String citizenName = inputDetails[1];
                    int citizenAge = Integer.parseInt(inputDetails[2]);
                    String citizenId = inputDetails[3];
                    String citizenBirthdate = inputDetails[4];
                    Citizen citizen = new Citizen(citizenName, citizenAge, citizenId, citizenBirthdate);
                    citizensAndPets.add(citizen);
//                    birthMap.putIfAbsent(currentYear, new ArrayList<>());
//                    birthMap.get(currentYear).add(citizen);
                    break;
                case "Robot":
                    String model = inputDetails[1];
                    String robotId = inputDetails[2];
                    Robot robot = new Robot(robotId, model);
                    break;
                case "Pet":
                    String petName = inputDetails[1];
                    String petBirthdate = inputDetails[2];
                    Pet pet = new Pet(petName, petBirthdate);
                    citizensAndPets.add(pet);
//                    birthMap.putIfAbsent(currentYear, new ArrayList<>());
//                    birthMap.get(currentYear).add(pet);
                    break;
            }

            input = scanner.nextLine();
        }

        String yearToCheck = scanner.nextLine();
        for (Birthable citizensAndPet : citizensAndPets) {
            if (citizensAndPet.getBirthDate().endsWith(yearToCheck)) {
                System.out.println(citizensAndPet.getBirthDate());
            }
        }

//        birthMap.entrySet()
//                .stream()
//                .filter(e -> e.getKey().equals(yearToCheck))
//                .forEach(e -> e.getValue().forEach(p -> {
//                    System.out.println(p.getBirthDate());
//                }));

    }
}
