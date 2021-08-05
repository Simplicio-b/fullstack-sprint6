package br.com.rchlo.main;

import br.com.rchlo.data.ProductRepository;
import br.com.rchlo.service.ProductSizesReport;


public class ProductSizesReportMain {
    public static void main(String[] args) {
        ProductSizesReport productReportSize = new ProductSizesReport();
        productReportSize.report(ProductRepository.all());
        productReportSize.showReportAll();
    }
}


