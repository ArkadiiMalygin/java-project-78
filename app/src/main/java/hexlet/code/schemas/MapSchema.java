package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema<T, V> extends BaseSchema<Map<String, V>> {
    private int size;

    private Map<String, BaseSchema<T>> schemaOfMap;

    public MapSchema() {
        super();
        this.size = -1;
        this.schemaOfMap = new HashMap<>();
    }
    @Override
    public boolean isValid(Map<String, V> testMap) {
        if (testMap == null && this.require) {
            return false;
        }

        if (testMap == null) {
            testMap = new HashMap<>();
        }
        if (this.size > -1 && testMap.size() != this.size) {
            return false;
        }


        for (Map.Entry<String, V> entry : testMap.entrySet()) {
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
                    if (!schemaForMapValue.isValid((Map<String, V>) value)) {
                        return false;
                    }
                    break;
                default:
                    System.out.println("unexpected");
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
