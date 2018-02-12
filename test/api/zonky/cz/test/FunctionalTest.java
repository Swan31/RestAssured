package api.zonky.cz.test;

import api.zonky.cz.pojo.Loan;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.BeforeClass;

/**
 *
 * @author labut
 */
public abstract class FunctionalTest {

    /**
     * Setup connetion properties before running a test.
     */
    @BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = 8080;
        } else {
            RestAssured.port = Integer.valueOf(port);
        }

        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = "/loans/marketplace";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = "https://api.zonky.cz";
        }
        RestAssured.baseURI = baseHost;
    }

    /**
     * Gets response with default parameters.
     *
     * @return rest response.
     */
    public Response getResponse() {
        return when().get().then().contentType(ContentType.JSON).extract().response();
    }

    /**
     * Sends request with given headers and gets a response.
     *
     * @param headers map of headers.
     * @return rest response.
     */
    public Response getResponse(Map<String, ?> headers) {
        return given().headers(headers).when().get().then().contentType(ContentType.JSON).extract().response();
    }

    /**
     * Sends request with given headers and filters and gets a response.
     *
     * @param headers map of headers.
     * @param filter filters to be used.
     * @return rest response.
     */
    public Response getResponse(Map<String, ?> headers, String filter) {
        return given().headers(headers).when().get("https://api.zonky.cz/loans/marketplace" + filter).then().contentType(ContentType.JSON).extract().response();
    }

    /**
     * Retrieves list of loan objects from given rest response.
     *
     * @param rest rest response.
     * @return list of loans.
     */
    public List<Loan> getLoans(Response rest) {
        Gson gson = new Gson();
        List<Loan> returnedLoans = gson.fromJson(rest.prettyPrint(), new TypeToken<List<Loan>>() {
        }.getType());

        return returnedLoans;
    }

    /**
     * Retrieves loan ids from given loans.
     *
     * @param loans
     * @return loan ids.
     */
    public List<String> getLoanIds(List<Loan> loans) {
        List<String> loanIds = new ArrayList<>();
        loans.forEach((l) -> {
            loanIds.add(l.getId());
        });
        return loanIds;
    }

    /**
     * Prepare filter with single integer value.
     *
     * @param field field to be filtered.
     * @param operation how to filter.
     * @param value value to filter.
     * @return filter command.
     */
    public String prepareFilter(String field, String operation, int value) {
        return prepareFilter(field, operation, String.valueOf(value));
    }

    /**
     * Prepare filter with single String value.
     *
     * @param field field to be filtered.
     * @param operation how to filter.
     * @param value value to filter.
     * @return filter command.
     */
    public String prepareFilter(String field, String operation, String value) {
        if (field != null || operation != null || value != null) {
            StringBuilder sb = new StringBuilder("");
            sb.append(field);
            sb.append("__");
            sb.append(operation);
            sb.append("=");
            sb.append(value);
            return sb.toString();
        }
        return null;
    }

    /**
     * Prepare filter with array.
     *
     * @param field field to be filtered.
     * @param operation how to filter.
     * @param values values to filter.
     * @return filter command.
     */
    public String prepareFilterArray(String field, String operation, String... values) {
        String filter = null;
        StringBuilder sb = new StringBuilder(field + "__" + operation + "=[");
        int numberOfValues = values.length;
        for (int i = 0; i < numberOfValues; i++) {
            sb.append("\"");
            String value = values[i];
            sb.append(value);
            sb.append("\"");
            if (i == (numberOfValues - 1)) {
                sb.append("]");
            } else if (values.length != 1) {
                sb.append(",");
            }
            filter = sb.toString();
        }
        return filter;
    }

    /**
     * Prepare given filter to use in uri.
     *
     * @param filters to be prepared.
     * @return filters to use in uri.
     */
    public String prepareFilters(String... filters) {
        String filter = null;
        StringBuilder sb = new StringBuilder("?");
        int numberOfValues = filters.length;
        for (int i = 0; i < numberOfValues; i++) {
            String value = filters[i];
            sb.append(value);
            if (filters.length != 1 && (!(i == (numberOfValues - 1)))) {
                sb.append("&");
            }
            filter = sb.toString();
        }
        return filter;
    }
}
