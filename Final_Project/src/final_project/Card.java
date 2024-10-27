package final_project;

/**
 *
 * @author Ben Turner
 */
public class Card {
    private final String face; // face of card
    private final String suit; // suit of card
    
    //two-argument constructor initializes card's face and suit
    public Card(String cardFace, String cardSuit) {
        this.face = cardFace; // initialize face of card
        this.suit = cardSuit; // initialize suit of card
    }
    
    // return String representation of Card
    @Override
    public String toString() {
        return face + " of " + suit;
    }

    public String getFace() {
        return face;
    }
    
}

