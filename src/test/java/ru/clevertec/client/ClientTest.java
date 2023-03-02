package ru.clevertec.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.clevertec.model.Request;
import ru.clevertec.model.Response;
import ru.clevertec.server.Server;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ClientTest {
    private final Client client = Client.getInstance();

    @Mock
    private Server server;

    @Test
    void sendAllRequestsShouldGetActualResponsesAndCallServer() {
        Response response = new Response(0);
        List<Request> requests = provideRequests();
        doReturn(response).when(server).handleRequest(any(Request.class));

        List<Response> responses = client.sendAllRequests(requests, server);

        verify(server, times(requests.size())).handleRequest(any(Request.class));
        assertThat(responses.size()).isEqualTo(requests.size());
        assertThat(responses).contains(response);
    }

    private List<Request> provideRequests() {
        return List.of(
                new Request(1, 2),
                new Request(2, 3),
                new Request(3, 4)
        );
    }
}