package nl.saxofoonleren.dropit.exceptions;

public class UserNotFoundException extends RuntimeException {

        public UserNotFoundException(long userId) {
            super("Cannot find user with id: " + userId);
        }

}
