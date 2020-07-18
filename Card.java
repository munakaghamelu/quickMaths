public class Card {

    String suit;
    String value;

    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public String toString() {
        if (Integer.parseInt(this.value) == 1) return "Ace of " + this.suit;
        else if (Integer.parseInt(this.value) == 11) return "Jack of " + this.suit;
        else if (Integer.parseInt(this.value) == 12) return "Queen of " + this.suit;
        else if (Integer.parseInt(this.value) == 13) return "King of " + this.suit;
        else return this.value + " of " + this.suit;
    }

}