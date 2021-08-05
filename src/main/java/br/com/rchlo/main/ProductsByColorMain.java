package br.com.rchlo.main;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.service.ProductsByColor;

import java.util.List;


public class ProductsByColorMain {
    public static void main(String[] args) {
        ProductsByColor productsColor = new ProductsByColor();

        List<Product> resultFilterProducts = productsColor.filter(Color.WHITE, ProductRepository.all());

        for (Product filteredProducts : resultFilterProducts) {
            System.out.println(filteredProducts.getCode() + ": " + filteredProducts.getColor());
        }

    }
}
