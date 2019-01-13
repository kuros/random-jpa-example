package in.kuros.randomjpa.blogexample.type;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum Gender {
    MALE("M"),
    FEMALE("F");

    private final String sqlValue;

    Gender(final String sqlValue) {
        this.sqlValue = sqlValue;
    }

    public String getSqlValue() {
        return sqlValue;
    }

    public static Gender parse(final String gender) {
        for (Gender value : values()) {
            if (value.getSqlValue().equals(gender)) {
                return value;
            }
        }

        throw new RuntimeException("Gender not found: " + gender);
    }

    @Converter
    public static class GenderConverter implements AttributeConverter<Gender, String> {

        @Override
        public String convertToDatabaseColumn(final Gender gender) {
            return gender.getSqlValue();
        }

        @Override
        public Gender convertToEntityAttribute(final String s) {
            return null;
        }
    }
}
