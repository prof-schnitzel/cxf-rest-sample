package demo.cxf.client;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

public class ClientTest {

    @Test
    public void testClient() {
        RestClient restClient = new RestClient();
        assertThat(restClient.getErrorMessage(), is("This is a custom error message"));
    }

}
