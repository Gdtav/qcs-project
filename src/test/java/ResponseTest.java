import org.junit.jupiter.api.Test;

class ResponseTest {


    TestExchange exchange = new TestExchange();

    // ended is true
    @Test
    void end() {
        Response response = new Response(exchange);
        response.ended = true;
        assert response.hasEnded() && !response.end();
    }

    // no data and cancel is false
    @Test
    void end2() {
        Response response = new Response(exchange);
        assert response.end() && response.data.size() == 0;
    }

    // data and cancel is false
    @Test
    void end3() {
        Response response = new Response(exchange);
        response.write("test data");
        assert response.end() && response.data.size() > 0;
    }

    // no data and cancel is true
    @Test
    void end4() {
        Response response = new Response(exchange);
        assert response.end(true) && response.data.size() == 0;
    }

    // data and cancel is true
    @Test
    void end5() {
        Response response = new Response(exchange);
        response.write("test data");
        assert response.end(true) && response.data.size() > 0;
    }
}