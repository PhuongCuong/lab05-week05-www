package fit.iuh.edu.lab05week05.enums;

public enum SkillType {
    SOFT_SKILL(1),
    UNSPECIFIC(0),
    TECHNICAL_SKILL(2);



    private int value;

    SkillType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
