package pl.karolcichosz.sri.controllers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.karolcichosz.sri.CategoryHelper;
import pl.karolcichosz.sri.dao.ProductRepository;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope("session")
public class StatefulCartController {

    final ProductRepository productRepository;
    private Map<Long,Integer> cart = new HashMap<>();

    public StatefulCartController(ProductRepository productRepository, CategoryHelper categoryHelper) {
        this.productRepository = productRepository;
    }

    @GetMapping("/add")
    @ResponseBody
    public void add(@RequestParam Long id, @RequestParam Integer number)
    {
        cart.put(id, cart.getOrDefault(id, 0) + number);
    }

    @GetMapping("/del")
    @ResponseBody
    public void del(@RequestParam Long id, @RequestParam Integer number)
    {
        if(cart.containsKey(id))
        {
            Integer value=cart.get(id);
            if(value<=number)
                cart.remove(id);
            else
                cart.put(id, cart.get(id) - number);
        }
    }
}
