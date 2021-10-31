package abstraction.t03CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardName = scanner.nextLine();
        String suitName = scanner.nextLine();

        Card card = new Card(RankPowers.valueOf(cardName), SuitPowers.valueOf(suitName));

        System.out.println(card.printCard(cardName, suitName));
    }
}
