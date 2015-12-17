package model.request;

import model.model.MatchScore;

import java.util.List;

/**
 * @author Nicholas Hauschild
 *         Date: 5/17/13
 *         Time: 12:03 AM
 */
public class UpdateMatchRequest {
    private final String tournamentUrlPath;
    private final int matchId;
    private final List<MatchScore> matchScores;
    private final Integer winnerId;
    private final Boolean tie;
    private final Integer playerOneVotes;
    private final Integer playerTwoVotes;

    public UpdateMatchRequest(final String tournamentUrlPath, final int matchId, final List<MatchScore> matchScores,
                              final Integer winnerId, final Boolean tie, final Integer playerOneVotes, final Integer playerTwoVotes) {
        this.tournamentUrlPath = tournamentUrlPath;
        this.matchId = matchId;
        this.matchScores = matchScores;
        this.winnerId = winnerId;
        this.tie = tie;
        this.playerOneVotes = playerOneVotes;
        this.playerTwoVotes = playerTwoVotes;
    }

    public String getTournamentUrlPath() {
        return tournamentUrlPath;
    }

    public int getMatchId() {
        return matchId;
    }

    public List<MatchScore> getMatchScores() {
        return matchScores;
    }

    public Integer getWinnerId() {
        return winnerId;
    }

    public Boolean isTie() {
        return tie;
    }

    public Integer getPlayerOneVotes() {
        return playerOneVotes;
    }

    public Integer getPlayerTwoVotes() {
        return playerTwoVotes;
    }

    public static class Builder {
        private final String tournamentUrlPath;
        private final int matchId;
        private List<MatchScore> matchScores;
        private Integer winnerId;
        private Boolean tie;
        private Integer playerOneVotes;
        private Integer playerTwoVotes;

        public Builder(final String tournamentUrlPath, final int matchId) {
            this.tournamentUrlPath = tournamentUrlPath;
            this.matchId = matchId;
        }

        public Builder withMatchScores(final List<MatchScore> matchScores) {
            this.matchScores = matchScores;
            return this;
        }

        public Builder withWinnerId(final Integer winnerId) {
            this.winnerId = winnerId;
            if(winnerId != null) {
                this.tie = null;
            }
            return this;
        }

        public Builder doTie(final Boolean tie) {
            this.tie = tie;
            if(tie) {
               this.winnerId = null;
            }
            return this;
        }

        public Builder withPlayerOneVotes(final Integer playerOneVotes) {
            this.playerOneVotes = playerOneVotes;
            return this;
        }

        public Builder withPlayerTwoVotes(final Integer playerTwoVotes) {
            this.playerTwoVotes = playerTwoVotes;
            return this;
        }

        public UpdateMatchRequest build() {
            return new UpdateMatchRequest(tournamentUrlPath, matchId, matchScores, winnerId, tie, playerOneVotes,
                    playerTwoVotes);
        }
    }
}
