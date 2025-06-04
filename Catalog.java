//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;

public class Catalog implements Iterable<Product> {
    private ArrayList<Product> products = new ArrayList();

    public Catalog() {
    }

    public void addProduct(Product var1) {
        this.products.add(var1);
    }

    public Iterator<Product> iterator() {
        return this.products.iterator();
    }

    public Product getProduct(String var1) {
        for(Product var3 : this.products) {
            if (var3.getCode().equals(var1)) {
                return var3;
            }
        }

        return null;
    }

    public int getNumberOfProducts() {
        return this.products.size();
    }
}
