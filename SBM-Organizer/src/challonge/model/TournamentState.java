package challonge.model;

/**
 * @author Nicholas Hauschild
 *         Date: 5/11/13
 *         Time: 11:33 PM
 */
public enum TournamentState {
    ALL("all"), PENDING("pending"), IN_PROGRESS("in_progress"), UNDERWAY("underway"),
    AWAITING_REVIEW("awaiting_review"), ENDED("ended");

    private final String queryParamValue;
    private final String bodyValue;

    private TournamentState(final String paramValue) {
        this.queryParamValue = paramValue;
        this.bodyValue = paramValue.replace('_', ' ');
    }

    public String getQueryParamValue() {
        return queryParamValue;
    }

    public String getBodyValue() {
        return bodyValue;
    }
}
