package fit.iuh.edu.lab05week05.entities;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private long id;
    private String city;
    private String zipcode;
    @Column(name = "street")
    private String Street;
    @OneToOne(mappedBy = "address")
    private Candidate candidate;

    private String number;

    @Column(name = "country")
    private CountryCode countryCodentry;

    @OneToOne(mappedBy = "address")
    private Company company;

    public Address() {
    }

    public Address(long id, String city, String zipcode, String street, String number, CountryCode countryCodentry) {
        this.id = id;
        this.city = city;
        this.zipcode = zipcode;
        Street = street;
        this.number = number;
        this.countryCodentry = countryCodentry;
    }

    public Address(String city, String zipcode, String street, String number, CountryCode countryCodentry) {
        this.city = city;
        this.zipcode = zipcode;
        Street = street;
        this.number = number;
        this.countryCodentry = countryCodentry;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public String getNumber() {
        return number;
    }

    public CountryCode getCountryCodentry() {
        return countryCodentry;
    }

    public void setCountryCodentry(CountryCode countryCodentry) {
        this.countryCodentry = countryCodentry;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", Street='" + Street + '\'' +
                ", candidate=" + candidate +
                ", number='" + number + '\'' +
                '}';
    }
}
