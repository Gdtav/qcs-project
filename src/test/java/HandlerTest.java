import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class HandlerTest {

    @Mock
    HttpExchange httpExchange;

    @Test
    void handle(HttpExchange exchange) throws URISyntaxException {
        when(exchange.getRequestURI()).thenReturn(new URI(""));
    }
}