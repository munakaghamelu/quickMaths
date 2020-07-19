import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

public class Game {

    // Need a full deck of cards, that contains contants

    public ArrayList<Card> fullDeck = new ArrayList<Card>();

    public static final String[] RANKS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};

    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Stack<Card> spareDeck = new Stack<Card>();

    public Stack<Card> numberDeck = new Stack<Card>();

    public Card target1 = null;
    
    public Card target2 = null;

    public int totalTarget = 0;

    public boolean jokerInNumberDeck = false;

    public boolean jokerInHand = false;

    // Joker is a special card, so add at the end - red + black joker

    public void createFullDeck() {
        for (String value : RANKS) {
            for (String suit : SUITS) {
                fullDeck.add(new Card(value, suit));
            }
        }
        fullDeck.add(new Card("Joker", "Red"));
        fullDeck.add(new Card("Joker", "Black"));
    }

    // Divide the full Deck into: Spare Deck + Number Deck
    // Shuffle the dull deck and then split

    public void divideFullDeck() {
        Collections.shuffle(fullDeck);
        for (int i = 0; i < 10; i++) {
            numberDeck.push(fullDeck.get(i));
        }
        for (int i = 10; i < fullDeck.size(); i++) {
            spareDeck.push(fullDeck.get(i));
        }
    }

    // Allocate 2 cards from the numberDeck to target 1 + 2

    public void takeFromNumberDeck() {
        target1 = numberDeck.pop();
        target2 = numberDeck.pop();
        if (target1.suit == "Joker" || target2.suit == "Joker") jokerInNumberDeck = true;
        else {
            totalTarget = target1.getValue() + target2.getValue();
        }
    }

    /**
     * Option 1 - Pick up from spare deck
     * Option 2 - Swap card with player
     * Option 3 - Check from quick math
     */

    // Allocate 3 cards from the spare deck to each player - Used for option 1 and to fill player's hand intially

    public void pickUpFromSpare(Player player) {
        while (player.getCount() != 3 && !spareDeck.empty()) {
            player.addToHand(spareDeck.pop());
        }
        if (spareDeck.isEmpty()) {
            // Need to have an empty deck exception thrown here
            System.out.println("Spare deck has no cards left!");
        }
    }

    // Swap a card with player

    

    public static void main(String[] args) {
        Game newGame = new Game();
        Player player1 = new Player();
        Player player2 = new Player();
        newGame.createFullDeck();
        newGame.divideFullDeck();
        newGame.takeFromNumberDeck();

        System.out.println(newGame.target1.toString());
        System.out.println(newGame.target2.toString());
        System.out.println(newGame.totalTarget);
    }

}