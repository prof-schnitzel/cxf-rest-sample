package demo.cxf.client;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomExceptionData {

    private int status;
    private String message;
    private int errorNr;

}
