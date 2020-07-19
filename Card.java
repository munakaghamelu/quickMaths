public class Card {

    String suit;
    String value;

    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue(){
        return Integer.parseInt(this.value);
    }

    public String toString() {
        if (Integer.parseInt(this.value) == 1) return "Ace of " + this.suit;
        else if (this.getValue() == 11) return "Jack of " + this.suit;
        else if (this.getValue() == 12) return "Queen of " + this.suit;
        else if (this.getValue() == 13) return "King of " + this.suit;
        else return this.value + " of " + this.suit;
    }

}