package abstraction.t01CardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String input = scanner.nextLine();

        System.out.println("Card Suits:");
        for (Suits suit : Suits.values()) {
            //Ordinal value: 0; Name value: CLUBS
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
        }

    }
}
