package model.http;

/**
 * @author Nicholas Hauschild
 *         Date: 5/12/13
 *         Time: 6:14 PM
 */
public enum HttpMethod {
    GET(false), POST(true), HEAD(false), OPTIONS(true), DELETE(false), PUT(true), TRACE(true);

    final boolean bodySupported;

    private HttpMethod(final boolean bodySupported) {
        this.bodySupported = bodySupported;
    }

    public boolean isBodySupported() {
        return bodySupported;
    }
}
