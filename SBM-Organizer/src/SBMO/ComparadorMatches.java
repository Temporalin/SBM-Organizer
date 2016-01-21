package SBMO;

import challonge.model.Match;
import java.util.Comparator;

public class ComparadorMatches implements Comparator<Match> {

    @Override
    public int compare(Match o1, Match o2) {
        Integer p1 = ((Match) o1).getRound();
        Integer p2 = ((Match) o2).getRound();
        int comparador = p1.compareTo( p2 );    
        return comparador;
    }
}
