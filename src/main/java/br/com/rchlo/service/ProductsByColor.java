package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsByColor {

    public List<Product> filter(Color color, List<Product> products) {
        validationFilterParameters(color, products);

        List<Product> filterResult = new ArrayList<>();

        products.forEach(product -> {
            if(product.getColor().equals(color)) {
                filterResult.add(product);
            }
        });

        return filterResult;
    }

    public void validationFilterParameters(Color color, List<Product> products) {
        if(color == null || products == null) {
            throw new IllegalArgumentException("Color e Lista, devem ser diferentes de null, para que o filtro funcione corretamente");
        }
    }

}
