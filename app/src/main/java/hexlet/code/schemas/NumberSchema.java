package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {

    private int min;
    private int max;

    public NumberSchema() {
        super();
        this.min = Integer.MIN_VALUE;
        this.max = Integer.MAX_VALUE;
    }

    @Override
    public boolean isValid(Integer testSubject) {
        if (testSubject == null) {
            testSubject = 0;
        }
        if (testSubject == 0 && this.require) {
            return false;
        }

        return testSubject >= this.min && testSubject <= this.max;
    }


    public NumberSchema positive() {
        if (this.min < 1) {
            this.min = 1;
        }
        return this;
    }

    public NumberSchema range(int rangeStart, int rangeEnd) {
        this.min = rangeStart;
        this.max = rangeEnd;
        return this;
    }

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

}
