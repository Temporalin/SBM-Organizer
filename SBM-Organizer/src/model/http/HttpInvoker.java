package model.http;

import model.model.parser.ValidationErrorParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author Nicholas Hauschild
 *         Date: 5/12/13
 *         Time: 6:24 PM
 */
public class HttpInvoker {
    private final String encodedApiKey;
    private final ValidationErrorParser errorParser;

    public HttpInvoker(final String apiKey) {
        this.errorParser = new ValidationErrorParser();
        try {
            this.encodedApiKey = URLEncoder.encode(apiKey, "UTF-8");
        } catch(UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public HttpResponse invoke(final HttpRequest httpRequest) {
        HttpURLConnection conn = null;
        try {
            final StringBuilder queryParams = new StringBuilder("?api_key=" + encodedApiKey);
            for(Map.Entry<String, String> entry : httpRequest.getQueryParams().entrySet()) {
                final String encodedKey = URLEncoder.encode(entry.getKey(), "UTF-8");
                final String encodedValue = URLEncoder.encode(entry.getValue(), "UTF-8");

                queryParams.append("&").append(encodedKey).append("=").append(encodedValue);
            }
            URL url = new URL(httpRequest.getEndpoint() + queryParams.toString());
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(httpRequest.getMethod().name());
            conn.setRequestProperty("User-Agent", "");
            for(Map.Entry<String, String> entry : httpRequest.getHeaders().entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }

            if(httpRequest.getMethod().isBodySupported()) {
                conn.setDoOutput(true);
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                final StringBuilder bodyParams = new StringBuilder();
                for(Map.Entry<String, String> entry : httpRequest.getBodyParams().entrySet()) {
                    final String encodedKey = URLEncoder.encode(entry.getKey(), "UTF-8");
                    final String encodedValue = URLEncoder.encode(entry.getValue(), "UTF-8");

                    bodyParams.append(encodedKey).append("=").append(encodedValue).append("&");
                }
                if(bodyParams.length() > 0) {
                    bodyParams.deleteCharAt(bodyParams.length() - 1);
                }

                conn.getOutputStream().write(bodyParams.toString().getBytes());
                conn.getOutputStream().flush();
            }

            final StringBuilder response = new StringBuilder();
            final InputStream is = conn.getInputStream();
            final InputStreamReader isr = new InputStreamReader(is);
            final BufferedReader reader = new BufferedReader(isr);

            String line;
            while((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            return new HttpResponse(conn.getResponseCode(), response.toString().trim(), conn.getHeaderFields());
        } catch(Exception e) {
            try {
                final int responseCode = conn.getResponseCode();
                switch(responseCode) {
                    case 422:
                        final InputStream errorStream = conn.getErrorStream();
                        if(errorStream != null) {
                            throw errorParser.parse(new InputStreamReader(errorStream));
                        } else {
                            throw new RuntimeException(e);
                        }
                    case 401:
                        throw new IllegalArgumentException("Invalid API key");
                    case 404:
                        throw new FileNotFoundException("Object not found within your account scope");
                    default:
                        throw new RuntimeException(e);
                }

            } catch(IOException ee) {
                //couldn't get response code, so just wrap original exception
                throw new RuntimeException(e);
            }
        } finally {
            if(conn != null) {
                conn.disconnect();
            }
        }
    }
}
