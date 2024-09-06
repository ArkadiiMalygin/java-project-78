package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema<T> extends BaseSchema {
    private int size;

    private Map<String, BaseSchema<T>> schemaOfMap;

    public MapSchema() {
        super();
        this.size = -1;
        this.schemaOfMap = new HashMap<>();
    }

    public <K, V> Boolean isValid(Map<K, V> testMap) {
        if (testMap == null && this.require) {
            return false;
        }

        if (testMap == null) {
            testMap = new HashMap<>();
        }
        if (this.size > -1 && testMap.size() != this.size) {
            return false;
        }

        for (Map.Entry<K, V> entry : testMap.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            var schemaForValue = schemaOfMap.get(key);
            if (!schemaForValue.isValid(value)) {
                return false;
            }
        }
        return true;

    }

    @Override
    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int mapSize) {
        this.size = mapSize;
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<T>> mapSchema) {
        this.schemaOfMap = mapSchema;
        return this;
    }
}
