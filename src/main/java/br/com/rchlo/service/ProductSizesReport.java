package br.com.rchlo.service;

import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;

import java.util.*;

public class ProductSizesReport {

    private Map<Size, List<Product>> mapSizeListProduct = new HashMap<Size, List<Product>>();

    public ProductSizesReport() {
        mapSizeListProduct.put(Size.SMALL, new ArrayList<Product>());
        mapSizeListProduct.put(Size.MEDIUM, new ArrayList<Product>());
        mapSizeListProduct.put(Size.LARGE, new ArrayList<Product>());
        mapSizeListProduct.put(Size.EXTRA_LARGE, new ArrayList<Product>());
    }

    public void report(List<Product> products) {
       if(products == null) throw new IllegalArgumentException("Error products não pode ser null");

       products.forEach(p -> {
           Set<Size> tamanhos = p.getAvailableSizes();

           tamanhos.forEach(t -> {
               List<Product> list = this.mapSizeListProduct.get(t);
               list.add(p);
               this.mapSizeListProduct.put(t, list);
           });

       });
    }

    public void all() {
        this.templateAll(Size.SMALL);
        this.templateAll(Size.MEDIUM);
        this.templateAll(Size.LARGE);
        this.templateAll(Size.EXTRA_LARGE);
    }

    private void templateAll(Size size) {
        System.out.println(size);
        System.out.println("Tamanho: " + this.mapSizeListProduct.get(size).size());
        System.out.println("Dados: " + this.mapSizeListProduct.get(size));
        System.out.println("===================== FIM ==================== \n");
    }

}
