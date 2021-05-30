import com.sun.net.httpserver.HttpExchange;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

class RequestTest {

    @Mock
    private HttpExchange exchange;

    @Before public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getBodyWithBodyFetched() {
        doReturn("GET").when(exchange).getRequestMethod();

        Request request = new Request(exchange);

        request.body = new LinkedList<>();
        request.bodyFetched = true;

        Assertions.assertEquals(request.getBody(), new LinkedList<>());
    }

    @Test
    void getBodyWithNoData() {
    }

    @Test
    void getBodyWithData() {
    }
}