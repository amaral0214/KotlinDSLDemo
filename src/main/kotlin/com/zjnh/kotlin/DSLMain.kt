package com.zjnh.kotlin

fun main(args: Array<String>) {
    html {
        "id"("HtmlId")
        head {
            "id"("HeadId")

        }
        body {
            id = "BodyId"
            `class` = "BodyClass"
            "a"{
                "href"("https:www.zjnh.cn")
                +"cotent balabala"
            }
        }
    }.render().let(::println)
}

fun html(block: TagNode.() -> Unit): TagNode {
    return Html().apply(block)
}

fun TagNode.head(block: Head.() -> Unit) {
    this@head + Head().apply(block)
}

fun TagNode.body(block: Body.() -> Unit) {
    this@body + Body().apply(block)
}
