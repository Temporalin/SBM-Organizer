package model.request;

/**
 * @author Nicholas Hauschild
 *         Date: 5/16/13
 *         Time: 11:36 PM
 */
public class ListMatchRequest {
    private final String tournamentUrlPath;
    private final String state;
    private final Integer participantId;

    public ListMatchRequest(final String tournamentUrlPath, final String state, final Integer participantId) {
        this.tournamentUrlPath = tournamentUrlPath;
        this.state = state;
        this.participantId = participantId;
    }

    public String getTournamentUrlPath() {
        return tournamentUrlPath;
    }

    public String getState() {
        return state;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public static class Builder {
        private final String tournamentUrlPath;
        private String state;
        private Integer participantId;

        public Builder(final String tournamentUrlPath) {
            this.tournamentUrlPath = tournamentUrlPath;
        }

        public Builder withState(final String state) {
            this.state = state;
            return this;
        }

        public Builder withParticipantId(final Integer participantId) {
            this.participantId = participantId;
            return this;
        }

        public ListMatchRequest build() {
            return new ListMatchRequest(tournamentUrlPath, state, participantId);
        }
    }
}
