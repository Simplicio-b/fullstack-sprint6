package br.com.rchlo.service;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Product;

import java.util.*;

public class ProductsSortedByCodeMain {

    public static void main(String[] args) {
        List<Product> products = ProductRepository.all();
        ProductsSortedByCode psbc = new ProductsSortedByCode();

        products.forEach(p -> {
            System.out.print(p.getCode() + " - ");
            System.out.println(p);
        });

        System.out.println("\n =============================*============*=============== \n");

        psbc.listOrdenada(products).forEach(e -> {
            System.out.print(e.getCode() + " - ");
            System.out.println(e);
        });



    }

}
