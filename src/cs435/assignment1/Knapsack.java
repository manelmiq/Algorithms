package cs435.assignment1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;

public class Knapsack {
    List<Item> itemList;

    class Item{
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "weight=" + weight +
                    ", value=" + value +
                    '}';
        }
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int weight = in.nextInt();
        int itemNumber = in.nextInt();
        LinkedList<Item> itemLinkedList = new LinkedList<>();
        for(int i = 0; i < itemNumber; i++){
            int valueItem  = in.nextInt();
            int weightItem  = in.nextInt();
            itemLinkedList.add(new Item(valueItem, weightItem));
        }
        knapsack(weight, itemLinkedList);
    }

    private void knapsack(int weight, List<Item> list) {
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i).getWeight();

        }
    }


    private void knapsackGreedy(int weight, List<Item> list) {
    }
}
