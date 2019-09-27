package springproject.productshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springproject.productshop.domain.dto.export.CategoryDto;
import springproject.productshop.domain.dto.seed.CategorySeedDto;
import springproject.productshop.domain.entity.Category;
import springproject.productshop.repository.CategoryRepository;
import springproject.productshop.service.CategoryService;
import springproject.productshop.util.ValidatorUtil;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories(CategorySeedDto[] categorySeedDtos) {
        for (CategorySeedDto categorySeedDto : categorySeedDtos) {
            if (!this.validatorUtil.isValid(categorySeedDto)) {
                this.validatorUtil.violations(categorySeedDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));

                continue;
            }

            Category category = this.modelMapper.map(categorySeedDto, Category.class);
            this.categoryRepository.saveAndFlush(category);
        }
    }

    // EXPORT JSON
    @Override
    public List<CategoryDto> categories() {
        List<CategoryDto> categoryDtos = new ArrayList<>();

        List<Category> categories = this.categoryRepository.findAllByOrderByNameDesc();
        for (Category category : categories) {
            CategoryDto categoryDto = this.modelMapper.map(categories, CategoryDto.class);
            categoryDto.setName(category.getName());

            categoryDtos.add(categoryDto);
        }

        return categoryDtos;
    }
}