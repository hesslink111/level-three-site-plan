import kotlinx.html.InputType
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.input
import react.dom.label

class FormField: RComponent<FormField.Props, RState>() {

    interface Props: RProps {
        var label: String
        var placeHolder: String
        var inputType: InputType
    }

    override fun RBuilder.render() {
        div {
            label {
                +props.label
                input {
                    attrs {
                        type = props.inputType
                        placeholder = props.placeHolder
                    }
                }
            }
        }
    }
}

fun RBuilder.formField(label: String, placeHolder: String, inputType: InputType) = child(FormField::class) {
    attrs.label = label
    attrs.placeHolder = placeHolder
    attrs.inputType = inputType
}