package model.request;

/**
 * @author Nicholas Hauschild
 *         Date: 5/15/13
 *         Time: 10:09 PM
 */
public class DeleteTournamentRequest {
    private final String urlPath;

    public DeleteTournamentRequest(final String urlPath) {
        this.urlPath = urlPath;
    }

    public String getUrlPath() {
        return urlPath;
    }
}
