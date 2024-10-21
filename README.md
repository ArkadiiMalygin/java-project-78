### Hexlet tests and linter status:
[![Actions Status](https://github.com/ArkadiiMalygin/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/ArkadiiMalygin/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/7ce817444db444685eee/maintainability)](https://codeclimate.com/github/ArkadiiMalygin/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/7ce817444db444685eee/test_coverage)](https://codeclimate.com/github/ArkadiiMalygin/java-project-78/test_coverage)

### Description
This is a library that helps validate Map, Strings or Numbers. You can add this library to your project, and use all of its functionality.

### Methods

## Numbers
<pre>
    import hexlet.code.Validator;
    import hexlet.code.schemas.NumberSchema;
    
    var v = new Validator();
    
    var schema = v.number();
    
    schema.isValid(5); // true

    schema.isValid(null); // true
    schema.positive().isValid(null); // true
    
    schema.required();
    
    schema.isValid(null); // false
    schema.isValid(10); // true

    schema.isValid(-10); // false
    
    schema.isValid(0); // false
    
    schema.range(5, 10);
    
    schema.isValid(5); // true
    schema.isValid(10); // true
    schema.isValid(4); // false
    schema.isValid(11); // false
</pre>


## String
<pre>
    import hexlet.code.Validator;
    import hexlet.code.schemas.StringSchema;
    
    var v = new Validator();
    
    var schema = v.string();

    schema.isValid(""); // true
    schema.isValid(null); // true
    
    schema.required();
    
    schema.isValid(null); // false
    schema.isValid(""); // false
    schema.isValid("what does the fox say"); // true
    schema.isValid("hexlet"); // true
    
    schema.contains("wh").isValid("what does the fox say"); // true
    schema.contains("what").isValid("what does the fox say"); // true
    schema.contains("whatthe").isValid("what does the fox say"); // false
    
    schema.isValid("what does the fox say"); // false
    // Здесь уже false, так как добавлена еще одна проверка contains("whatthe")
    
    var schema1 = v.string();
    schema1.minLength(10).minLength(4).isValid("Hexlet"); // true
</pre>

## Map<>
<pre>
    var v = new Validator();

    var schema = v.map();
    
    schema.isValid(null); // true
    
    schema.required();
    
    schema.isValid(null); // false
    schema.isValid(new HashMap<>()); // true
    var data = new HashMap<String, String>();
    data.put("key1", "value1");
    schema.isValid(data); // true
    
    schema.sizeof(2);
    
    schema.isValid(data);  // false
    data.put("key2", "value2");
    schema.isValid(data); // true

    v = new Validator();

    var schema = v.map();
    
    // shape позволяет описывать валидацию для значений каждого ключа объекта Map
    // Создаем набор схем для проверки каждого ключа проверяемого объекта
    // Для значения каждого ключа - своя схема
    Map<String, BaseSchema<String>> schemas = new HashMap<>();
    
    // Определяем схемы валидации для значений свойств "firstName" и "lastName"
    // Имя должно быть строкой, обязательно для заполнения
    schemas.put("firstName", v.string().required());
    // Фамилия обязательна для заполнения и должна содержать не менее 2 символов
    schemas.put("lastName", v.string().required().minLength(2));
    
    // Настраиваем схему `MapSchema`
    // Передаем созданный набор схем в метод shape()
    schema.shape(schemas);
    
    // Проверяем объекты
    Map<String, String> human1 = new HashMap<>();
    human1.put("firstName", "John");
    human1.put("lastName", "Smith");
    schema.isValid(human1); // true
    
    Map<String, String> human2 = new HashMap<>();
    human2.put("firstName", "John");
    human2.put("lastName", null);
    schema.isValid(human2); // false
    
    Map<String, String> human3 = new HashMap<>();
    human3.put("firstName", "Anna");
    human3.put("lastName", "B");
    schema.isValid(human3); // false
</pre>