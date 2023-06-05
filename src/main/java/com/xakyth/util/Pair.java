package com.xakyth.util;

public class Pair<K,V> implements java.io.Serializable {
  
    private K key;
    
    private V value;
    
    public  K getKey() {
      return key;
    }
    
    public  V getValue() {
      return value;
    }
    
    public  Pair(K arg0, V arg1) {
      this.key = arg0;
      this.value = arg1;
    }
  }