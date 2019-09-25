package springproject.productshop.service;

import springproject.productshop.domain.dto.seed.UserSeedDto;
import springproject.productshop.domain.entity.User;

import java.util.Set;

public interface UserService {
    void seedUsers(UserSeedDto[] userSeedDtos);

    void seedFriends();

    Set<User> getRandomFriends();
}
