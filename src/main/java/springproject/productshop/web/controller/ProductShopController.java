package springproject.productshop.web.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springproject.productshop.repository.UserRepository;
import springproject.productshop.service.CategoryService;
import springproject.productshop.service.UserService;
import springproject.productshop.util.FileUtil;

@Controller
public class ProductShopController implements CommandLineRunner {
    private final UserService userService;
    private final CategoryService categoryService;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final UserRepository userRepository;

    @Autowired
    public ProductShopController(UserService userService, CategoryService categoryService, FileUtil fileUtil, Gson gson, UserRepository userRepository) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        String fileContent = this.fileUtil.fileContent(FilePath.CATEGORY_JSON_FILE_PATH);
//        CategorySeedDto[] categorySeedDtos = this.gson.fromJson(fileContent, CategorySeedDto[].class);
//
//        this.categoryService.seedCategories(categorySeedDtos);
    }
}
