package challonge.request;

/**
 * @author Nicholas Hauschild
 *         Date: 5/16/13
 *         Time: 11:13 PM
 */
public class DeleteParticipantRequest {
    private final String tournamentUrlPath;
    private final int participantId;

    public DeleteParticipantRequest(final String tournamentUrlPath, final int participantId) {
        this.tournamentUrlPath = tournamentUrlPath;
        this.participantId = participantId;
    }

    public String getTournamentUrlPath() {
        return tournamentUrlPath;
    }

    public int getParticipantId() {
        return participantId;
    }
}
