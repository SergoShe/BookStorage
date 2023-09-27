package com.github.SergoShe.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    UNKNOWN(0),
    AVAILABLE(1),
    ISSUED(2),
    REQUIRES_SERVICE(3),
    IN_THE_READING_ROOM(4),
    AWAITING_SERVICE(5),
    IN_SERVICE(6),
    LOST(7);

    private final int value;
    private static final Map<Integer, Status> map = new HashMap<>();

    Status(int value) {
        this.value = value;
    }

    static {
        for (Status status : Status.values()) {
            map.put(status.getValue(), status);
        }
    }

    public static Status valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Status not found");
        }
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
