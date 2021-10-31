package abstraction.t03CardsWithPower;

public class Card {
    private RankPowers rankPowers;
    private SuitPowers suitPowers;

    public Card(RankPowers rankPowers, SuitPowers suitPowers) {
        this.rankPowers = rankPowers;
        this.suitPowers = suitPowers;
    }

    public String printCard(String cardName, String cardSuit) {
        return String.format("Card name: %s of %s; Card power: %d",
                RankPowers.valueOf(cardName), SuitPowers.valueOf(cardSuit),
                RankPowers.valueOf(cardName).getPowerOfRank() + SuitPowers.valueOf(cardSuit).getPowerOfSuits());
    }
}
