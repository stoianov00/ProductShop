package springproject.productshop.service;

import springproject.productshop.domain.dto.export.CategoryDto;
import springproject.productshop.domain.dto.seed.CategorySeedDto;

import java.util.List;

public interface CategoryService {
    void seedCategories(CategorySeedDto[] categorySeedDtos);

    List<CategoryDto> categories();
}
