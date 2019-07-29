package GeekBrains_Algorithms.Lesson5;

import java.util.ArrayList;

public class Backpack {
    ArrayList<Item> bestItems;
    int backpackWeight;
    int bestPrice;

    public Backpack(int backpackWeight) {
        this.backpackWeight = backpackWeight;
        this.bestItems = new ArrayList<>();
    }

    private int calcWeigth(ArrayList<Item> items) {
        int sumWeight = 0;
        for (Item item : items) {
            sumWeight += item.weight;
        }
        return sumWeight;
    }

    private int calcPrice(ArrayList<Item> items) {
        int sumPrice = 0;

        for (Item item : items) {
            sumPrice += item.price;
        }
        return sumPrice;
    }

    private void checkSet(ArrayList<Item> items) {
        if (bestItems == null) {
            if (calcWeigth(items) <= backpackWeight) {
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        } else {
            if (calcWeigth(items) <= backpackWeight && calcPrice(items) > bestPrice) {
                bestItems = items;
                bestPrice = calcPrice(items);
            }
        }
    }

    //перебираем все возможные наборы предметов для рюкзака
    public void makeAllSets(ArrayList<Item> items) {
        if (items.size() > 0) {
            checkSet(items);
        }

        for (int i = 0; i < items.size(); i++) {
            ArrayList<Item> newSet = new ArrayList<>(items);
            newSet.remove(i);
            makeAllSets(newSet);
        }
    }

    public ArrayList<Item> getBestSet() {
        return bestItems;
    }
}
