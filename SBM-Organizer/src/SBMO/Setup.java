package SBMO;

import challonge.model.Match;
import challonge.model.Participant;

public class Setup {
    
    private int number;
    private Participant one;
    private Participant two;
    private Match match;
    
    public Setup(int number, Participant one, Participant two, Match match) {
        this.number = number;
        this.one = one;
        this.two = two;
        this.match = match;
    }

    /* GET SET */
    public int getNumber() {
        return number;
    }

    public Participant getOne() {
        return one;
    }

    public void setOne(Participant one) {
        this.one = one;
    }

    public Participant getTwo() {
        return two;
    }

    public void setTwo(Participant two) {
        this.two = two;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }  
}
