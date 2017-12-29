package SQL;

public class Address {
    private int id;
    private String street;
    private int zip_code;
    private String city;

    public Address(int id, String street, int zip_code, String city) {
        this.id = id;
        this.street = street;
        this.zip_code = zip_code;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public int getZip_code() {
        return zip_code;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", zip_code=" + zip_code +
                ", city='" + city + '\'' +
                '}';
    }
}
