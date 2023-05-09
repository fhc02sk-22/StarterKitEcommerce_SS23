package org.campus02.ecom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BasketAnalyzer {
    private ArrayList<BasketData> baskets;

    public BasketAnalyzer(ArrayList<BasketData> baskets) {
        this.baskets = baskets;
    }

    public List<BasketData> getEveryNthBasket(int n) {
        ArrayList<BasketData> list = new ArrayList<>();

        for (int i = 0; i < baskets.size(); i+=n){
            list.add(baskets.get(i));
        }

        return list;
    }

    public List<BasketData> filterBaskets(String paymentType, Double from, Double to) {
        ArrayList<BasketData> list = new ArrayList<>();

        for (int i = 0; i < baskets.size(); i++){
            BasketData bd = baskets.get(i);

            if (bd.getPaymentType().equals(paymentType) &&
                    bd.getOrderTotal() >= from && bd.getOrderTotal() <= to){
                list.add(bd);
            }
        }

        return list;
    }

    public HashMap<String, ArrayList<Double>> groupByProductCategory() {
        HashMap<String, ArrayList<Double>> result = new HashMap<>();

        for (BasketData bd : baskets) {
            if (result.containsKey(bd.getProductCategory())){
                result.get(bd.getProductCategory()).add(bd.getOrderTotal());
            } else {
                ArrayList<Double> list = new ArrayList<>();
                list.add(bd.getOrderTotal());
                result.put(bd.getProductCategory(), list);
            }
        }

        return result;
    }
}
