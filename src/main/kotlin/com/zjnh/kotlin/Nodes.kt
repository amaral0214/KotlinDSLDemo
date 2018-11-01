package com.zjnh.kotlin

class Html : TagNode("html")

class Head : TagNode("head")

class Body : TagNode("body") {
    var id by MapDelegate(properties)

    var `class` by MapDelegate(properties)
}
