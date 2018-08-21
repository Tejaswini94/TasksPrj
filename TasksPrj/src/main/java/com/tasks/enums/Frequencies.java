package com.tasks.enums;

import java.util.Map;
import java.util.HashMap;


public enum Frequencies {
	DAILY(1),
    WEEKLY(2),
    FORTNIGHTLY(3),
    MONTHLY(4),
    QUARTERLY(5),
    HALFYEARLY(6),
    YEARLY(7),
    CONTINUOUS(8);
	
    private  final int code;

    private static Map<Integer, Frequencies> codeToEntityTypeMapping;
    private static Map<String, Frequencies> nameToEntityTypeMapping;
    private Frequencies(int code) {
        this.code = code;
    }

  

    public int getCode() {
        return code;
    }

    public static Frequencies getFrequency(String name) {
    if (nameToEntityTypeMapping == null) {
        initMapping();
    }
    return nameToEntityTypeMapping.get(name);
    }
    public static Frequencies getFrequency(int code) {
    if (codeToEntityTypeMapping == null) {
        initMapping();
    }
    return codeToEntityTypeMapping.get(code);
    }

    private static void initMapping() {
    codeToEntityTypeMapping = new HashMap<>();
    nameToEntityTypeMapping = new HashMap<>();
    for (Frequencies s : values()) {
        codeToEntityTypeMapping.put(s.code, s);
        nameToEntityTypeMapping.put(s.name(), s);
        }
    }
}
