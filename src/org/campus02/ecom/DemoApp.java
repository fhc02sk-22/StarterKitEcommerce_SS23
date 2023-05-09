package org.campus02.ecom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DemoApp {
    public static void main(String[] args) throws DataFileException {
        ArrayList<BasketData> list = BasketDataLoader.load(".\\data\\buyings.json");
        System.out.println(list.size());

        Collections.sort(list, new BasketComparator());

        for (int i = 0; i < 100; i++)
            System.out.println(list.get(i));
    }
}
