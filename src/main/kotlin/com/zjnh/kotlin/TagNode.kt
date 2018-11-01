package com.zjnh.kotlin

open class TagNode(val name: String) : Node {

    val children = ArrayList<Node>()

    val properties = HashMap<String, String>()

    operator fun String.invoke(value: String) {
        properties[this] = value
    }

    operator fun String.invoke(block: TagNode.() -> Unit) {
        children.add(TagNode(this).apply(block))
    }

    operator fun String.unaryPlus() {
        children.add(StringNode(this))
    }

    operator fun plus(node: Node) {
        children.add(node)
    }

    override fun render(): String {
        return StringBuilder()
                .append("<")
                .append(name)
                .apply {
                    if (!properties.isEmpty()) {
                        properties.forEach {
                            this.append(" ").append(it.key).append("=\"")
                                    .append(it.value).append("\"")
                        }
                    }
                }
                .append(">")
                .apply {
                    children.asSequence().map(Node::render).map(this::append).toList()
                }
                .append("</$name>")
                .toString()
    }

}