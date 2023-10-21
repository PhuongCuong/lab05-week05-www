package fit.iuh.edu.lab05week05.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private long id;
    private String phone;
    private LocalDate dob;
    private String email;
    @Column(name = "full_name")
    private String fullName;

    @OneToMany(mappedBy = "candidate")
    private List<Experience> experiences;

    @OneToOne
    @JoinColumn(name = "address")

    private Address address;

    public Candidate(long id, String phone, LocalDate dob, String email, String fullName, List<Experience> experiences) {
        this.id = id;
        this.phone = phone;
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.experiences = experiences;
    }

    public Candidate(long id, String phone, LocalDate dob, String email, Address address) {
        this.id = id;
        this.phone = phone;
        this.dob = dob;
        this.email = email;
        this.address = address;
    }

    public Candidate() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", experiences=" + experiences +
                '}';
    }
}
