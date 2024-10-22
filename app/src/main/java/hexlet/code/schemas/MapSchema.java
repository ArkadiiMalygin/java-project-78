package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema<T, V> extends BaseSchema<Map<T, V>> {

    public MapSchema() {
        super();
    }

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema<T, V> sizeof(int mapSize) {
        addPredicate("isRequiredSize", (i) -> i.size() == mapSize);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<T>> schemaOfMap) {
        addPredicate("isRequiredShape", new Predicate<Map<T, V>>() {
            @Override
            public boolean test(Map<T, V> tvMap) {
                    return schemaOfMap.entrySet().stream().allMatch(e -> {
                    Object v = tvMap.get(e.getKey());
                    return e.getValue().isValid((T) v);
                });
            }
        });
        return this;
    }
}
