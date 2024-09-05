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
        if (testString.isEmpty() && this.required) {
            return false;
        }

        if (testString.length() < minLength) {
            return false;
        }
        return testString.contains(sampleString);
    }

    public StringSchema required() {
        this.required = true;
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
