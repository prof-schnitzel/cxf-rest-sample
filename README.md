# JAX-RS rest clients and error responses

The rest client in this repository sends a GET request to a mocked endpoint and expects a `404 NOT FOUND`.
The mocked endpoint can be found at `http://www.mocky.io/v2/5e9973f433000086007b2220`. If this URL does not exist anymore,
go to `mocky.io` and create a custom response with status code 404 and with the body:

```
{
    "status": 404,
    "message": "This is a custom error message",
    "errorNr": 13400
}
```
This example only works with the Jersey JAX-RS implementation. When using Apache CXF the body of the error response is 
suppressed. You can edit the file `pom.xml` to verify that this example is correctly working with Jersey.
