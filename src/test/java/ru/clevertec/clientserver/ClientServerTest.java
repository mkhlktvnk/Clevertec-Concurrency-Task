package ru.clevertec.clientserver;

import org.junit.jupiter.api.Test;
import ru.clevertec.client.Client;
import ru.clevertec.model.Request;
import ru.clevertec.model.Response;
import ru.clevertec.server.Server;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ClientServerTest {

    private final Server server = Server.getInstance();

    private final Client client = Client.getInstance();

    @Test
    void sendAllRequestsShouldReturnActualNumberOfRequests() {
        List<Request> requests = provideTestRequests();
        List<Response> responses = client.sendAllRequests(requests, server);

        assertThat(responses.size()).isEqualTo(requests.size());
    }

    private List<Request> provideTestRequests() {
        return List.of(
                new Request(1, 2),
                new Request(3, 4),
                new Request(5, 6),
                new Request(7, 8),
                new Request(9, 10)
        );
    }
}