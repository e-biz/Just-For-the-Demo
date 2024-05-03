package com.StoringLocalValues;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
	
	private static Map<String, String> sharedData = new HashMap<>();

    public static void put(String key, String value) {
        sharedData.put(key, value);
    }

    public static String get(String key) {
        return sharedData.get(key);
    }

}

