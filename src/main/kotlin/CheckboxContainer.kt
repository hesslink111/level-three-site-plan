import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.input

class CheckboxContainer(initialProps: CheckboxContainer.Props): RComponent<CheckboxContainer.Props, CheckboxContainer.State>(initialProps) {

    interface Props: RProps {
        var defaultChecked: Boolean
    }

    interface State: RState {
        var checkboxChecked: Boolean
    }

    init {
        state.checkboxChecked = initialProps.defaultChecked
    }

    override fun RBuilder.render() {

        input {
            attrs {
                type = InputType.checkBox
                defaultChecked = props.defaultChecked
                onChangeFunction = {
                    val target = it.target
                    setState {
                        checkboxChecked = (target as HTMLInputElement).checked
                    }
                }
            }
        }

        if(state.checkboxChecked) {
            children()
        }
    }
}

fun RBuilder.checkboxContainer(defaultChecked: Boolean, children: RBuilder.() -> Unit) = child(CheckboxContainer::class) {
    attrs.defaultChecked = defaultChecked
    children()
}