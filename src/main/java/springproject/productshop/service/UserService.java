package springproject.productshop.service;

import springproject.productshop.domain.dto.seed.UserSeedDto;

public interface UserService {
    void seedUsers(UserSeedDto[] userSeedDtos);
}
