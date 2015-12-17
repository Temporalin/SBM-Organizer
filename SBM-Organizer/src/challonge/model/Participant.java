package challonge.model;

import java.util.Date;
import java.util.List;

/**
 * @author Nicholas Hauschild
 *         Date: 5/14/13
 *         Time: 8:01 PM
 */
public class Participant {
    private final boolean active;
    private final boolean checkedIn;
    private final Date createdAt;
    private final int finalRank;
    private final int groupId;
    private final String icon;
    private final int id;
    private final int invitationId;
    private final String inviteEmail;
    private final String misc;
    private final String name;
    private final boolean onWaitingList;
    private final int seed;
    private final int tournamentId;
    private final Date updatedAt;
    private final String challongeUsername;
    private final String challongeEmailAddressVerified;
    private final List<Match> matches;

    public Participant(final boolean active, final boolean checkedIn, final Date createdAt,
                       final int finalRank, final int groupId, final String icon, final int id,
                       final int invitationId, final String inviteEmail, final String misc,
                       final String name, final boolean onWaitingList, final int seed,
                       final int tournamentId, final Date updatedAt, final String challongeUsername,
                       final String challongeEmailAddressVerified, final List<Match> matches) {
        this.active = active;
        this.checkedIn = checkedIn;
        this.createdAt = createdAt;
        this.finalRank = finalRank;
        this.groupId = groupId;
        this.icon = icon;
        this.id = id;
        this.invitationId = invitationId;
        this.inviteEmail = inviteEmail;
        this.misc = misc;
        this.name = name;
        this.onWaitingList = onWaitingList;
        this.seed = seed;
        this.tournamentId = tournamentId;
        this.updatedAt = updatedAt;
        this.challongeUsername = challongeUsername;
        this.challongeEmailAddressVerified = challongeEmailAddressVerified;
        this.matches = matches;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getFinalRank() {
        return finalRank;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getIcon() {
        return icon;
    }

    public int getId() {
        return id;
    }

    public int getInvitationId() {
        return invitationId;
    }

    public String getInviteEmail() {
        return inviteEmail;
    }

    public String getMisc() {
        return misc;
    }

    public String getName() {
        return name;
    }

    public boolean isOnWaitingList() {
        return onWaitingList;
    }

    public int getSeed() {
        return seed;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getChallongeUsername() {
        return challongeUsername;
    }

    public String getChallongeEmailAddressVerified() {
        return challongeEmailAddressVerified;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public static class Builder {
        private boolean active;
        private boolean checkedIn;
        private Date createdAt;
        private int finalRank;
        private int groupId;
        private String icon;
        private int id;
        private int invitationId;
        private String inviteEmail;
        private String misc;
        private String name;
        private boolean onWaitingList;
        private int seed;
        private int tournamentId;
        private Date updatedAt;
        private String challongeUsername;
        private String challongeEmailAddressVerified;
        private List<Match> matches;

        public Builder doActive(final boolean active) {
            this.active = active;
            return this;
        }

        public Builder doCheckedIn(final boolean checkedIn) {
            this.checkedIn = checkedIn;
            return this;
        }

        public Builder withCreatedAt(final Date createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder withFinalRank(final int finalRank) {
            this.finalRank = finalRank;
            return this;
        }

        public Builder withGroupId(final int groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder withIcon(final String icon) {
            this.icon = icon;
            return this;
        }

        public Builder withId(final int id) {
            this.id = id;
            return this;
        }

        public Builder withInvitationId(final int invitationId) {
            this.invitationId = invitationId;
            return this;
        }

        public Builder withInviteEmail(final String inviteEmail) {
            this.inviteEmail = inviteEmail;
            return this;
        }

        public Builder withMisc(final String misc) {
            this.misc = misc;
            return this;
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder doOnWaitingList(final boolean onWaitingList) {
            this.onWaitingList = onWaitingList;
            return this;
        }

        public Builder withSeed(final int seed) {
            this.seed = seed;
            return this;
        }

        public Builder withTournamentId(final int tournamentId) {
            this.tournamentId = tournamentId;
            return this;
        }

        public Builder withUpdatedAt(final Date updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder withChallongeUsername(final String challongeUsername) {
            this.challongeUsername = challongeUsername;
            return this;
        }

        public Builder withChallongeEmailAddressVerified(final String challongeEmailAddressVerified) {
            this.challongeEmailAddressVerified = challongeEmailAddressVerified;
            return this;
        }

        public Builder withMatches(final List<Match> matches) {
            this.matches = matches;
            return this;
        }

        public Participant build() {
            return new Participant(active, checkedIn, createdAt, finalRank, groupId, icon, id, invitationId,
                    inviteEmail, misc, name, onWaitingList, seed, tournamentId, updatedAt, challongeUsername,
                    challongeEmailAddressVerified, matches);
        }
    }
}
