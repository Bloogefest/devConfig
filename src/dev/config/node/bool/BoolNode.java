package dev.config.node.bool;

import dev.config.ConfigFlow;
import dev.config.annotation.Save;
import dev.config.node.object.ObjectNode;

public class BoolNode extends ObjectNode<Boolean> {
    public BoolNode(ConfigFlow flow, Save save, Boolean value) {
        super(flow, save, value);
    }
}
