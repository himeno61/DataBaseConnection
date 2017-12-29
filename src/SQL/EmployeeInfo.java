package SQL;

public class EmployeeInfo {
    private int minAge;
    private int maxAge;
    private int avgAge;

    public EmployeeInfo() {
    }

    public EmployeeInfo(int minAge, int maxAge, int avgAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.avgAge = avgAge;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", avgAge=" + avgAge +
                '}';
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public int getAvgAge() {
        return avgAge;
    }
}
