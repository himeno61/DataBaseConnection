package SQL;

public class SalaryCount {
    private int sallary;
    private int count;

    public SalaryCount() {
    }

    public SalaryCount(int sallary, int count) {
        this.sallary = sallary;
        this.count = count;
    }

    @Override
    public String toString() {
        return "SalaryCount{" +
                "sallary=" + sallary +
                ", count=" + count +
                '}';
    }

    public int getSallary() {
        return sallary;
    }

    public int getCount() {
        return count;
    }
}
