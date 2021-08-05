package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductColorsReport {

    private Map<Color, Integer> colorCount = new HashMap<Color, Integer>();

    public ProductColorsReport() {
        this.colorCount.put(Color.BLUE, 0);
        this.colorCount.put(Color.GRAY, 0);
        this.colorCount.put(Color.GREEN, 0);
        this.colorCount.put(Color.PINK, 0);
        this.colorCount.put(Color.RED, 0);
        this.colorCount.put(Color.WHITE, 0);
    }

    public Map<Color, Integer> report(List<Product> products) {
        if(products == null) throw new IllegalArgumentException("Products não pode ser igual a null");

        products.forEach(product -> {
            if (this.colorCount.containsKey(product.getColor())) {
                int quantityProductColor = this.colorCount.get(product.getColor()) + 1;
                this.colorCount.put(
                        product.getColor(),
                        quantityProductColor
                );
            }
        });

        return this.colorCount;
    }
}
