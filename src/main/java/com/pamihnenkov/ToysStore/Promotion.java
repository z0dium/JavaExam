package com.pamihnenkov.ToysStore;

import java.util.*;

public class Promotion {
    private final Map<Toy, PromotionEntry> promotionList;
    private final int DEFAULT_PROMOTION_WEIGHT = 5;

    Promotion() {
        promotionList = new HashMap<>();
    }

    void addToy(Toy toy, int qty){
        if (!promotionList.containsKey(toy)) promotionList.put(toy,new PromotionEntry(qty,DEFAULT_PROMOTION_WEIGHT));
        else {
            promotionList.get(toy).incrementQuantity(qty);
        }
    }

    public void changePromotionToyWeight(Toy toy, int weight){
        promotionList.get(toy).setWeight(weight);
    }

    public int getToyWeight(Toy toy){
        return promotionList.get(toy).getWeight();
    }

    public Toy processPromotion(){
        List<Toy> promotionStore = new ArrayList<>();
        promotionList.forEach((key,value) -> {
            for (int i = 0; i < value.getWeight(); i++){
                promotionStore.add(key);
            }
        });
        Collections.shuffle(promotionStore);
        Random rand = new Random();
        Toy prize = promotionStore.get(rand.nextInt(promotionStore.size()));
        promotionList.get(prize).decrementQuantity(1);
        if (promotionList.get(prize).getQuantity() == 0) promotionList.remove(prize);
        return prize;
    }

    public int getToysQty(){
        return promotionList.size();
    }
}
