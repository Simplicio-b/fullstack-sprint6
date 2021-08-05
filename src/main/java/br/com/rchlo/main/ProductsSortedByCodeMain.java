package br.com.rchlo.main;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.domain.Product;
import br.com.rchlo.service.ProductsSortedByCode;

import java.util.*;

public class ProductsSortedByCodeMain {

    public static void main(String[] args) {
        ProductsSortedByCode sortedByCode = new ProductsSortedByCode();

        ProductRepository.all().forEach(product -> {
            System.out.print(product.getCode() + " - ");
            System.out.println(product);
        });

        System.out.println("\n =============================*============*=============== \n");

        sortedByCode.listOrdenada(ProductRepository.all()).forEach(product -> {
            System.out.print(product.getCode() + " - ");
            System.out.println(product);
        });

    }

}
