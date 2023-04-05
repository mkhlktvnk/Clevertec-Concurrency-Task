package ru.clevertec;

import ru.clevertec.client.Client;
import ru.clevertec.model.Request;
import ru.clevertec.model.Response;
import ru.clevertec.server.Server;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Server server = Server.getInstance();
        Client client = Client.getInstance();
        List<Request> requests = provideRequests();
        long start = System.currentTimeMillis();
        List<Response> responses = client.sendAllRequests(requests, server);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(responses);
    }

    private static List<Request> provideRequests() {
        return List.of(
                new Request(1, 1),
                new Request(2, 2),
                new Request(3, 3),
                new Request(4, 4),
                new Request(5, 5)
        );
    }
}
