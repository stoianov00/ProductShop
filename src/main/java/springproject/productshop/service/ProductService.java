package springproject.productshop.service;

import springproject.productshop.domain.dto.export.ProductRangeDto;
import springproject.productshop.domain.dto.export.SoldProductDto;
import springproject.productshop.domain.dto.seed.ProductSeedDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos);

    List<ProductRangeDto> productsInRange(BigDecimal minPrice, BigDecimal maxPrice);

    List<SoldProductDto> soldProducts();
}
