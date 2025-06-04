//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;

public class Order implements Iterable<OrderItem> {
    private ArrayList<OrderItem> items = new ArrayList();

    public Order() {
    }

    public void addItem(OrderItem var1) {
        this.items.add(var1);
    }

    public void removeItem(OrderItem var1) {
        this.items.remove(var1);
    }

    public Iterator<OrderItem> iterator() {
        return this.items.iterator();
    }

    public OrderItem getItem(Product var1) {
        for(OrderItem var3 : this.items) {
            if (var3.getProduct().equals(var1)) {
                return var3;
            }
        }

        return null;
    }

    public int getNumberOfItems() {
        return this.items.size();
    }

    public double getTotalCost() {
        double var1 = (double)0.0F;

        for(OrderItem var4 : this.items) {
            var1 += var4.getValue();
        }

        return var1;
    }
}
