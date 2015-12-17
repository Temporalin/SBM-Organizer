package challonge.request;

import challonge.model.TournamentState;
import challonge.model.TournamentType;

import java.util.Date;

/**
 * @author Nicholas Hauschild
 *         Date: 5/11/13
 *         Time: 11:31 PM
 */
public class ListTournamentRequest {
    private final TournamentState state;
    private final TournamentType type;
    private final Date createdAfter;
    private final Date createdBefore;
    private final String subdomain;

    public ListTournamentRequest(final TournamentState state, final TournamentType type,
                                 final Date createdAfter, final Date createdBefore, final String subdomain) {
        this.state = state;
        this.type = type;
        this.createdAfter = createdAfter;
        this.createdBefore = createdBefore;
        this.subdomain = subdomain;
    }

    public TournamentState getState() {
        return state;
    }

    public TournamentType getType() {
        return type;
    }

    public Date getCreatedAfter() {
        return createdAfter;
    }

    public Date getCreatedBefore() {
        return createdBefore;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public static class Builder {
        private TournamentState state;
        private TournamentType type;
        private Date createdAfter;
        private Date createdBefore;
        private String subdomain;

        public Builder withState(final TournamentState state) {
            this.state = state;
            return this;
        }

        public Builder withType(final TournamentType type) {
            this.type = type;
            return this;
        }

        public Builder createdBefore(final Date beforeDate) {
            this.createdBefore = beforeDate;
            return this;
        }

        public Builder createdAfter(final Date afterDate) {
            this.createdAfter = afterDate;
            return this;
        }

        public Builder withSubdomain(final String subdomain) {
            this.subdomain = subdomain;
            return this;
        }

        public ListTournamentRequest build() {
            return new ListTournamentRequest(state, type, createdAfter, createdBefore, subdomain);
        }
    }
}
