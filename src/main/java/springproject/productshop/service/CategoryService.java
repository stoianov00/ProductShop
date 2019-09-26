package springproject.productshop.service;

import springproject.productshop.domain.dto.seed.CategorySeedDto;

public interface CategoryService {
    void seedCategories(CategorySeedDto[] categorySeedDtos);
}
