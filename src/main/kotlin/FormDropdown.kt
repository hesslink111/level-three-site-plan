import kotlinx.html.classes
import kotlinx.html.id
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*

class FormDropdown: RComponent<FormDropdown.Props, RState>() {

    interface Props: RProps {
        var label: String
        var default: String?
        var items: List<String>
    }

    private val fieldId = generateUuid()

    override fun RBuilder.render() {
        div {
            attrs {
                classes = setOf("field")
            }

            label {
                attrs {
                    htmlFor = fieldId
                    classes = setOf("label is-small")
                }
                +props.label
            }
            div {
                attrs {
                    classes = setOf("control")
                }
                div {
                    attrs {
                        classes = setOf("select is-small")
                    }
                    select {
                        attrs {
                            id = fieldId
                        }
                        props.items.forEach { optionName ->
                            option {
                                +optionName
                            }
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.formDropdown(label: String, default: String?, items: List<String>) = child(FormDropdown::class) {
    attrs.label = label
    attrs.default = default
    attrs.items = items
}