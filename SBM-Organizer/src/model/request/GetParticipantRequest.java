package model.request;

/**
 * @author Nicholas Hauschild
 *         Date: 5/15/13
 *         Time: 11:54 PM
 */
public class GetParticipantRequest {
    private final String tournamentUrlPath;
    private final int participantId;
    private final Boolean includeMatches;

    public GetParticipantRequest(final String tournamentUrlPath, final int participantId,
                                 final Boolean includeMatches) {
        this.tournamentUrlPath = tournamentUrlPath;
        this.participantId = participantId;
        this.includeMatches = includeMatches;
    }

    public String getTournamentUrlPath() {
        return tournamentUrlPath;
    }

    public int getParticipantId() {
        return participantId;
    }

    public Boolean isIncludeMatches() {
        return includeMatches;
    }

    public static class Builder {
        private final String tournamentUrlPath;
        private final int participantId;
        private Boolean includeMatches;

        public Builder(final String tournamentUrlPath, final int participantId) {
            this.tournamentUrlPath = tournamentUrlPath;
            this.participantId = participantId;
        }

        public Builder doIncludeMatches(Boolean includeMatches) {
            this.includeMatches = includeMatches;
            return this;
        }

        public GetParticipantRequest build() {
            return new GetParticipantRequest(tournamentUrlPath, participantId, includeMatches);
        }
    }
}
