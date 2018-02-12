package api.zonky.cz.test;

import api.zonky.cz.enums.Field;
import api.zonky.cz.enums.Operation;
import api.zonky.cz.enums.Rating;
import api.zonky.cz.pojo.Loan;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Tests filtering loans by rating parameter.
 *
 * @author labut
 */
public class RatingTest extends FunctionalTest {

    private static final Logger LOGGER = LogManager.getLogger(PaginationTest.class);

    /**
     * Test default filtering ranges for rating parameter.
     */
    @Test
    public void ratingTest() {
        filterEqualResponse(5, 50, Rating.A.getValue(), Rating.B.getValue());
        filterNotEqualResponse(3, 10, Rating.A.getValue(), Rating.B.getValue());
        filterInResponse(2, 50, Rating.A.getValue(), Rating.AAA.getValue(), Rating.AAAAA.getValue());
    }

    /**
     * Filter loans equal to given single rating value.
     *
     * @param pages page to be displayed.
     * @param pageSize number of loans on the page
     * @param filterValues rating values to be filtered.
     * @return true if all loans have required rating value.
     */
    private boolean filterEqualResponse(int pages, int pageSize, String... filterValues) {
        Map<String, Integer> headers = new HashMap<>();
        headers.put("X-Size", pageSize);
        headers.put("X-Page", pages);

        for (String filterValue : filterValues) {
            String filter = prepareFilter(Field.RATING.getValue(),
                    Operation.EQUAL.getValue(), filterValue);
            String filters = prepareFilters(filter);
            Response rest = getResponse(headers, filters);
            List<Loan> filteredLoans = getLoans(rest);
            for (Loan loan : filteredLoans) {
                if (loan.getRating().equals(filterValue)) {
                    LOGGER.info("Loan with id " + loan.getId() + " has rating "
                            + loan.getRating() + " within filtered parameter " + filterValue);
                } else {
                    LOGGER.error("Loan rating " + loan.getRating()
                            + " is not in filtered parameter " + filterValue + ". Loan id " + loan.getId());
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Filter loans not equal to given single rating value.
     *
     * @param pages page to be displayed.
     * @param pageSize number of loans on the page
     * @param filterValues rating values not to be filtered.
     * @return true if all loans have other than required rating value.
     */
    private boolean filterNotEqualResponse(int pages, int pageSize, String... filterValues) {
        Map<String, Integer> headers = new HashMap<>();
        headers.put("X-Size", pageSize);
        headers.put("X-Page", pages);

        for (String filterValue : filterValues) {
            String filter = prepareFilter(Field.RATING.getValue(),
                    Operation.NOT_EQUAL.getValue(), filterValue);
            String filters = prepareFilters(filter);
            Response rest = getResponse(headers, filters);
            List<Loan> filteredLoans = getLoans(rest);
            for (Loan loan : filteredLoans) {
                if (!loan.getRating().equals(filterValue)) {
                    LOGGER.info("Loan with id " + loan.getId() + " has rating "
                            + loan.getRating() + " outside filtered parameter " + filterValue + " as expected");
                } else {
                    LOGGER.error("Loan rating " + loan.getRating()
                            + " is not in filtered parameter " + filterValue + ". Loan id " + loan.getId());
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Filter loans with any of given loan rating values from array.
     *
     * @param pages page to be displayed.
     * @param pageSize number of loans on the page
     * @param filterValues rating values not to be filtered.
     * @return true if all loans some of given loan rating values.
     */
    private boolean filterInResponse(int pages, int pageSize, String... filterValues) {
        Map<String, Integer> headers = new HashMap<>();
        headers.put("X-Size", pageSize);
        headers.put("X-Page", pages);
        String filter = prepareFilterArray(Field.RATING.getValue(),
                Operation.IN.getValue(), filterValues);
        String filters = prepareFilters(filter);

        Response rest = getResponse(headers, filters);
        List<Loan> filteredLoans = getLoans(rest);
        for (Loan loan : filteredLoans) {
            boolean match = false;
            for (String filterMatch : filterValues) {
                if (loan.getRating().equals(filterMatch)) {
                    LOGGER.info("Loan rating " + loan.getRating()
                            + " found in filtered parameters.");
                    match = true;
                    break;
                }
            }
            if (!match) {
                LOGGER.error("Loan rating " + loan.getRating()
                        + " NOT found in filtered parameters for loan id " + loan.getId());
                return false;
            }
        }
        return true;
    }
}
