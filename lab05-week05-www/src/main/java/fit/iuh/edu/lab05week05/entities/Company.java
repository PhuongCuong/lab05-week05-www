package fit.iuh.edu.lab05week05.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private long id;
    @Column(name = "comp_name")
    private String name;
    private String about;
    @OneToOne
    @JoinColumn(name = "address")
    private Address address;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    private String phone;
    @Column(name = "web_url")
    private String webURL;
    private String email;

    public Company() {
    }

    public Company(long id, String name, String about, Address address, String phone, String webURL, String email) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.address = address;
        this.phone = phone;
        this.webURL = webURL;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", about='" + about + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", webURL='" + webURL + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
