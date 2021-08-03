package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsByColor {

    public List<Product> filter(Color color, List<Product> products) {
        List<Product> result = new ArrayList<>();

        if(color == null || products == null) {
            throw new IllegalArgumentException("Color e Lista, devem ser diferentes de null, para que o filtro funcione corretamente");
        }

        for (Product p : products) {
            if (p.getColor().equals(color)) {
                result.add(p);
            }
        }

        return result;
    }

}
