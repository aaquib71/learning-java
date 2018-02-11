package com.company.test;

public class IceCream {
    private String flavor;
    private int quantity;

    public IceCream(String flavor, int quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "IceCream{" +
                "flavor='" + flavor + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
