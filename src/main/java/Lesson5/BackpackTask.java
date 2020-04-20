/*
 *       Created by Alexander on 14/04/2020
 */

package Lesson5;

import java.util.ArrayList;
import java.util.List;

public class BackpackTask {
    private List<Item> bestItems;
    private int maxW;
    private int bestPrice;

    public BackpackTask(int maxW) {
        this.maxW = maxW;
    }

    private int CalcWeigth (List<Item> list){
        int sumW = 0;
        for (Item item: list) {
            sumW += item.getWeigth();
        }
        return sumW;
    }

    private int CalcPrice(List<Item> list){
        int sumP = 0;
        for (Item item: list) {
            sumP += item.getPrice();
        }
        return sumP;
    }

    private void CheckSet(List<Item> list)
    {
        if (bestItems == null)
        {
            if (CalcWeigth(list) <= maxW)
            {
                bestItems = list;
                bestPrice = CalcPrice(list);
            }
        }
        else
        {
            if(CalcWeigth(list) <= maxW & CalcPrice(list) > bestPrice)
            {
                bestItems = list;
                bestPrice = CalcPrice(list);
            }
        }
    }

    public void MakeAllSets(List<Item> list)
    {
        if (list.size() > 0)
            CheckSet(list);
        for (int i = 0; i < list.size(); i++)
        {
            List<Item> newSet = new ArrayList<>(list);
            newSet.remove(i);
            MakeAllSets(newSet);
        }
    }

    public void info(){
        int i = 1;
        for (Item list: bestItems ) {
            System.out.println(i + ". " + list.getName() + " " + list.getWeigth() + " " + list.getPrice());
            i++;
        }
    }
}

class Item {
    private String name;
    private int weigth;
    private int price;

    public Item(String name, int weigth, int price) {
        this.name = name;
        this.weigth = weigth;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeigth() {
        return weigth;
    }

    public int getPrice() {
        return price;
    }
}

class MainBackpackTask{
    public static void main(String[] args) {
        BackpackTask backpack = new BackpackTask(15);

        Item item1 = new Item("Book", 7, 100);
        Item item2 = new Item("Sandwich", 3, 350);
        Item item3 = new Item("Apple", 4, 120);
        Item item4 = new Item("Tomato", 13, 700);
        Item item5 = new Item("Juice", 9, 800);

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);
        list.add(item5);

        backpack.MakeAllSets(list);
        backpack.info();
    }
}