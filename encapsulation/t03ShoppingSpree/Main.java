package encapsulation.t03ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        String[] allPeople = scanner.nextLine().split(";");
        for (String p : allPeople) {
            String[] personData = p.split("=");
            String personName = personData[0];
            double personMoney = Double.parseDouble(personData[1]);
            try {
                Person person = new Person(personName, personMoney);
                people.put(personName, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String[] allProducts = scanner.nextLine().split(";");
        for (String prod : allProducts) {
            String[] productData = prod.split("=");
            String productName = productData[0];
            double productCost = Double.parseDouble(productData[1]);
            try {
                Product product = new Product(productName, productCost);
                products.put(productName, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] commandsSplit = command.split("\\s+");
            String commandPerson = commandsSplit[0];
            String commandProduct = commandsSplit[1];

            try {
                Person currentPerson = people.get(commandPerson);
                Product currentProduct = products.get(commandProduct);
                currentPerson.buyProduct(currentProduct);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = scanner.nextLine();
        }

        people.entrySet().stream().forEach(p -> {
            System.out.printf("%s - ", p.getKey());
            List<String> printProds = new ArrayList<>();
            for (var element : p.getValue().getProducts()) {
                printProds.add(element.getName());
            }
            if (printProds.isEmpty()) {
                System.out.println("Nothing bought");
            } else {
                System.out.println(String.join(", ", printProds));
            }
        });
    }
}
