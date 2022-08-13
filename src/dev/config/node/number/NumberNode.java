package dev.config.node.number;

import dev.config.ConfigFlow;
import dev.config.annotation.Save;
import dev.config.node.object.ObjectNode;

public class NumberNode extends ObjectNode<Number> {
    public NumberNode(ConfigFlow flow, Save save, Number value) {
        super(flow, save, value);
    }
}
