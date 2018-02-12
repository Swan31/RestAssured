package api.zonky.cz.pojo;

import java.util.List;

/**
 * Loan object.
 *
 * @author labut
 */
public class Loan {

    String id;
    String url;
    String name;
    String story;
    int purpose;
    List<Photo> photos;
    String userId;
    String nickName;
    int termInMonths;
    double interestRate;
    String rating;
    String topped;
    double amount;
    double remainingInvestment;
    double investmentRate;
    boolean covered;
    String datePublished;
    boolean published;
    String deadline;
    String myOtherInvestments;
    String borrowerRelatedInvestmentInfo;
    int investmentsCount;
    int questionsCount;
    String region;
    String mainIncomeType;
    boolean questionsAllowed;
    int activeLoansCount;
    boolean insuranceActive;

    public Loan(String id, String url, String name, String story, int purpose, List<Photo> photos, String userId, String nickName, int termInMonths, double interestRate, String rating, String topped, double amount, double remainingInvestment, double investmentRate, boolean covered, String datePublished, boolean published, String deadline, String myOtherInvestments, String borrowerRelatedInvestmentInfo, int investmentsCount, int questionsCount, String region, String mainIncomeType, boolean questionsAllowed, int activeLoansCount, boolean insuranceActive) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.story = story;
        this.purpose = purpose;
        this.photos = photos;
        this.userId = userId;
        this.nickName = nickName;
        this.termInMonths = termInMonths;
        this.interestRate = interestRate;
        this.rating = rating;
        this.topped = topped;
        this.amount = amount;
        this.remainingInvestment = remainingInvestment;
        this.investmentRate = investmentRate;
        this.covered = covered;
        this.datePublished = datePublished;
        this.published = published;
        this.deadline = deadline;
        this.myOtherInvestments = myOtherInvestments;
        this.borrowerRelatedInvestmentInfo = borrowerRelatedInvestmentInfo;
        this.investmentsCount = investmentsCount;
        this.questionsCount = questionsCount;
        this.region = region;
        this.mainIncomeType = mainIncomeType;
        this.questionsAllowed = questionsAllowed;
        this.activeLoansCount = activeLoansCount;
        this.insuranceActive = insuranceActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getPurpose() {
        return purpose;
    }

    public void setPurpose(int purpose) {
        this.purpose = purpose;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getTermInMonths() {
        return termInMonths;
    }

    public void setTermInMonths(int termInMonths) {
        this.termInMonths = termInMonths;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTopped() {
        return topped;
    }

    public void setTopped(String topped) {
        this.topped = topped;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getRemainingInvestment() {
        return remainingInvestment;
    }

    public void setRemainingInvestment(double remainingInvestment) {
        this.remainingInvestment = remainingInvestment;
    }

    public double getInvestmentRate() {
        return investmentRate;
    }

    public void setInvestmentRate(double investmentRate) {
        this.investmentRate = investmentRate;
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getMyOtherInvestments() {
        return myOtherInvestments;
    }

    public void setMyOtherInvestments(String myOtherInvestments) {
        this.myOtherInvestments = myOtherInvestments;
    }

    public String getBorrowerRelatedInvestmentInfo() {
        return borrowerRelatedInvestmentInfo;
    }

    public void setBorrowerRelatedInvestmentInfo(String borrowerRelatedInvestmentInfo) {
        this.borrowerRelatedInvestmentInfo = borrowerRelatedInvestmentInfo;
    }

    public int getInvestmentsCount() {
        return investmentsCount;
    }

    public void setInvestmentsCount(int investmentsCount) {
        this.investmentsCount = investmentsCount;
    }

    public int getQuestionsCount() {
        return questionsCount;
    }

    public void setQuestionsCount(int questionsCount) {
        this.questionsCount = questionsCount;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMainIncomeType() {
        return mainIncomeType;
    }

    public void setMainIncomeType(String mainIncomeType) {
        this.mainIncomeType = mainIncomeType;
    }

    public boolean isQuestionsAllowed() {
        return questionsAllowed;
    }

    public void setQuestionsAllowed(boolean questionsAllowed) {
        this.questionsAllowed = questionsAllowed;
    }

    public int getActiveLoansCount() {
        return activeLoansCount;
    }

    public void setActiveLoansCount(int activeLoansCount) {
        this.activeLoansCount = activeLoansCount;
    }

    public boolean isInsuranceActive() {
        return insuranceActive;
    }

    public void setInsuranceActive(boolean insuranceActive) {
        this.insuranceActive = insuranceActive;
    }

    @Override
    public String toString() {
        return "Loan{" + "id=" + id + ", url=" + url + ", name=" + name + ", story=" + story + ", purpose=" + purpose + ", photos=" + photos + ", userId=" + userId + ", nickName=" + nickName + ", termInMonths=" + termInMonths + ", interestRate=" + interestRate + ", rating=" + rating + ", topped=" + topped + ", amount=" + amount + ", remainingInvestment=" + remainingInvestment + ", investmentRate=" + investmentRate + ", covered=" + covered + ", datePublished=" + datePublished + ", published=" + published + ", deadline=" + deadline + ", myOtherInvestments=" + myOtherInvestments + ", borrowerRelatedInvestmentInfo=" + borrowerRelatedInvestmentInfo + ", investmentsCount=" + investmentsCount + ", questionsCount=" + questionsCount + ", region=" + region + ", mainIncomeType=" + mainIncomeType + ", questionsAllowed=" + questionsAllowed + ", activeLoansCount=" + activeLoansCount + ", insuranceActive=" + insuranceActive + '}';
    }

}
