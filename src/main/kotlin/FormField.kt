import kotlinx.html.InputType
import kotlinx.html.classes
import kotlinx.html.id
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
                input {
                    attrs {
                        id = fieldId
                        type = InputType.text
                        classes = setOf("input is-small")
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