package challonge.model;

import java.util.Date;
import java.util.List;

/**
 * @author Nicholas Hauschild
 *         Date: 5/14/13
 *         Time: 8:00 PM
 */
public class Match {
    private final Date createdAt;
    private final int groupId;
    private final boolean hasAttachment;
    private final int id;
    private final String identifier;
    private final int loserId;
    private final int playerOneId;
    private final boolean playerOneIsPrereqMatchLoser;
    private final int playerOnePrereqMatchId;
    private final int playerOneVotes;
    private final int playerTwoId;
    private final boolean playerTwoIsPrereqMatchLoser;
    private final int playerTwoPrereqMatchId;
    private final int playerTwoVotes;
    private final int round;
    private final Date startedAt;
    private final String state;
    private final int tournamentId;
    private final Date updatedAt;
    private final int winnerId;
    private final List<Integer> prereqMatchIds;
    private final List<MatchScore> scores;

    public Match(final Date createdAt, final int groupId, final boolean hasAttachment,
                 final int id, final String identifier, final int loserId, final int playerOneId,
                 final boolean playerOneIsPrereqMatchLoser, final int playerOnePrereqMatchId,
                 final int playerOneVotes, final int playerTwoId, final boolean playerTwoIsPrereqMatchLoser,
                 final int playerTwoPrereqMatchId, final int playerTwoVotes, final int round,
                 final Date startedAt, final String state, final int tournamentId, final Date updatedAt,
                 final int winnerId, final List<Integer> prereqMatchIds, final List<MatchScore> scores) {
        this.createdAt = createdAt;
        this.groupId = groupId;
        this.hasAttachment = hasAttachment;
        this.id = id;
        this.identifier = identifier;
        this.loserId = loserId;
        this.playerOneId = playerOneId;
        this.playerOneIsPrereqMatchLoser = playerOneIsPrereqMatchLoser;
        this.playerOnePrereqMatchId = playerOnePrereqMatchId;
        this.playerOneVotes = playerOneVotes;
        this.playerTwoId = playerTwoId;
        this.playerTwoIsPrereqMatchLoser = playerTwoIsPrereqMatchLoser;
        this.playerTwoPrereqMatchId = playerTwoPrereqMatchId;
        this.playerTwoVotes = playerTwoVotes;
        this.round = round;
        this.startedAt = startedAt;
        this.state = state;
        this.tournamentId = tournamentId;
        this.updatedAt = updatedAt;
        this.winnerId = winnerId;
        this.prereqMatchIds = prereqMatchIds;
        this.scores = scores;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getGroupId() {
        return groupId;
    }

    public boolean isHasAttachment() {
        return hasAttachment;
    }

    public int getId() {
        return id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getLoserId() {
        return loserId;
    }

    public int getPlayerOneId() {
        return playerOneId;
    }

    public boolean isPlayerOneIsPrereqMatchLoser() {
        return playerOneIsPrereqMatchLoser;
    }

    public int getPlayerOnePrereqMatchId() {
        return playerOnePrereqMatchId;
    }

    public int getPlayerOneVotes() {
        return playerOneVotes;
    }

    public int getPlayerTwoId() {
        return playerTwoId;
    }

    public boolean isPlayerTwoIsPrereqMatchLoser() {
        return playerTwoIsPrereqMatchLoser;
    }

    public int getPlayerTwoPrereqMatchId() {
        return playerTwoPrereqMatchId;
    }

    public int getPlayerTwoVotes() {
        return playerTwoVotes;
    }

    public int getRound() {
        return round;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public String getState() {
        return state;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public List<Integer> getPrereqMatchIds() {
        return prereqMatchIds;
    }

    public List<MatchScore> getScores() {
        return scores;
    }

    public static class Builder {
        private Date createdAt;
        private int groupId;
        private boolean hasAttachment;
        private int id;
        private String identifier;
        private int loserId;
        private int playerOneId;
        private boolean playerOneIsPrereqMatchLoser;
        private int playerOnePrereqMatchId;
        private int playerOneVotes;
        private int playerTwoId;
        private boolean playerTwoIsPrereqMatchLoser;
        private int playerTwoPrereqMatchId;
        private int playerTwoVotes;
        private int round;
        private Date startedAt;
        private String state;
        private int tournamentId;
        private Date updatedAt;
        private int winnerId;
        private List<Integer> prereqMatchIds;
        private List<MatchScore> scores;

        public Builder withCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder withGroupId(int groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder doHasAttachment(boolean hasAttachment) {
            this.hasAttachment = hasAttachment;
            return this;
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withIdentifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder withLoserId(int loserId) {
            this.loserId = loserId;
            return this;
        }

        public Builder withPlayerOneId(int playerOneId) {
            this.playerOneId = playerOneId;
            return this;
        }

        public Builder doPlayerOneIsPrereqMatchLoser(boolean playerOneIsPrereqMatchLoser) {
            this.playerOneIsPrereqMatchLoser = playerOneIsPrereqMatchLoser;
            return this;
        }

        public Builder withPlayerOnePrereqMatchId(int playerOnePrereqMatchId) {
            this.playerOnePrereqMatchId = playerOnePrereqMatchId;
            return this;
        }

        public Builder withPlayerOneVotes(int playerOneVotes) {
            this.playerOneVotes = playerOneVotes;
            return this;
        }

        public Builder withPlayerTwoId(int playerTwoId) {
            this.playerTwoId = playerTwoId;
            return this;
        }

        public Builder doPlayerTwoIsPrereqMatchLoser(boolean playerTwoIsPrereqMatchLoser) {
            this.playerTwoIsPrereqMatchLoser = playerTwoIsPrereqMatchLoser;
            return this;
        }

        public Builder withPlayerTwoPrereqMatchId(int playerTwoPrereqMatchId) {
            this.playerTwoPrereqMatchId = playerTwoPrereqMatchId;
            return this;
        }

        public Builder withPlayerTwoVotes(int playerTwoVotes) {
            this.playerTwoVotes = playerTwoVotes;
            return this;
        }

        public Builder withRound(int round) {
            this.round = round;
            return this;
        }

        public Builder withStartedAt(Date startedAt) {
            this.startedAt = startedAt;
            return this;
        }

        public Builder withState(String state) {
            this.state = state;
            return this;
        }

        public Builder withTournamentId(int tournamentId) {
            this.tournamentId = tournamentId;
            return this;
        }

        public Builder withUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder withWinnerId(int winnerId) {
            this.winnerId = winnerId;
            return this;
        }

        public Builder withPrereqMatchIds(List<Integer> prereqMatchIds) {
            this.prereqMatchIds = prereqMatchIds;
            return this;
        }

        public Builder withScores(List<MatchScore> scores) {
            this.scores = scores;
            return this;
        }

        public Match build() {
            return new Match(createdAt, groupId, hasAttachment, id, identifier, loserId, playerOneId,
                    playerOneIsPrereqMatchLoser, playerOnePrereqMatchId, playerOneVotes, playerTwoId,
                    playerTwoIsPrereqMatchLoser, playerTwoPrereqMatchId, playerTwoVotes, round, startedAt,
                    state, tournamentId, updatedAt, winnerId, prereqMatchIds, scores);
        }
    }
}
