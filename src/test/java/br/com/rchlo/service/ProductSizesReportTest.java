package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;

public class ProductSizesReportTest {

    @Test
    public void mustReturnExceptionNullParameters() {
        ProductSizesReport productReportSize = new ProductSizesReport();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> productReportSize.report(null)
        );
    }

    @Test
    public void shouldReturnProductMapBySize() {
        List<Product> products = List.of(this.aTShirt(), this.aJacket());
        ProductSizesReport productReportSize = new ProductSizesReport();

        Map<Size, List<Product>> productList = productReportSize.report(products);
        Map<Size, List<Product>> productListExpected = new HashMap<>();

        productListExpected.put(Size.SMALL, List.of(aTShirt()));
        productListExpected.put(Size.MEDIUM, List.of(aTShirt()));
        productListExpected.put(Size.LARGE, List.of(aJacket()));
        productListExpected.put(Size.EXTRA_LARGE, List.of(aJacket()));


        Assertions.assertEquals(productListExpected.get(Size.SMALL).size(), productList.get(Size.SMALL).size());
        Assertions.assertEquals(productListExpected.get(Size.MEDIUM).size(), productList.get(Size.MEDIUM).size());
        Assertions.assertEquals(productListExpected.get(Size.LARGE).size(), productList.get(Size.LARGE).size());
        Assertions.assertEquals(productListExpected.get(Size.EXTRA_LARGE).size(), productList.get(Size.EXTRA_LARGE).size());

        Assertions.assertTrue(productListExpected.equals(productList));
    }


    public Product aTShirt() {
        return new Product(14124998L,
                "Camiseta Infantil Manga Curta Super Mario",
                "A Camiseta Infantil Manga Curta Super Mario é confeccionada em malha macia e possui decote careca, mangas curtas e padronagem do Super Mario. Aposte na peça na hora de compor visuais geek divertidos.",
                "camiseta-infantil-manga-curta-super-mario-14124998_sku",
                "Nintendo",
                new BigDecimal("39.90"),
                new BigDecimal("5.0"),
                Color.BLUE,
                116,
                "https://static.riachuelo.com.br/RCHLO/14124998004/portrait/cd948d80fe8a1fdc873f8dca1f3c4c468253bf1d.jpg",
                Set.of(Size.SMALL, Size.MEDIUM));
    }

    public Product aJacket() {
        return new Product(13834193L,
                "Jaqueta Puffer Juvenil Com Capuz Super Mario",
                "A Jaqueta Puffer Juvenil Com Capuz Super Mario é confeccionada em material sintético. Possui estrutura ampla e modelo puffer, com capuz em pelúcia e bolsos frontais. Ideal para compor looks de inverno, mas sem perder o estilo. Combine com uma camiseta, calça jeans e tênis colorido.",
                "jaqueta-puffer-juvenil-com-capuz-super-mario-13834193_sku",
                "Nintendo",
                new BigDecimal("199.90"),
                null,
                Color.WHITE,
                147,
                "https://static.riachuelo.com.br/RCHLO/13834193003/portrait/3107b7473df334c6ff206cd78d16dec86d7dfe9a.jpg",
                Set.of(Size.LARGE, Size.EXTRA_LARGE));
    }

}
