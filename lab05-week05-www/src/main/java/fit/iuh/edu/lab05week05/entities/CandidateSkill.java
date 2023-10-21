package fit.iuh.edu.lab05week05.entities;

import fit.iuh.edu.lab05week05.enums.SkillLevel;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "candidate_skill")
public class CandidateSkill {
    @Id
    @OneToOne
    @JoinColumn(name = "can_id")
    private Skill skill;

    @Id
    @OneToOne
    @JoinColumn(name = "skill_id")
    private Candidate candidate;

    @Column(name = "skill_level")
    private SkillLevel type;

    @Column(name = "more_infor")
    private String moreInfo;

    public CandidateSkill() {
    }

    public CandidateSkill(Skill skill, Candidate candidate, SkillLevel type, String moreInfo) {
        this.skill = skill;
        this.candidate = candidate;
        this.type = type;
        this.moreInfo = moreInfo;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public SkillLevel getType() {
        return type;
    }

    public void setType(SkillLevel type) {
        this.type = type;
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
        if (!(o instanceof CandidateSkill that)) return false;
        return Objects.equals(getSkill(), that.getSkill()) && Objects.equals(getCandidate(), that.getCandidate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSkill(), getCandidate());
    }

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "skill=" + skill +
                ", candidate=" + candidate +
                ", type=" + type +
                ", moreInfo='" + moreInfo + '\'' +
                '}';
    }
}
