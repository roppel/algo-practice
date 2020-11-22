package com.company;

import java.util.*;

public class FoodDelivery {
/*
I've ordered some food delivery to my home, but I've forgotten what I ordered in the past. I only remember how much money I spent.

From the following menu, and list of receipt values, determine what I may have ordered.

The Menu:
    'sandwich': 6.85,
    'toast': 2.20,
    'curry': 7.85,
    'egg': 3.20,
    'cheese': 1.25,
    'coffee': 1.40,
    'soup': 3.45,
    'soda': 2.05,

The Receipts (test cases):
4.85, 7.65, 12.15, 13.75, 17.75, 18.25, 19.40, 28.25, 35.35, 74.95

Constraints:
- this platform will only run your code for 30 seconds
  - it will stop earlier if memory is exceeded or you print too much output
- you must use 100% of the receipt value, we don't want any money left over
- you can order any quantity of any menu item
- none of the receipt values are "tricks", they all have answers


Part One:

Find the first combination of food that adds up to the receipt total, print out only one combination for that receipt, and move on to the next receipt.

The output format is up to you, but here are some examples:

4.85:
3 items, toast, coffee, cheese

13.75:
3 items, {'soup': 2, 'sandwich': 1}



Part Two, if we have time:

Refactor your first algorithm to examine many matching combinations for each receipt to find the combination with the fewest total number of items purchased.

Example:
4.85 receipt has three possible combinations:
- best: soup, coffee (2 total items)
- toast, coffee, cheese (3 total times)
- coffee, coffee, soda (3 total items)
*/

    //runs in about 15 seconds on 2015 MBP i7 with 16GB RAM
    public static void main(String[] args) {


        Map<String, Double> menu = new HashMap<>();
        menu.put("sandwich", 6.85);
        menu.put("toast", 2.20);
        menu.put("curry", 7.85);
        menu.put("egg", 3.20);
        menu.put("cheese", 1.25);
        menu.put("coffee", 1.40);
        menu.put("soup", 3.45);
        menu.put("soda", 2.05);

        List<Double> receipts = Arrays.asList(4.85, 7.65, 12.15, 13.75, 17.75, 18.25, 19.40, 28.25, 35.35, 74.95);
        List<Item> items = new ArrayList<>();
        for (Map.Entry<String, Double> item : menu.entrySet()) {
            items.add(new Item(item.getKey(), item.getValue()));
        }
        items.sort(Comparator.comparing(Item::getValue).reversed());
        for (Item item : items) {
            List<String> list = new ArrayList<>();
            for (double receipt : receipts)
                if (isTotal(item, items, list, receipt)) {
                    System.out.println("receipt " + receipt + " size " + list.size());

                    list.forEach(System.out::println);
                    continue;
                }
        }
    }


    static boolean isTotal(Item item, List<Item> items, List<String> list, double value) {
        if (item.value == value) {
            list.add(item.name);
            return true;
        }

        if (item.value > value) return false;
        for (Item nextItem : items)
            if (isTotal(nextItem, items, list, value - item.value)) {
                list.add(item.name);
                return true;
            }


        return false;


    }


    static class Item {
        String name;
        double value;

        Item(String name, double value) {
            this.name = name;
            this.value = value;
        }

        double getValue() {
            return value;
        }

    }
}