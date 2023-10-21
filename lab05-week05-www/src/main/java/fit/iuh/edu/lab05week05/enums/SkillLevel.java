package fit.iuh.edu.lab05week05.enums;

public enum SkillLevel {
    BEGINER(0),
    INTERMEDIATE(1),
    ADVANCED(2),
    MASTER(3),
    PROFESSIONAL(4);
    private int value;

    SkillLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
