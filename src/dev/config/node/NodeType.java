package dev.config.node;

import dev.config.node.array.ArrayNode;
import dev.config.node.bool.BoolNode;
import dev.config.node.number.NumberNode;
import dev.config.node.object.ObjectNode;
import dev.config.node.root.RootNode;
import dev.config.node.string.StringNode;

public enum NodeType {
    ROOT(RootNode.class),
    ARRAY(ArrayNode.class),
    OBJECT(ObjectNode.class),
    STRING(StringNode.class),
    NUMBER(NumberNode.class),
    BOOL(BoolNode.class);

    private final Class<?> type;

    NodeType(Class<?> type) {
        this.type = type;
    }

    public boolean it(ObjectNode<?> node) throws NodeInvalidException {
        if (node == null) throw new NodeInvalidException();
        return node.getClass().isAssignableFrom(type);
    }

    public Class<?> type() {
        return type;
    }
}
