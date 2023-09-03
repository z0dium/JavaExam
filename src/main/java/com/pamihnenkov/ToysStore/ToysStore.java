package com.pamihnenkov.ToysStore;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ToysStore {
    private final Map<Toy,Integer> store;
    private final Promotion promotion;

    private final FileHandler fileHandler;

    public ToysStore() {
        this.store = new HashMap<>();
        this.promotion = new Promotion();
        this.fileHandler = new FileHandler();
    }

    public void acceptToys(Map<Toy,Integer> income){
        income.forEach((key, value) -> {
            int newQty = 0;
            if (store.containsKey(key)) newQty = store.get(key);
            newQty += value;
            store.put(key, newQty);
        });
    }

    public void addToyToPromotion(Toy toy, int qty){
        if (!store.containsKey(toy)) throw new RuntimeException("Неизвестная игрушка");
        if (store.get(toy) < qty) throw new RuntimeException("Необходимого количества нет в наличии");
        store.put(toy, store.get(toy) - qty);
        promotion.addToy(toy, qty);
    }

    public Toy processPromotion(String owner){
        if (promotion.getToysQty() == 0) {
            throw new RuntimeException("Игрушки закончились");
        }
        Toy result = promotion.processPromotion();
        try{
            fileHandler.saveResult(result,owner);
        } catch (IOException ex){
            System.out.println("Нет доступа к файлу с результатами");
        }
        return result;
    }

    public void changeToyPromotionWeight(Toy toy, Integer weight){
        promotion.changePromotionToyWeight(toy,weight);
    }
}
