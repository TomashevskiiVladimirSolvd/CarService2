package Exceptions;

public class ToolException extends RuntimeException {
    public ToolException(String error) {
        super(error);
    }
}