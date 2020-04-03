package pl.karolcichosz.sri.controllers;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.karolcichosz.sri.CategoryHelper;
import pl.karolcichosz.sri.dao.ProductRepository;
import pl.karolcichosz.sri.model.Product;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("session")
@Transactional(isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
public class StatefulCartController {

    final ProductRepository productRepository;
    @Getter
    private Map<Product,Integer> cart = new HashMap<>();

    public StatefulCartController(ProductRepository productRepository, CategoryHelper categoryHelper) {
        this.productRepository = productRepository;
    }

    @GetMapping("/add")
    @ResponseBody
    public void add(@RequestParam Long id, @RequestParam Integer number) throws Exception {
        Product product=productRepository.findById(id).get();
        if(product.getStock()-number<0)
            throw new Exception("brak: "+product.toString());
        else
            product.setStock(product.getStock()-number);
            cart.put(product, cart.getOrDefault(product, 0) + number);
    }

    @GetMapping("/del")
    @ResponseBody
    public void del(@RequestParam Long id, @RequestParam Integer number)
    {
        Product product=productRepository.findById(id).get();
        if(cart.containsKey(product))
        {
            Integer value=cart.get(product);
            if(value<=number) {
                cart.remove(product);
                product.setStock(product.getStock() + value);
            }
            else
            {
                cart.put(product, cart.get(product) - number);
                product.setStock(product.getStock()+value);
            }
        }
    }
}
