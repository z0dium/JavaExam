package com.pamihnenkov.ToysStore;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private String file = "promotedToys.txt";

    public void saveResult(Toy toy, String owner) throws IOException {
        FileWriter fw = new FileWriter(file, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(toy.toString() + " получает " + owner);
        bw.newLine();
        bw.close();
    }
}
