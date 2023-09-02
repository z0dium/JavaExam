package com.pamihnenkov.ToysStore;

public class Toy {
    private final String name;
    private final String id;

    public Toy(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}
