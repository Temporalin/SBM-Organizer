package model.request;

/**
 * @author Nicholas Hauschild
 *         Date: 5/14/13
 *         Time: 12:58 AM
 */
public class GetTournamentRequest {
    private final String urlPath;
    private final Boolean includeParticipants;
    private final Boolean includeMatches;

    public GetTournamentRequest(String urlPath, Boolean includeParticipants, Boolean includeMatches) {
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

        public Builder(String urlPath) {
            this.urlPath = urlPath;
        }

        public Builder doIncludeParticipants(Boolean includeParticipants) {
            this.includeParticipants = includeParticipants;
            return this;
        }

        public Builder doIncludeMatches(Boolean includeMatches) {
            this.includeMatches = includeMatches;
            return this;
        }

        public GetTournamentRequest build() {
            return new GetTournamentRequest(urlPath, includeParticipants, includeMatches);
        }
    }
}
