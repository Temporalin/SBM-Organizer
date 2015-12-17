package model.model;

/**
 * @author Nicholas Hauschild
 *         Date: 5/14/13
 *         Time: 10:50 PM
 */
public class MatchScore {
    private final int playerOneScore;
    private final int playerTwoScore;

    public MatchScore(final int playerOneScore, final int playerTwoScore) {
        this.playerOneScore = playerOneScore;
        this.playerTwoScore = playerTwoScore;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    @Override
    public String toString() {
        return playerOneScore + "-" + playerTwoScore;
    }
}
