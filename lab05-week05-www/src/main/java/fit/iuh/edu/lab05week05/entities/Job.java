package fit.iuh.edu.lab05week05.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id")
    private long id;
    @Column(name = "job_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;

    @Column(name = "job_des")
    private String description;

    @OneToMany(mappedBy = "job")
    private List<JobSkill> jobSkills;

    public Job() {
    }

    public Job(long id, String name, Company company, String description) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.description = description;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "JobService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", description='" + description + '\'' +
                '}';
    }
}
