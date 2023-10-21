package fit.iuh.edu.lab05week05.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private long id;
    @Column(name = "to_date")
    private LocalDate toDate;
    @Column(name = "from_date")

    private LocalDate fromDate;
    @Column(name = "company")

    private String companyName;

    private String role;
    @Column(name = "work_desc")

    private String workDescription;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience(long id, LocalDate toDate, LocalDate fromDate, String companyName, String role, String workDescription) {
        this.id = id;
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.companyName = companyName;
        this.role = role;
        this.workDescription = workDescription;
    }

    public Experience() {
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", toDate=" + toDate +
                ", fromDate=" + fromDate +
                ", companyName='" + companyName + '\'' +
                ", role='" + role + '\'' +
                ", workDescription='" + workDescription + '\'' +
                '}';
    }
}
