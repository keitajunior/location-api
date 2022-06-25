package com.ekom.locationapp.services.user;

import com.ekom.locationapp.dto.UserLocDto;
import com.ekom.locationapp.entities.UserLoc;
import com.ekom.locationapp.mappers.UserLocMapper;
import com.ekom.locationapp.repositories.UserLocRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ekom.locationapp.specifications.UserLocSpecs.withFirstname;
import static com.ekom.locationapp.specifications.UserLocSpecs.withLastname;

@Service
public class UserLocServiceImpl implements UserLocService {
    private final UserLocRepository userRepository;

    public UserLocServiceImpl(UserLocRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean exists(UserLocDto userDto) {
        UserLoc user = UserLocMapper.INSTANCE.toEntity(userDto);
        Example<UserLoc> userExample = Example.of(user, ExampleMatcher.matching().withIgnoreNullValues());
        return this.userRepository.exists(userExample);
    }

    @Override
    public List<UserLocDto> searchByFirstnameOrLastname(String searchValue) {
        List<UserLoc> users = this.userRepository.findAll(
                withFirstname(searchValue).or(withLastname(searchValue))
        );
        return UserLocMapper.INSTANCE.toDtos(users);
    }
}
