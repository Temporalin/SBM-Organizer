package model.request;

/**
 * @author Nicholas Hauschild
 *         Date: 5/15/13
 *         Time: 11:03 PM
 */
public class ListParticipantRequest {
    private final String tournamentUrlPath;

    public ListParticipantRequest(final String tournamentUrlPath) {
        this.tournamentUrlPath = tournamentUrlPath;
    }

    public String getTournamentUrlPath() {
        return tournamentUrlPath;
    }
}
