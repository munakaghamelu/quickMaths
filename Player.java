import java.util.Stack;

public class Player {

    Stack<Card> hand = new Stack<Card>();
    Stack<Card> winningHands = new Stack<Card>();
    Stack<Card> trash = new Stack<Card>();

    int count = 0;
    int totalWinnings = 0;

    public Player() {

    }

    public void resetPlayer() {
        while (!hand.empty()) hand.pop();
        while (!winningHands.empty()) hand.pop();
        while (!trash.empty()) hand.pop();
        count = 0;
        totalWinnings = 0;
    }

    public void addToHand(Card card) {
        if ( count != 3) {
            hand.push(card);
            count++;
        }
    }

    public Card removeFromHand() {
        if (!hand.isEmpty()) {
            return hand.pop();
        }
        else return null;
    }

    public int getCount() {
        return count;
    }

    public void addToWinningHands(Card card) {
        winningHands.push(card);
    }

    public int countWinnings() {
        while (!winningHands.empty()) {
            winningHands.pop();
            totalWinnings++;
        }
        return totalWinnings;
    }

    public void addToTrash(Card card) {
        trash.push(card);
    }
}