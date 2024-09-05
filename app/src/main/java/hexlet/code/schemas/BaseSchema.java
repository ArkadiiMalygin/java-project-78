package hexlet.code.schemas;

public class BaseSchema<T> {
    protected Boolean required;

    public BaseSchema() {
        this.required = false;
    }

    public BaseSchema<T> required() {
        this.required = true;
        return this;
    }
}
