package br.com.rchlo.service;

import br.com.rchlo.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductsByEffectivePriceRange {

    private List<Product> resultList = new ArrayList<>();

    public List<Product> filterProductList(BigDecimal minPrice, BigDecimal maxPrice, List<Product> productList) {
        if (minPrice == null) throw new IllegalArgumentException("minimum price should not be null");
        if (maxPrice == null) throw new IllegalArgumentException("maximum price should not be null");
        if (productList == null) throw new IllegalArgumentException("product list should not be null");

        for (Product product : productList) {
            BigDecimal price = product.getFinalPrice();

            if (price.compareTo(minPrice) >= 0 && price.compareTo(maxPrice) <= 0) {
                this.resultList.add(product);
            }
        }

        return this.resultList;
    }

}
