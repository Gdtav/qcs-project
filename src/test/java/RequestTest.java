import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class RequestTest {

    TestExchange exchange = new TestExchange();

    @Test
    public void getBodyWithBodyFetched() {
        Request request = new Request(exchange);

        request.body = new LinkedList<>();
        request.bodyFetched = true;

        Assertions.assertEquals(request.getBody(), new LinkedList<>());
    }

    @Test
    void getBodyWithNoData() {
        Request request = new Request(exchange);

        Assertions.assertEquals(request.getBody(), new LinkedList<>());
    }

    @Test
    void getBodyWithData() {
    }
}