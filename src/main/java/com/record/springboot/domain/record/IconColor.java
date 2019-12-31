package com.record.springboot.domain.record;

import java.util.HashMap;
import java.util.Map;

public enum IconColor {
  PRIMARY("primary"),
  SUCCESS("success"),
  WARNING("warning"),
  INFO("info");

  private final String key;

  IconColor(String value){
    this.key = value;
  }

  private static final Map<String, IconColor> cachedIconColor = new HashMap<>();

  static{
    for(IconColor color : IconColor.values()){
      cachedIconColor.put(color.key, color);
    }
  }

  public static IconColor of(String value){
    return cachedIconColor.getOrDefault(value, PRIMARY);
  }
}
