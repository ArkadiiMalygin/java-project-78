package hexlet.code.schemas;

public class StringSchema extends BaseSchema {
    private String sampleString;

    private int minLength;

    public StringSchema() {
        super();
        this.sampleString = "";
        this.minLength = 0;
    }

    public Boolean isValid(String testString) {
        if (testString == null) {
            testString = "";
        }
        if (testString.isEmpty() && this.require) {
            return false;
        }

        if (testString.length() < minLength) {
            return false;
        }
        return testString.contains(sampleString);
    }

    @Override
    public StringSchema required() {
        super.required();
        return this;
    }



    public StringSchema contains(String newSampleString) {
        this.sampleString = newSampleString;
        return this;
    }

    public StringSchema minLength(int newMinLength) {
        this.minLength = newMinLength;
        return this;
    }
}
