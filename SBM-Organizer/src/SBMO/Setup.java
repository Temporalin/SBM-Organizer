package SBMO;

import challonge.model.Match;
import challonge.model.Participant;

public class Setup {
    private int number;
    private String name;
    private Participant one;
    private Participant two;
    private Match match;

    public Setup(int number, String name, Participant one, Participant two, Match match) {
        this.number = number;
        this.name = name;
        this.one = one;
        this.two = two;
        this.match = match;
    }
    
    public Setup(int number, Participant one, Participant two, Match match) {
        this.number = number;
        this.name = "Setup "+number;
        this.one = one;
        this.two = two;
        this.match = match;
    }

    
    /* GET SET */
    
    // *** SETS SOBRAN?
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
