package nl.saxofoonleren.dropit.exceptions;

public class DemoNotFoundException extends RuntimeException {

    public DemoNotFoundException(long demoId) {
        super("Cannot find demo with id: " + demoId);
    }
}
