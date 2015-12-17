package challonge.request;

/**
 * @author Nicholas Hauschild
 *         Date: 5/16/13
 *         Time: 10:46 PM
 */
public class UpdateParticipantRequest {
    private final String tournamentUrlPath;
    private final int participantId;
    private final String name;
    private final Integer seed;
    private final String challongeUsername;
    private final String email;
    private final String misc;

    public UpdateParticipantRequest(final String tournamentUrlPath, final int participantId, final String name,
                                    final Integer seed, final String challongeUsername, final String email,
                                    final String misc) {
        this.tournamentUrlPath = tournamentUrlPath;
        this.participantId = participantId;
        this.name = name;
        this.seed = seed;
        this.challongeUsername = challongeUsername;
        this.email = email;
        this.misc = misc;
    }

    public String getTournamentUrlPath() {
        return tournamentUrlPath;
    }

    public int getParticipantId() {
        return participantId;
    }

    public String getName() {
        return name;
    }

    public Integer getSeed() {
        return seed;
    }

    public String getChallongeUsername() {
        return challongeUsername;
    }

    public String getEmail() {
        return email;
    }

    public String getMisc() {
        return misc;
    }

    public static class Builder {
        private final String tournamentUrlPath;
        private final int participantId;
        private String name;
        private Integer seed;
        private String challongeUsername;
        private String email;
        private String misc;

        public Builder(final String tournamentUrlPath, final int participantId) {
            this.tournamentUrlPath = tournamentUrlPath;
            this.participantId = participantId;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withSeed(final Integer seed) {
            this.seed = seed;
            return this;
        }

        public Builder withChallongeUsername(final String challongeUsername) {
            this.challongeUsername = challongeUsername;
            return this;
        }

        public Builder withEmail(final String email) {
            this.email = email;
            return this;
        }

        public Builder withMisc(final String misc) {
            this.misc = misc;
            return this;
        }

        public UpdateParticipantRequest build() {
            return new UpdateParticipantRequest(tournamentUrlPath, participantId, name, seed, challongeUsername, email,
                    misc);
        }
    }
}
