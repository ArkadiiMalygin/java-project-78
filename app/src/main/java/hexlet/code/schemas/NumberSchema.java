package hexlet.code.schemas;

import java.util.ArrayList;

public class NumberSchema extends BaseSchema {

    private int min;
    private int max;

    public NumberSchema() {
        super();
        this.min = Integer.MIN_VALUE;
        this.max = Integer.MAX_VALUE;
    }

    public Boolean isValid(Integer testNumber) {
        if (testNumber == null) {
            testNumber = 0;
        }
        if (testNumber == 0 && this.require) {
            return false;
        }

        return testNumber >= this.min && testNumber <= this.max;
    }

    @Override
    public NumberSchema required() {
        super.required();
        return this;
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

}
