package fit.iuh.edu.lab05week05.converter;

import fit.iuh.edu.lab05week05.enums.SkillLevel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SkilllevelConver implements AttributeConverter<SkillLevel,Integer> {
    @Override
    public Integer convertToDatabaseColumn(SkillLevel skillLevel) {
        if(skillLevel == null)
        {
            return null;

        }
        return skillLevel.getValue();
    }

    @Override
    public SkillLevel convertToEntityAttribute(Integer integer) {
        if(integer == null){
            return null;

        }
        return Stream.of(SkillLevel.values())
                .filter(c->c.getValue() == integer)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
