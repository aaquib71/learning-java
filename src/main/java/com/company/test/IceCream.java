package com.company.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class IceCream {
    private String flavor;
    private int quantity;

    public IceCream(String flavor, int quantity) {
        this.flavor = flavor;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            String result = objectWriter.writeValueAsString(this);
            return result;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "IceCream{" +
                    "flavor='" + flavor + '\'' +
                    ", quantity=" + quantity +
                    '}';
        }
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
