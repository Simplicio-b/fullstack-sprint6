package br.com.rchlo.service;

import br.com.rchlo.domain.Color;
import br.com.rchlo.domain.Product;
import br.com.rchlo.domain.Size;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductColorsReportTest {

    @Test
    public void reportShouldReturnExeptionIfProfuctsNull() {
        ProductColorsReport pcr = new ProductColorsReport();

        List<Product> products = List.of(
                aTShirt(),
                aJacket()
        );

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () ->  pcr.report(null)
        );
    }

    @Test
    public void reportMustReturnMapWithQuantityPartsPerColor() {
        ProductColorsReport pcr = new ProductColorsReport();
        List<Product> products = List.of(
                aTShirt(),
                aJacket()
        );

        Map<Color, Integer> mapProductsColor = pcr.report(products);
        Map<Color, Integer> mapProdctsColorExpect = new HashMap<>();

        mapProdctsColorExpect.put(Color.BLUE, 1);
        mapProdctsColorExpect.put(Color.GRAY, 0);
        mapProdctsColorExpect.put(Color.GREEN, 0);
        mapProdctsColorExpect.put(Color.PINK, 0);
        mapProdctsColorExpect.put(Color.RED, 0);
        mapProdctsColorExpect.put(Color.WHITE, 1);


        Assertions.assertEquals(mapProdctsColorExpect, mapProductsColor);
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
