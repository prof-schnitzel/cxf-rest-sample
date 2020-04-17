package demo.cxf.client;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;
import javax.ws.rs.core.Response;
import java.io.IOException;

public class ErrorResponseFilter implements ClientResponseFilter {

    public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
        if (responseContext.getStatus() != Response.Status.OK.getStatusCode() && responseContext.hasEntity()) {
            CustomExceptionData customExceptionData = new ObjectMapper().readValue(responseContext.getEntityStream(),
                    CustomExceptionData.class);

            throw new CustomException(customExceptionData.getErrorNr(), customExceptionData.getStatus(),
                    customExceptionData.getMessage());
        }
    }

}
