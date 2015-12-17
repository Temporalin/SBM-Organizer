package model.request;

/**
 * @author Nicholas Hauschild
 *         Date: 5/15/13
 *         Time: 10:49 PM
 */
public class ResetTournamentRequest {
    private final String urlPath;
    private final Boolean includeParticipants;

    public ResetTournamentRequest(final String urlPath, final Boolean includeParticipants) {
        this.urlPath = urlPath;
        this.includeParticipants = includeParticipants;
    }

    public String getUrlPath() {
        return urlPath;
    }

    public Boolean isIncludeParticipants() {
        return includeParticipants;
    }

    public static class Builder {
        private final String urlPath;
        private Boolean includeParticipants;

        public Builder(final String urlPath) {
            this.urlPath = urlPath;
        }

        public Builder doIncludeParticipants(final Boolean includeParticipants) {
            this.includeParticipants = includeParticipants;
            return this;
        }

        public ResetTournamentRequest build() {
            return new ResetTournamentRequest(urlPath, includeParticipants);
        }
    }
}
