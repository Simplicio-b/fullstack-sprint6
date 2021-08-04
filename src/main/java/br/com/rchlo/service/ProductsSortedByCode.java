package br.com.rchlo.service;

import br.com.rchlo.domain.Product;

import java.util.ArrayList;
import java.util.List;


public class ProductsSortedByCode {

    public List<Product> listOrdenada(List<Product> products) {
        if(products == null) throw new IllegalArgumentException("Products deve ser diferente de null");

        List<Product> orderList = new ArrayList<>(products);
        orderList.sort((p1, p2) -> p1.getCode().compareTo(p2.getCode()));

        return orderList;
    }


}
