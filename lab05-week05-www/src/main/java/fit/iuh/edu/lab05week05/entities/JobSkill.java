package fit.iuh.edu.lab05week05.entities;

import fit.iuh.edu.lab05week05.enums.SkillLevel;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "job_skill")
public class JobSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private SkillLevel skillLevel;

    private String moreInfo;

    public JobSkill() {
    }

    public JobSkill(Job job, Skill skill, SkillLevel skillLevel, String moreInfo) {
        this.job = job;
        this.skill = skill;
        this.skillLevel = skillLevel;
        this.moreInfo = moreInfo;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobSkill jobSkill)) return false;
        return Objects.equals(getJob(), jobSkill.getJob()) && Objects.equals(getSkill(), jobSkill.getSkill());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJob(), getSkill());
    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "job=" + job +
                ", skill=" + skill +
                ", skillLevel=" + skillLevel +
                ", moreInfo='" + moreInfo + '\'' +
                '}';
    }
}
