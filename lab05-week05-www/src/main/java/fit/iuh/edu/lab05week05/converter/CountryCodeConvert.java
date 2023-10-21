package fit.iuh.edu.lab05week05.converter;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CountryCodeConvert implements AttributeConverter<CountryCode,Integer> {

    @Override
    public Integer convertToDatabaseColumn(CountryCode countryCode) {
        if(countryCode == null){
            return null;

        }
        return countryCode.getNumeric();
    }

    @Override
    public CountryCode convertToEntityAttribute(Integer integer) {
        if(integer == null){
            return null;

        }
        return CountryCode.getByCode(integer);
    }
}
