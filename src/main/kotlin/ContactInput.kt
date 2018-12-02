import kotlinx.html.InputType
import kotlinx.html.classes
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h3
import react.dom.section

class ContactInput: RComponent<RProps, RState>() {

    override fun componentDidMount() {
        println("Contacts appeared")
    }

    override fun componentWillUnmount() {
        println("Contacts went away")
    }

    override fun RBuilder.render() {
        section {
            h3 {
                +"Contact"
            }
            formField(label = "First Name", placeHolder = "Enter first name", inputType = InputType.text)
            formField(label = "Last Name", placeHolder = "Enter last name", inputType = InputType.text)
            formField(label = "Company Name", placeHolder = "Enter company name", inputType = InputType.text)
            formField(label = "Email", placeHolder = "Enter email", inputType = InputType.email)
            formField(label = "Home Phone", placeHolder = "Enter home phone", inputType = InputType.tel)
            formField(label = "Mobile Phone", placeHolder = "Enter mobile phone", inputType = InputType.tel)
            formField(label = "Business Phone", placeHolder = "Enter business phone", inputType = InputType.tel)
        }
    }
}

fun RBuilder.contactInput() = child(ContactInput::class) {}