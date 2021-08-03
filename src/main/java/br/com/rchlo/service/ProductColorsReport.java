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

        for (Product p: products) {
            if (this.colorCount.containsKey(p.getColor())) {
                int novaQtdDeProdutosCor = this.colorCount.get(p.getColor()) + 1;
                this.colorCount.put(
                        p.getColor(),
                        novaQtdDeProdutosCor
                );
            }
        }

        return this.colorCount;
    }

    public void all() {
        System.out.println(this.colorCount);
    }

}
