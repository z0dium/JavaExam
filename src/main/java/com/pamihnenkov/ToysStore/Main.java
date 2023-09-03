package com.pamihnenkov.ToysStore;

import java.io.Console;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ToysStore toysStore = new ToysStore();
        Toy toy1 = new Toy(1,"Конструктор");
        Toy toy2 = new Toy(2,"Трансформер");
        Toy toy3 = new Toy(3,"Покемон");
        HashMap<Toy,Integer> initialStore = new HashMap<>();

        initialStore.put(toy1,10);
        initialStore.put(toy2,10);
        initialStore.put(toy3,10);
        toysStore.acceptToys(initialStore);

        toysStore.addToyToPromotion(toy1,3);
        toysStore.addToyToPromotion(toy2,2);
        toysStore.addToyToPromotion(toy3,1);

        toysStore.changeToyPromotionWeight(toy1, 1);
        toysStore.changeToyPromotionWeight(toy2,3);
        toysStore.changeToyPromotionWeight(toy3,10);

        for (int i=0; i < 10; i++){
            String name = "Участник №"+i;
            toysStore.processPromotion(name);
        }
    }
}
