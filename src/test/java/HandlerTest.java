import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class HandlerTest {

    @Mock
    HttpExchange httpExchange;

    @Test
    void handle(HttpExchange exchange) {
        when(exchange.getRequestURI()).thenReturn();
    }
}