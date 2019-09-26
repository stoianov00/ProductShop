package springproject.productshop.service;

import springproject.productshop.domain.dto.seed.ProductSeedDto;

public interface ProductService {
    void seedProducts(ProductSeedDto[] productSeedDtos);
}
