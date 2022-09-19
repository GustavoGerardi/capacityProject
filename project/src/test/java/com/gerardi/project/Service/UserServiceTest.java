package com.gerardi.project.Service;

import com.gerardi.project.dto.UserDTO;
import com.gerardi.project.entities.User;
import com.gerardi.project.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class UserServiceTest {

    @InjectMocks //quase um autowired
    private UserService userService;

    @Mock //mockar o que está fora da classe service
    private UserRepository userRepository;

    private User user;

    private UserDTO userDTO;

    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.startUser();
    }

    @Test
    void shouldFindAllUsers() {
        //Arrange
        User user1 = new User(1, "Gustavo", "g@", "123");
        User user2 = new User(2, "Gustavo", "g@", "123");
        User user3 = new User(3, "Gustavo", "g@", "123");
        List<User> users = Arrays.asList(user1, user2, user3);

        Mockito.when(this.userRepository.findAll()).thenReturn(users);

        //Act
        List<UserDTO> usersExpected = this.userService.findAll();

        //Assert
        Assertions.assertEquals(3, usersExpected.size());
        Assertions.assertEquals(users.get(0).getName(), usersExpected.get(0).getName());
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        Mockito.when(this.userRepository.findById(Mockito.anyInt())).thenReturn(this.optionalUser);

        UserDTO response = this.userService.findById(this.optionalUser.get().getId());

        Assertions.assertEquals(UserDTO.class, response.getClass());
    }

    @Test
    void insertUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }

    private void startUser() {
        User user = new User(1, "Gustavo", "gutm86@gmail.com", "123456");
        UserDTO userDTO = new UserDTO(1, "Gustavo", "gutm86@gmail.com", "123456");
        this.optionalUser = Optional.of(new User(1, "Gustavo", "gutm86@gmail.com", "123456"));
        UserDTO user123 = UserDTO.builder()
                .id(1)
                .name("Gustavo")
                .email("gutm86@gmail.com")
                .build();
    }
}