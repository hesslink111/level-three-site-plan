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

    override fun RBuilder.render() {
        div {
            label {
                +props.label
                select {
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

fun RBuilder.formDropdown(label: String, default: String?, items: List<String>) = child(FormDropdown::class) {
    attrs.label = label
    attrs.default = default
    attrs.items = items
}