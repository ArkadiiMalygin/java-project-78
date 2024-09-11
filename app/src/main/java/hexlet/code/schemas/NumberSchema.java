package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema<Integer> {


    public NumberSchema() {
        super();
    }


    public NumberSchema positive() {
        addPredicate("isPositive", new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i > 0;
            }
        });
        return this;
    }

    public NumberSchema range(int rangeStart, int rangeEnd) {
        addPredicate("isInRange", new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i >= rangeStart && i <= rangeEnd;
            }
        });
        return this;
    }

    @Override
    public NumberSchema required() {
        super.required();
        return this;
    }

}
