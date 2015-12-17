package challonge.request;

/**
 * @author Nicholas Hauschild
 *         Date: 5/16/13
 *         Time: 11:57 PM
 */
public class GetMatchRequest {
    private final String tournamentUrlPath;
    private final int matchId;

    public GetMatchRequest(final String tournamentUrlPath, final int matchId) {
        this.tournamentUrlPath = tournamentUrlPath;
        this.matchId = matchId;
    }

    public String getTournamentUrlPath() {
        return tournamentUrlPath;
    }

    public int getMatchId() {
        return matchId;
    }
}
