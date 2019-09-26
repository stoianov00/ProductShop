package springproject.productshop.web.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springproject.productshop.domain.dto.seed.CategorySeedDto;
import springproject.productshop.domain.dto.seed.ProductSeedDto;
import springproject.productshop.domain.dto.seed.UserSeedDto;
import springproject.productshop.service.CategoryService;
import springproject.productshop.service.ProductService;
import springproject.productshop.service.UserService;
import springproject.productshop.util.FileUtil;
import springproject.productshop.util.impl.FilePath;

import java.io.IOException;

@Controller
public class ProductShopController implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;
    private final ProductService productService;
    private final FileUtil fileUtil;
    private final Gson gson;

    @Autowired
    public ProductShopController(UserService userService, CategoryService categoryService, ProductService productService, FileUtil fileUtil, Gson gson) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.productService = productService;
        this.fileUtil = fileUtil;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedUsers();
        this.seedCategories();
        this.seedProducts();
    }

    private void seedUsers() throws IOException {
        String fileContent = this.fileUtil.fileContent(FilePath.USER_JSON_FILE_PATH);
        UserSeedDto[] userSeedDtos = this.gson.fromJson(fileContent, UserSeedDto[].class);

        this.userService.seedUsers(userSeedDtos);
        this.userService.seedFriends();
    }

    private void seedCategories() throws IOException {
        String fileContent = this.fileUtil.fileContent(FilePath.CATEGORY_JSON_FILE_PATH);
        CategorySeedDto[] categorySeedDtos = this.gson.fromJson(fileContent, CategorySeedDto[].class);

        this.categoryService.seedCategories(categorySeedDtos);
    }

    private void seedProducts() throws IOException {
        String fileContent = this.fileUtil.fileContent(FilePath.PRODUCT_JSON_FILE_PATH);
        ProductSeedDto[] productSeedDtos = this.gson.fromJson(fileContent, ProductSeedDto[].class);

        this.productService.seedProducts(productSeedDtos);
    }

}
