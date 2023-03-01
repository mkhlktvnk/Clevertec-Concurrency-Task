package ru.clevertec.client;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import ru.clevertec.model.Request;
import ru.clevertec.model.Response;
import ru.clevertec.server.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@NoArgsConstructor(staticName = "getInstance")
public class Client {
    public List<Response> sendAllRequests(List<Request> requests, Server server) {
        List<Response> responses = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        requests.forEach(request -> {
            var response = sendRequest(executor, request, server);
            responses.add(response);
        });
        executor.shutdown();
        return responses;
    }

    @SneakyThrows
    private Response sendRequest(ExecutorService executor, Request request, Server server) {
        return executor.submit(() -> server.handleRequest(request)).get();
    }
}
