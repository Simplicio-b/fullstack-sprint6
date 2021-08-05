package br.com.rchlo.service;

import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;

import java.util.*;

public class ProductSizesReport {

    private Map<Size, List<Product>> mapSizeListProduct = new HashMap<Size, List<Product>>();

    public ProductSizesReport() {
        mapSizeListProduct.put(Size.SMALL, new ArrayList<>());
        mapSizeListProduct.put(Size.MEDIUM, new ArrayList<>());
        mapSizeListProduct.put(Size.LARGE, new ArrayList<>());
        mapSizeListProduct.put(Size.EXTRA_LARGE, new ArrayList<>());
    }

    public Map<Size, List<Product>> report(List<Product> products) {
       if(products == null) throw new IllegalArgumentException("Error products não pode ser null");

       products.forEach(product -> {
           product.getAvailableSizes().forEach(size -> {
               List<Product> list = this.mapSizeListProduct.get(size);
               list.add(product);

               this.mapSizeListProduct.put(size, list);
           });
       });

       return this.mapSizeListProduct;
    }

    public void showReportAll() {
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
