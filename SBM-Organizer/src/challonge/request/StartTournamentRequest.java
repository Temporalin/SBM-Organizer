package challonge.request;

/**
 * @author Nicholas Hauschild
 *         Date: 5/15/13
 *         Time: 10:29 PM
 */
public class StartTournamentRequest {
    private final String urlPath;
    private final Boolean includeParticipants;
    private final Boolean includeMatches;

    public StartTournamentRequest(final String urlPath, final Boolean includeParticipants, final Boolean includeMatches) {
        this.urlPath = urlPath;
        this.includeParticipants = includeParticipants;
        this.includeMatches = includeMatches;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public Boolean isIncludeParticipants() {
        return includeParticipants;
    }

    public Boolean isIncludeMatches() {
        return includeMatches;
    }

    public static class Builder {
        private final String urlPath;
        private Boolean includeParticipants;
        private Boolean includeMatches;

        public Builder(final String urlPath) {
            this.urlPath = urlPath;
        }

        public Builder doIncludeParticipants(final Boolean includeParticipants) {
            this.includeParticipants = includeParticipants;
            return this;
        }

        public Builder doIncludeMatches(final Boolean includeMatches) {
            this.includeMatches = includeMatches;
            return this;
        }

        public StartTournamentRequest build() {
            return new StartTournamentRequest(urlPath, includeParticipants, includeMatches);
        }
    }
}
