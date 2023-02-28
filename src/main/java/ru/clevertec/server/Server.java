package ru.clevertec.server;

import lombok.SneakyThrows;
import ru.clevertec.model.Request;
import ru.clevertec.model.Response;

import java.util.Random;

public class Server {
    private static final long MIN_DELAY = 0;
    private static final long MAX_DELAY = 2000;

    @SneakyThrows
    public Response handleRequest(Request request) {
        Thread.sleep(generateDelay());
        return new Response(request.getValue() * request.getValueFactor());
    }

    private long generateDelay() {
        return new Random().nextLong(MAX_DELAY - MIN_DELAY + 1) + MIN_DELAY;
    }
}
