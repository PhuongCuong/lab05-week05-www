package fit.iuh.edu.lab05week05.entities;

import fit.iuh.edu.lab05week05.enums.SkillType;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long id;
    @Column(name = "skill_desc")
    private String skillDescription;
    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_type")
    private SkillType type;

    @OneToMany(mappedBy = "skill")
    private List<JobSkill> jobSkills;

    public Skill() {
    }


    public Skill(long id, String skillDescription, String skillName, SkillType type) {
        this.id = id;
        this.skillDescription = skillDescription;
        this.skillName = skillName;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public SkillType getType() {
        return type;
    }

    public void setType(SkillType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skillDescription='" + skillDescription + '\'' +
                ", skillName='" + skillName + '\'' +
                ", type=" + type +
                '}';
    }
}
