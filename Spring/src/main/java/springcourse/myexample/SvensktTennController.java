package springcourse.myexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SvensktTennController {

    @Autowired
    private SvensktTennBean svensktTennBean;

    @GetMapping(path = "/products")
    public List<Product> findAllProducts() {
        return svensktTennBean.findAll();
    }

    @GetMapping(path = "/products/{id}")
    public Product findOneProduct(@PathVariable int id) {
        return svensktTennBean.findOne(id);
    }

    @PostMapping(path = "/products")
    public void createProduct(@RequestBody Product product) {
        svensktTennBean.createProduct(product);
    }

    @DeleteMapping(path = "/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        Product product = svensktTennBean.deleteProductById(id);
        if (product == null) {
            throw new ProductNotFoundException("id-" + id + " not found");
        }
    }


}
