package springproject.productshop.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springproject.productshop.domain.dto.seed.UserSeedDto;
import springproject.productshop.domain.entity.User;
import springproject.productshop.repository.UserRepository;
import springproject.productshop.util.ValidatorUtil;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
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
        List<User> users = this.userRepository.findAll();

        for (User user : users) {
            user.setFriends(this.getRandomFriends());
        }
    }

    @Override
    public Set<User> getRandomFriends() {
        Random random = new Random();
        int id = random.nextInt((int) ((this.userRepository.count()) + 1) - 1);

        Set<User> friends = new HashSet<>();
        friends.add(this.userRepository.findById(id).orElse(null));

        return friends;
    }
}
