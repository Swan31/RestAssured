package api.zonky.cz.test;

import api.zonky.cz.enums.Field;
import api.zonky.cz.enums.Operation;
import api.zonky.cz.pojo.Loan;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Tests filtering loans by termsInMonth parameter.
 *
 * @author labut
 */
public class TermsInMonthTest extends FunctionalTest {

    private static final Logger LOGGER = LogManager.getLogger(PaginationTest.class);

    /**
     * Test default filtering ranges for termsInMonth parameter.
     */
    @Test
    public void termsInMonthTest() {
        // test loans to a year
        loansToYear();
        // test loans from 1 to 3 years
        loansFromTo(12, 36);
        // test loans from 3 to 5 years
        loansFromTo(36, 60);
        // test loans from 5 to 7 years
        loansFromTo(60, 84);
    }

    /**
     * Tests filtering loans with due date to a year.
     *
     * @return true if all filtered loan due dates are to a year.
     */
    private boolean loansToYear() {
        Map<String, Integer> headers = new HashMap<>();
        headers.put("X-Size", 50);
        int filterValue = 12;
        String filterValueTo = prepareFilter(Field.TERMS_IN_MONTH.getValue(),
                Operation.LOWER_EQUAL.getValue(), filterValue);
        String filters = prepareFilters(filterValueTo);
        Response rest = getResponse(headers, filters);
        List<Loan> filteredLoans = getLoans(rest);
        for (Loan loan : filteredLoans) {
            if (loan.getTermInMonths() <= filterValue) {
                LOGGER.info("Loan term " + loan.getTermInMonths()
                        + " is up to a year. Loan id " + loan.getId());
            } else {
                LOGGER.error("Loan term " + loan.getTermInMonths()
                        + " is more than a year. Loan id " + loan.getId());
                return false;
            }
        }
        return true;
    }

    /**
     * Tests filtering loans with due date in specified range.
     *
     * @param valueFrom lower range value in months.
     * @param valueTo higher range value in months.
     * @return true if all filtered loan due dates are within the range.
     */
    private boolean loansFromTo(int valueFrom, int valueTo) {
        Map<String, Integer> headers = new HashMap<>();
        headers.put("X-Size", 50);

        // prepare filters
        String filterValueTo = prepareFilter(Field.TERMS_IN_MONTH.getValue(),
                Operation.LOWER_EQUAL.getValue(), valueTo);
        String filterValueFrom = prepareFilter(Field.TERMS_IN_MONTH.getValue(),
                Operation.GREATER_EQUAL.getValue(), valueFrom);
        String filters = prepareFilters(filterValueFrom, filterValueTo);

        // get response and loans
        Response rest = getResponse(headers, filters);
        List<Loan> filteredLoans = getLoans(rest);
        for (Loan loan : filteredLoans) {
            int loanTerm = loan.getTermInMonths();
            if (valueFrom <= loanTerm && loanTerm <= valueTo) {
                LOGGER.info("Loan term " + loan.getTermInMonths() + " is between " + valueFrom
                        + " and " + valueTo + " months. Loan id " + loan.getId());
            } else {
                LOGGER.error("Loan term " + loan.getTermInMonths() + " is NOT between "
                        + valueFrom + " and " + valueTo + " months. Loan id " + loan.getId());
                return false;
            }
        }
        return true;
    }
}
