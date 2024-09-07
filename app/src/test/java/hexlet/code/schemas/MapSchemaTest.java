package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapSchemaTest {

    @Test
    public void testIsValidMap() {
        var v = new Validator();
        var schema = v.map();
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));

        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");

        assertEquals(schema.isValid(human1), true);

    }
//    var v = new Validator();
//
//    var schema = v.map();
//
//    // shape позволяет описывать валидацию для значений каждого ключа объекта Map
//// Создаем набор схем для проверки каждого ключа проверяемого объекта
//// Для значения каждого ключа - своя схема
//    Map<String, BaseSchema<String>> schemas = new HashMap<>();
//
//// Определяем схемы валидации для значений свойств "firstName" и "lastName"
//// Имя должно быть строкой, обязательно для заполнения
//schemas.put("firstName", v.string().required());
//// Фамилия обязательна для заполнения и должна содержать не менее 2 символов
//schemas.put("lastName", v.string().required().minLength(2));
//
//// Настраиваем схему MapSchema
//// Передаем созданный набор схем в метод shape()
//schema.shape(schemas);
//
//    // Проверяем объекты
//    Map<String, String> human1 = new HashMap<>();
//human1.put("firstName", "John");
//human1.put("lastName", "Smith");
//schema.isValid(human1); // true
//
//    Map<String, String> human2 = new HashMap<>();
//human2.put("firstName", "John");
//human2.put("lastName", null);
//schema.isValid(human2); // false
//
//    Map<String, String> human3 = new HashMap<>();
//human3.put("firstName", "Anna");
//human3.put("lastName", "B");
//schema.isValid(human3); // false
}
