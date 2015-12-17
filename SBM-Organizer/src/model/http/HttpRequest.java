package model.http;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Nicholas Hauschild
 *         Date: 5/12/13
 *         Time: 6:13 PM
 */
public class HttpRequest {
    private final String endpoint;
    private final HttpMethod method;
    private final Map<String, String> headers;
    private final Map<String, String> queryParams;
    private final Map<String, String> bodyParams;

    public HttpRequest(final String endpoint, final HttpMethod method, final Map<String, String> headers,
                       final Map<String, String> queryParams, final Map<String, String> bodyParams) {
        this.endpoint = endpoint;
        this.method = method;
        this.headers = headers;
        this.queryParams = queryParams;
        this.bodyParams = bodyParams;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public Map<String, String> getBodyParams() {
        return bodyParams;
    }

    public static class Builder {
        private final String endpoint;
        private HttpMethod method = HttpMethod.GET;
        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> queryParams = new HashMap<>();
        private Map<String, String> bodyParams = new HashMap<>();

        public Builder(final String endpoint) {
            this.endpoint = endpoint;
        }

        public Builder withMethod(final HttpMethod method) {
            this.method = method;
            return this;
        }

        public Builder withHeader(final String key, final String value) {
            headers.put(key, value);
            return this;
        }

        public Builder withQueryParam(final String key, final String value) {
            queryParams.put(key, value);
            return this;
        }

        public Builder withBodyParam(final String key, final String value) {
            this.bodyParams.put(key, value);
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(endpoint, method, headers, queryParams, bodyParams);
        }
    }
}
