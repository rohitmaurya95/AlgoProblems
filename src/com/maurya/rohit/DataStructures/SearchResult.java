package com.maurya.rohit.DataStructures;

public class SearchResult<T> {
    T value;
    String key;
    int distance;

    public SearchResult(T value, String key, int distance) {
        this.value = value;
        this.key = key;
        this.distance = distance;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
