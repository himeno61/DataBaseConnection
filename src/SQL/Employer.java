package SQL;

public class Employer {
    private int id;
    private long nip;
    private String companyName;
    private long phone;
    private String website;

    public Employer(int id, long nip, String companyName, long phone, String website) {
        this.id = id;
        this.nip = nip;
        this.companyName = companyName;
        this.phone = phone;
        this.website = website;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", nip=" + nip +
                ", companyName='" + companyName + '\'' +
                ", phone=" + phone +
                ", website='" + website + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public long getNip() {
        return nip;
    }

    public String getCompanyName() {
        return companyName;
    }

    public long getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }
}
