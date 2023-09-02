package com.pamihnenkov.ToysStore;

public class PromotionEntry {
    private int quantity;
    private int weight;

    public PromotionEntry(int quantity, int weight) {
        this.quantity = quantity;
        this.weight = weight;
    }

    public void incrementQuantity(int quantity) {
        this.quantity += quantity;
    }

    public void decrementQuantity(int quantity){
        if (this.quantity < quantity) throw new RuntimeException("Недостаточное количество игрушек в списке розыгрыша.");
        this.quantity -= quantity;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    public int getQuantity(){
        return quantity;
    }
}
