import kotlinx.html.classes
import react.dom.*
import kotlin.browser.document

fun main(args: Array<String>) {
    render(document.getElementById("react-root")) {
        div {
            attrs {
                classes = setOf("container")
            }

            div {
                attrs {
                    classes = setOf("level")
                }
                div {
                    attrs {
                        classes = setOf("column")
                    }
                    contactInput()
                }

                div {
                    attrs {
                        classes = setOf("column")
                    }
                    addressInput()
                }
            }
        }
    }
}