package dev.config.node.array;

import dev.config.ConfigFlow;
import dev.config.annotation.Save;
import dev.config.node.object.ObjectNode;

public class ArrayNode<T> extends ObjectNode<T[]> {
    public ArrayNode(ConfigFlow flow, Save save, T[] value) {
        super(flow, save, value);
    }
}
