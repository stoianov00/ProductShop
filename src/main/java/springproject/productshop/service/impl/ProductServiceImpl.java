package springproject.productshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import springproject.productshop.domain.dto.seed.ProductSeedDto;
import springproject.productshop.domain.entity.Category;
import springproject.productshop.domain.entity.Product;
import springproject.productshop.domain.entity.User;
import springproject.productshop.repository.CategoryRepository;
import springproject.productshop.repository.ProductRepository;
import springproject.productshop.repository.UserRepository;
import springproject.productshop.service.ProductService;
import springproject.productshop.util.ValidatorUtil;

import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final Random random;

    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository,
                              ValidatorUtil validatorUtil, ModelMapper modelMapper, Random random) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedProducts(ProductSeedDto[] productSeedDtos) {
        for (ProductSeedDto productSeedDto : productSeedDtos) {
            productSeedDto.setSeller(this.getRandomSeller());
            productSeedDto.setBuyer(this.getRandomBuyer());

            if (!this.validatorUtil.isValid(productSeedDto)) {
                this.validatorUtil.violations(productSeedDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));

                continue;
            }

            Product product = this.modelMapper.map(productSeedDto, Product.class);
            this.productRepository.saveAndFlush(product);
        }

//        this.categoryRepository.saveAll(this.getRandomCategories());
    }

    private User getRandomSeller() {
        int id = this.random.nextInt((int) ((this.userRepository.count()) + 1) - 1);

        return this.userRepository.findById(id).orElse(null);
    }

    private User getRandomBuyer() {
        int id = this.random.nextInt((int) ((this.userRepository.count()) + 1) - 1);
        if (id % 4 == 0) {
            return null;
        }

        return this.userRepository.findById(id).orElse(null);
    }

    private List<Category> getRandomCategories(Product product) {
        List<Category> categories = this.categoryRepository.findAll();

        int id = this.random.nextInt((int) ((this.categoryRepository.count()) + 1) - 1);
        for (int i = 0; i < id; i++) {
            Category category = categories.get(random.nextInt(i));
            category.getProducts().add(product);
        }

        return categories;
    }


}
