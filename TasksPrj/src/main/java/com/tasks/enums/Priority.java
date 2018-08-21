package com.tasks.enums;

import java.util.Map;
import java.util.HashMap;


public enum Priority {
	LOW(1),
    NORMAL(2),
    HIGH(3);
	
    private  final int code;

    private static Map<Integer, Priority> codeToEntityTypeMapping;
    private static Map<String, Priority> nameToEntityTypeMapping;
    private Priority(int code) {
        this.code = code;
    }

  

    public int getCode() {
        return code;
    }

    public static Priority getFrequency(String name) {
    if (nameToEntityTypeMapping == null) {
        initMapping();
    }
    return nameToEntityTypeMapping.get(name);
    }
    public static Priority getFrequency(int code) {
    if (codeToEntityTypeMapping == null) {
        initMapping();
    }
    return codeToEntityTypeMapping.get(code);
    }

    private static void initMapping() {
    codeToEntityTypeMapping = new HashMap<>();
    nameToEntityTypeMapping = new HashMap<>();
    for (Priority s : values()) {
        codeToEntityTypeMapping.put(s.code, s);
        nameToEntityTypeMapping.put(s.name(), s);
        }
    }
}
