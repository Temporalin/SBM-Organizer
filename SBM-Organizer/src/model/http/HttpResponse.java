package model.http;

import java.util.List;
import java.util.Map;

/**
 * @author Nicholas Hauschild
 *         Date: 5/12/13
 *         Time: 7:13 PM
 */
public class HttpResponse {
    private final int statusCode;
    private final String body;
    private final Map<String, List<String>> headers;

    public HttpResponse(int statusCode, String body, Map<String, List<String>> headers) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }
}
