package nl.saxofoonleren.dropit.exceptions;

public class MaxUploadSizeExceededException extends RuntimeException {

    public MaxUploadSizeExceededException() {
        super("Maximum upload size exceeded");
    }

}
