package no.acntech.todo;

import java.util.Objects;

public final class Todo {

    private final Long id;
    private final String text;
    private final boolean done;

    public Todo(final Long id, final String text, final boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final Todo todo = (Todo) o;
        return done == todo.done &&
                Objects.equals(id, todo.id) &&
                Objects.equals(text, todo.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, done);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", done=" + done +
                '}';
    }
}
