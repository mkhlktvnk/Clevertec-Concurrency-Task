package ru.clevertec.client;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import ru.clevertec.model.Request;
import ru.clevertec.model.Response;
import ru.clevertec.server.Server;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@NoArgsConstructor(staticName = "getInstance")
public class Client {
    public List<Response> sendAllRequests(List<Request> requests, Server server) {
        ExecutorService executor = Executors.newFixedThreadPool(requests.size());
        List<Future<Response>> futureResponses = requests.stream()
                .map(request -> sendRequest(executor, request, server))
                .toList();
        List<Response> extractedResponses = futureResponses.stream()
                .map(this::extractValue)
                .toList();
        executor.shutdown();
        return extractedResponses;
    }

    @SneakyThrows
    private Future<Response> sendRequest(ExecutorService executor, Request request, Server server) {
        return executor.submit(() -> server.handleRequest(request));
    }

    @SneakyThrows
    private Response extractValue(Future<Response> futureResponse) {
        return futureResponse.get();
    }
}
