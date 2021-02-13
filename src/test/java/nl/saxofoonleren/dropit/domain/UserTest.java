package nl.saxofoonleren.dropit.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    // Arrange
    @BeforeEach
    void setUp() {
        user = new User();
        user.setFirstName("Elvis");
        user.setLastName("Presley");
    }

    @Test
    void getFullNameTest() {

        // Arrange
        String expectedFullName = "Elvis Presley";

        // Act
        String actualFullName = this.user.getFullName();

        // Assert
        assertEquals(expectedFullName, actualFullName);
    }

    @Test
    void emailToLowercaseTest() {

        // Arrange
        user.setEmail("ElvisPresley@GMAIL.com");
        String expectedEmail = "elvispresley@gmail.com";

        // Act
        String actualEmail = user.getEmail();

        // Assert
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    void emailTrimAllWhiteSpacesTest() {

        // Arrange
        user.setEmail(" elvispresl ey@gm  ail.com ");
        String expectedEmail = "elvispresley@gmail.com";

        // Act
        String actualEmail = user.getEmail();

        // Assert
        assertEquals(expectedEmail, actualEmail);
    }

    @Test
    void addDemoMakesListSizeEqualTo1() {

        // Arrange
        Demo demo = new Demo();
        demo.setSongTitle("Fly Me To The Moon");
        demo.setArtist("Frank Sinatra");

        int expectedListSize = 1;

        // Act
        user.addDemo(demo);

        // Assert
        assertEquals(expectedListSize, user.getDemos().size());
    }

}