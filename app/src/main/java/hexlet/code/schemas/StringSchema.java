package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {


    @Override
    public StringSchema required() {
        super.required();
        return this;
    }

    public StringSchema contains(String newSampleString) {
        addPredicate("isContains", new Predicate<String>() {
            @Override
            public boolean test(String i) {
                return i.contains(newSampleString);
            }
        });
        return this;
    }

    public StringSchema minLength(int newMinLength) {
        addPredicate("isDesiredLength", new Predicate<String>() {
            @Override
            public boolean test(String i) {

                return i.length() > newMinLength;
            }
        });
        return this;
    }
}
