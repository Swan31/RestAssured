package api.zonky.cz.test;

import api.zonky.cz.pojo.Loan;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

/**
 * Tests pagination of loans.
 *
 * @author labut
 */
public class PaginationTest extends FunctionalTest {

    private static final Logger logger = LogManager.getLogger(PaginationTest.class);

    /**
     * List of all loan ids.
     */
    private List<String> allLoanIds;
    /**
     * Loand id of the first loan on a page.
     */
    private int pageStart = 0;
    /**
     * Loand id of the last loan on a page.
     */
    private int pageEnd = 0;

    @Test
    public void paginationTest() {
        getAllLoanIds(50);
        paginationResponse(7, 3);
        paginationResponse(2, 4);
        paginationResponse(3, 7);
    }

    private boolean paginationResponse(int pages, int pageSize) {
        Map<String, Integer> headers = new HashMap<>();
        headers.put("X-Size", pageSize);
        headers.put("X-Page", pages);

        //get loans for the page
        List<Loan> loans = getLoans(getResponse(headers));

        // verify number of loans on page
        int numberOfRecords = loans.size();
        if (numberOfRecords == pageSize) {
            logger.info("Correct number of records on page.");
        } else {
            logger.error("Number of records on page does not match!");
            return false;
        }

        // verify loans on the page
        List<String> pageLoanIds = getLoanIds(loans);
        setPage(pages, pageSize);

        for (String id : pageLoanIds) {
            if (allLoanIds.contains(id)) {
                int idPosition = allLoanIds.indexOf(id);
                if ((pageStart <= idPosition) && (idPosition <= pageEnd)) {
                    logger.info("Loan with id: " + id + " found on page.");
                } else {
                    logger.error("Loan with id: " + id + " NOT found on page.");
                    return false;
                }
            } else {
                logger.error("Loan with id: " + id + " NOT found.");
                return false;
            }
        }
        return true;
    }

    /**
     * Sets page parameters.
     *
     * @param pages page to be displayed.
     * @param pageSize number of loans on the page.
     */
    private void setPage(int pages, int pageSize) {
        pageStart = pages * pageSize;
        pageEnd = pageStart + (pageSize - 1);
    }

    /**
     * Gets all loans to be used for the verification of pagination.
     *
     * @param loans list of loan ids.
     */
    private void getAllLoanIds(int loans) {
        Map<String, Integer> headers = new HashMap<>();
        headers.put("X-Size", loans);
        Response rest = getResponse(headers);
        this.allLoanIds = getLoanIds(getLoans(rest));
    }
}
