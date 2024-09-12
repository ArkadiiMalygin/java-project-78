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
                for (Map.Entry<T, V> entry : tvMap.entrySet()) {
                    var key = entry.getKey();
                    var value = entry.getValue();
                    switch (schemaOfMap.get(key).getClass().getSimpleName()) {
                        case "StringSchema" :
                            StringSchema schemaForStringValue = (StringSchema) schemaOfMap.get(key);
                            if (!schemaForStringValue.isValid((String) value)) {
                                return false;
                            }
                            break;
                        case "NumberSchema" :
                            NumberSchema schemaForNumberValue = (NumberSchema) schemaOfMap.get(key);
                            if (!schemaForNumberValue.isValid((Integer) value)) {
                                return false;
                            }
                            break;
                        case "MapSchema" :
                            MapSchema schemaForMapValue = (MapSchema) schemaOfMap.get(key);
                            if (!schemaForMapValue.isValid((Map<T, V>) value)) {
                                return false;
                            }
                            break;
                        default:
                            System.out.println("unexpected");
                    }
                }
                return true;
            }
        });
        return this;
    }
}
