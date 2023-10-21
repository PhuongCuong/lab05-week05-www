package fit.iuh.edu.lab05week05.converter;

import fit.iuh.edu.lab05week05.enums.SkillType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SkillTypeConvert implements AttributeConverter<SkillType,Integer> {
    @Override
    public Integer convertToDatabaseColumn(SkillType skillType) {
        if(skillType == null){
            return null;
        }
        return skillType.getValue();
    }

    @Override
    public SkillType convertToEntityAttribute(Integer integer) {
        if(integer == null){
            return null;
        }
        return Stream.of(SkillType.values())
                .filter(c->c.getValue() == integer)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
