package springproject.productshop.web.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import springproject.productshop.domain.dto.seed.UserSeedDto;
import springproject.productshop.repository.UserRepository;
import springproject.productshop.service.UserService;
import springproject.productshop.util.FileUtil;
import springproject.productshop.util.impl.FilePath;

@Controller
public class ProductShopController implements CommandLineRunner {
    private final UserService userService;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final UserRepository userRepository;

    @Autowired
    public ProductShopController(UserService userService, FileUtil fileUtil, Gson gson, UserRepository userRepository) {
        this.userService = userService;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        String fileContent = this.fileUtil.fileContent(FilePath.USER_JSON_FILE_PATH);
        UserSeedDto[] userSeedDtos = this.gson.fromJson(fileContent, UserSeedDto[].class);
        this.userService.seedUsers(userSeedDtos);
        this.userService.seedFriends();
    }
}
