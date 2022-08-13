package dev.config.node.object;

import dev.config.ConfigFlow;
import dev.config.annotation.Save;

public class ObjectNode<T> {
    protected final ConfigFlow flow;
    protected final Save save;

    protected final T value;

    public ObjectNode(ConfigFlow flow, Save save, T value) {
        this.flow = flow;
        this.save = save;

        this.value = value;
    }

    public ConfigFlow flow() {
        return flow;
    }

    public Save save() {
        return save;
    }

    public T value() {
        return value;
    }
}
