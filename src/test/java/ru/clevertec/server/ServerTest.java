package ru.clevertec.server;

import org.junit.jupiter.api.Test;
import ru.clevertec.model.Request;
import ru.clevertec.model.Response;

import static org.assertj.core.api.Assertions.assertThat;

class ServerTest {

    private final Server server = Server.getInstance();

    @Test
    void handleRequest() {
        Request request = new Request(10, 10);

        Response response = server.handleRequest(request);

        assertThat(response.getValue()).isEqualTo(100);
    }
}