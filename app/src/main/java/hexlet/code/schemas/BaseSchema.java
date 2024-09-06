package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    protected Boolean require;

    public BaseSchema() {
        this.require = false;
    }

    public BaseSchema required() {
        this.require = true;
        return this;
    }

    public abstract boolean isValid(T testSubject);
}
