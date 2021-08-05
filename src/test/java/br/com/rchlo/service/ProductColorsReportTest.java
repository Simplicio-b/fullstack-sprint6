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
        ProductColorsReport productColorReport = new ProductColorsReport();

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () ->  productColorReport.report(null)
        );
    }

    @Test
    public void reportMustReturnMapWithQuantityPartsPerColor() {
        ProductColorsReport productColorReport = new ProductColorsReport();
        List<Product> products = List.of(
                aTShirt(),
                aJacket()
        );

        Map<Color, Integer> productColor = productColorReport.report(products);
        Map<Color, Integer> productColorExpect = mockMapColor();

        Assertions.assertEquals(productColorExpect.get(Color.BLUE), productColor.get(Color.BLUE));
        Assertions.assertEquals(productColorExpect.get(Color.GRAY), productColor.get(Color.GRAY));
        Assertions.assertEquals(productColorExpect.get(Color.GREEN), productColor.get(Color.GREEN));
        Assertions.assertEquals(productColorExpect.get(Color.PINK), productColor.get(Color.PINK));
        Assertions.assertEquals(productColorExpect.get(Color.RED), productColor.get(Color.RED));
        Assertions.assertEquals(productColorExpect.get(Color.WHITE), productColor.get(Color.WHITE));

        Assertions.assertTrue(productColorExpect.equals(productColor));
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

    public Map<Color, Integer> mockMapColor() {
        Map<Color, Integer> productColorExpect = new HashMap<>();

        productColorExpect.put(Color.BLUE, 1);
        productColorExpect.put(Color.GRAY, 0);
        productColorExpect.put(Color.GREEN, 0);
        productColorExpect.put(Color.PINK, 0);
        productColorExpect.put(Color.RED, 0);
        productColorExpect.put(Color.WHITE, 1);

        return productColorExpect;
    }
}
