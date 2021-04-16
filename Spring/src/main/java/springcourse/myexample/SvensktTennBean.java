package springcourse.myexample;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class SvensktTennBean {
    private static List<Product> items = new ArrayList<>();
    private static int prodCount = 1;

    static {
        items.add(new Product("Elephant cushion", 1));
    }

    public List<Product> findAll() { //return all (a list)
        return items;
    }

    public Product findOne(int id) { //return only one
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product createProduct(Product product) { //just add the id since the name is defined in Postman
        product.setId(++prodCount);
        items.add(product);
        return product;
    }

    public Product deleteProductById(int id) {
        Iterator<Product> iterator = items.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                iterator.remove();
                return product;
            }
        }
        return null;
    }
}
