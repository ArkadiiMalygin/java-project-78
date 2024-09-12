package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public class BaseSchema<T> {

    protected Map<String, Predicate<T>> listOfChecks;

    public BaseSchema() {
        this.listOfChecks = new LinkedHashMap<>();
    }

    protected BaseSchema<T> required() {
        addPredicate("isRequired", new Predicate<T>() {
            @Override
            public boolean test(T i) {
                if (i == null) {
                    return false;
                }
                return !Objects.equals(i.toString(), "");
            }
        });
        return this;
    }

    public final void addPredicate(String key, Predicate<T> predicate) {
        this.listOfChecks.put(key, predicate);
    }

    public final boolean isValid(T testSubject) {
        for (Predicate<T> predicate : listOfChecks.values()) {
            if (!predicate.test(testSubject)) {
                return false;
            }
        }
        return true;
    }
}
