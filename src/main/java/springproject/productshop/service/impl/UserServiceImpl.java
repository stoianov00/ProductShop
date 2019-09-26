package springproject.productshop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springproject.productshop.domain.dto.seed.UserSeedDto;
import springproject.productshop.domain.entity.User;
import springproject.productshop.repository.UserRepository;
import springproject.productshop.service.UserService;
import springproject.productshop.util.ValidatorUtil;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final Random random;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, Random random) {
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.random = random;
    }

    @Override
    public void seedUsers(UserSeedDto[] userSeedDtos) {
        for (UserSeedDto userSeedDto : userSeedDtos) {
            if (!this.validatorUtil.isValid(userSeedDto)) {
                this.validatorUtil.violations(userSeedDto)
                        .forEach(violation -> System.out.println(violation.getMessage()));

                continue;
            }

            User user = this.modelMapper.map(userSeedDto, User.class);
            this.userRepository.saveAndFlush(user);
        }

    }

    @Override
    public void seedFriends() {
        for (User user : this.userRepository.findAll()) {
            user.setFriends(this.getRandomFriends());
        }
    }

    @Override
    public Set<User> getRandomFriends() {
        int id = this.random.nextInt((int) ((this.userRepository.count()) + 1) - 1);

        Set<User> friends = new HashSet<>();
        friends.add(this.userRepository.findById(id).orElse(null));

        return friends;
    }
}
