package br.com.rchlo.main;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.service.ProductColorsReport;

public class ProductColorsReportMain {
    public static void main(String[] args) {
        ProductColorsReport productsReport = new ProductColorsReport();
        System.out.println(productsReport.report(ProductRepository.all()));
    }
}
