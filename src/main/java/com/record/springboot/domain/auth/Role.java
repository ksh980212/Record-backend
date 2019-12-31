package com.record.springboot.domain.auth;

import java.util.HashMap;
import java.util.Map;

public enum Role {
  ADMIN("admin"),
  GUEST("guest");

  private final String key;

  Role(String value){
    this.key = value;
  }

  private final static Map<String, Role> cachedRole = new HashMap<>();

  static{
    for(Role role : Role.values()){
      cachedRole.put(role.key, role);
    }
  }

  public static Role of(String key){
    if(!cachedRole.containsKey(key)){
      throw new IllegalArgumentException("Unexpected Role Error");
    }
    return cachedRole.get(key);
  }
}
