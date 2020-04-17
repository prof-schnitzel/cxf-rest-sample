package demo.cxf.client;

import java.io.IOException;

public class CustomException extends IOException {

    private int errorNr;
    private int status;
    private String message;

    public CustomException() {
        super();
    }

    public CustomException(int errorNr, int status, String message) {
        super(message);
        this.errorNr = errorNr;
        this.status = status;
        this.message = message;
    }

}
