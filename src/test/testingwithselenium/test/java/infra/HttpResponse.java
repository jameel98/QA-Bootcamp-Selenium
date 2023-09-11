package infra;

import lombok.Data;

import java.util.Map;
@Data
public class HttpResponse<T> {
    private int status;
    private Map<String, String> responseHeaders;
    private T data;

    public HttpResponse() {
    }

    public HttpResponse(int status, Map<String, String> responseHeaders, String responseBody) {
    }
}
