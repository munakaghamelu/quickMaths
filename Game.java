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
        if (target1.suit == "Joker") jokerInNumberDeck = true;
        else {
            totalTarget = Integer.parseInt(target1.value) + Integer.parseInt(target2.value);
        }
    }


}