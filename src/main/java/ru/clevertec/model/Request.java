package ru.clevertec.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request {
    private int value;
    private int valueFactor;
}

