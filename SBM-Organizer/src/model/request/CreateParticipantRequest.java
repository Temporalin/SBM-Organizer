package model.request;

/**
 * @author Nicholas Hauschild
 *         Date: 5/15/13
 *         Time: 11:09 PM
 */
public class CreateParticipantRequest {
    private final String tournamentUrlPath;
    private final String name;
    private final String challongeUsername;
    private final String email;
    private final Integer seed;
    private final String misc;

    public CreateParticipantRequest(final String tournamentUrlPath, final String name, final String challongeUsername,
                                    final String email, final Integer seed, final String misc) {
        this.tournamentUrlPath = tournamentUrlPath;
        this.name = name;
        this.challongeUsername = challongeUsername;
        this.email = email;
        this.seed = seed;
        this.misc = misc;
    }

    public String getTournamentUrlPath() {
        return tournamentUrlPath;
    }

    public String getName() {
        return name;
    }

    public String getChallongeUsername() {
        return challongeUsername;
    }

    public String getEmail() {
        return email;
    }

    public Integer getSeed() {
        return seed;
    }

    public String getMisc() {
        return misc;
    }

    public static class Builder {
        private final String tournamentUrlPath;
        private final String name;
        private String challongeUsername;
        private String email;
        private Integer seed;
        private String misc;

        public Builder(final String tournamentUrlPath, final String name) {
            this.tournamentUrlPath = tournamentUrlPath;
            this.name = name;
        }

        public Builder withChallongeUsername(final String challongeUsername) {
            this.challongeUsername = challongeUsername;
            return this;
        }

        public Builder withEmail(final String email) {
            this.email = email;
            return this;
        }

        public Builder withSeed(final Integer seed) {
            this.seed = seed;
            return this;
        }

        public Builder withMisc(final String misc) {
            this.misc = misc;
            return this;
        }

        public CreateParticipantRequest build() {
            return new CreateParticipantRequest(tournamentUrlPath, name, challongeUsername, email, seed, misc);
        }
    }
}
