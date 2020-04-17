package demo.cxf.client;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class RestClient {

    private Client client;

    private Client getClient() {
        if (client == null) {
            client = ClientBuilder.newClient();
            client.register(JacksonJsonProvider.class);
            client.register(ErrorResponseFilter.class);
        }
        return client;
    }

    public String getErrorMessage() {
        WebTarget webTarget
                = getClient().target("http://www.mocky.io/v2/5e9973f433000086007b2220");
        Invocation.Builder invocationBuilder
                = webTarget.request(MediaType.APPLICATION_JSON);
        String result = null;
        try {
            result = invocationBuilder.get(String.class);
        } catch (Exception e) {
            if (e.getCause() instanceof CustomException) {
                CustomException ex = (CustomException) e.getCause();
                return ex.getMessage();
            }
        }
        return result;
    }

}
