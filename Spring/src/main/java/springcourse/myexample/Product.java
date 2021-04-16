package springcourse.myexample;

/**
 * In Postman I will send in the product name
 * It should be mapped to an id
 */
public class Product {

    private String product;
    private Integer id; //important to have Integer and not in, if we want to compare it to null at some point

    protected Product() {
    } //important to be able to send in via Postman

    public Product(String product, Integer id) {
        this.product = product;
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
