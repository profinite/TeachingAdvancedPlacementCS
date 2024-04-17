import java.util.*;
import static java.util.Comparator.comparing;

/* Challenge #7
 * Simulate a simple card game in Java for AP CS A 
 * ----
 * @author Tyler C de Laguna <tyler@delaguna.org> 
 * @copyright 2024 GPL3
 */
public class Casino {
    public static void main(String[] args) {
        new Casino().game();
    }
  
    void game()  {
        System.out.println("Welcome to the Arkham casino ♠ ♥ ♦ ♣ ♤ ♡ ♢ ♧");
        System.out.println("Let's play the world's most boring game!");
        List<Card> deck = createDeck();
        shuffle(deck);

        List<Player> table = List.of(new Player("Penguin 🐧", deck),
                                     new Player("Harley Quinn 👧", deck),
                                     new Player("Scarecrow 👨‍🌾", deck),
                                     new Player("𝕁𝕠𝕜𝕖𝕣 🤡", deck));
        System.out.println("Dealing to: " + table);

        Player winner = table.stream().max(comparing(Player::score)).orElse(table.get(0));
        System.out.println("We have a winner! 🏆 ");
        winner.show();
    }
  
    /* Shuffle by blindly drawing and reinserting individual cards */
    private void shuffle(List<Card> deck) {
        final int MINIMUM_DRAWS = 320;
        for(int i = 0; i < MINIMUM_DRAWS; i++) {
            Card selected = pickRandom(deck);
            deck.remove(selected);
            deck.add(selected);
        }
        Collections.shuffle(deck); // for good measure
    }
  
    /* Create an incomplete deck of 16 cards. */
    private List<Card> createDeck() {
        List<Card> deck = new ArrayList<>();
        for(Suit s : Suit.values()) {
            for(Rank r : Rank.values()) {
                deck.add(new Card(s, r));
            }
        }
        return deck;
    }
  
    /* Pick a card blindly from the deck */
    private Card pickRandom(List<Card> deck) {
        int index = new Random().nextInt(deck.size());
        return deck.get(index);
    }
 
    /* Simulate a card player (inner class)  */
    class Player {
        public final String name;
        List<Card> hand;
        Player(String name) {
            this.name = name;
        }
        Player(String name, List<Card> deck) {
            this.name = name;
            deal(deck);
        }
        private void deal(List<Card> deck) {
            final int CARD_LIMIT = 4;
            hand = new ArrayList<>(deck.subList(0, CARD_LIMIT));
            deck.removeAll(hand);
        }
        /* @return total rank of cards in the hand */
        public int score() {
            int score = 0;
            for(Card c : hand) 
              score += c.rank.value;
            return score;
        }
        public void show() {
            System.out.println(name + " has a total score of " + score() + ":");
            hand.forEach(System.out::println);
        }
        @Override
        public String toString() {
            return name;
        }
    }
    enum Suit {
        CLUB, DIAMOND, HEART, SPADE;
    }
    enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5);
        public final int value;
        Rank(int value) { this.value = value; }
    }
  
    /* Use a 'record' for simple classes */
    record Card(Suit suit, Rank rank) { }
}
