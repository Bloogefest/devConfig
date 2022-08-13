package dev.config.node.string;

import dev.config.ConfigFlow;
import dev.config.annotation.Save;
import dev.config.node.object.ObjectNode;

public class StringNode extends ObjectNode<String> {
    public StringNode(ConfigFlow flow, Save save, String value) {
        super(flow, save, value);
    }
}
