package ru.clevertec.server;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import ru.clevertec.model.Request;
import ru.clevertec.model.Response;

import java.security.SecureRandom;

@NoArgsConstructor(staticName = "getInstance")
public class Server {
    private final SecureRandom secureRandom = new SecureRandom();
    private static final long MAX_DELAY_MS = 2000;

    @SneakyThrows
    public Response handleRequest(Request request) {
        Thread.sleep(generateDelay());
        return new Response(request.getValue() * request.getValueFactor());
    }

    private long generateDelay() {
        return secureRandom.nextLong(MAX_DELAY_MS + 1);
    }
}
