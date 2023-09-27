package com.github.SergoShe.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum BindingType {
    UNKONWN(0);

    private final int value;
    private static final Map<Integer, BindingType> map = new HashMap<>();

    BindingType(int value) {
        this.value = value;
    }

    static {
        for (BindingType bindingType : BindingType.values()) {
            map.put(bindingType.getValue(), bindingType);
        }
    }

    public static BindingType valueOf(int value) {
        if (!map.containsKey(value)) {
            throw new IllegalArgumentException("Type not found");
        }
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
