package com.pamihnenkov.ToysStore;

public class Toy {
    private final String name;
    private final Integer id;

    public Toy(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
