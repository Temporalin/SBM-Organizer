package challonge.model;

/**
 * @author Nicholas Hauschild
 *         Date: 5/11/13
 *         Time: 11:37 PM
 */
public enum TournamentType {
    SINGLE_ELIMINATION("single_elimination"), DOUBLE_ELIMINATION("double_elimination"), ROUND_ROBIN("round_robin"), SWISS("swiss");

    private final String queryParamValue;
    private final String bodyValue;

    private TournamentType(final String paramValue) {
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
