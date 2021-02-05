//package nl.saxofoonleren.dropit.repository;
//
//import nl.saxofoonleren.dropit.DropitApi;
//import nl.saxofoonleren.dropit.domain.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ContextConfiguration;
//
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@ContextConfiguration(classes={DropitApi.class})
//class UserRepositoryTest {
//
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Test
//    void findByUsername() {
//
//        // Arrange
//        User user = new User();
//        user.setFirstName("Elvis");
//        user.setLastName("Presley");
//        user.setUsername("elvispresley");
//        entityManager.persist(user);
//        entityManager.flush();
//
//        // when
//        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
//
//        // then
//        String expected = "Elvis Presley";
//        String actual = optionalUser.get().getFullName();
//        assertEquals(expected, actual);
//    }
//}