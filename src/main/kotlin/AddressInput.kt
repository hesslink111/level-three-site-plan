import kotlinx.html.InputType
import kotlinx.html.classes
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.h3
import react.dom.input
import react.dom.section

class AddressInput: RComponent<RProps, RState>() {

    override fun RBuilder.render() {
        section {
            h3 {
                +"Address"
            }


            checkboxContainer(defaultChecked = true) {
                formDropdown("Country Type", "US", listOf("US", "International", "Canada"))
            }

            checkboxContainer(defaultChecked = false) {
                formField("Enter Address", "Enter address", InputType.text)
                formField("Street Number", "Enter street number", InputType.text)
                formDropdown("Pre Direction", "", listOf("", "E", "N", "NE", "NW", "S", "SE", "SW", "W"))
                formField("Street Name", "Enter street name", InputType.text)
                formDropdown("Post Direction", "", listOf("", "E", "N", "NE", "NW", "S", "SE", "SW", "W"))
                formField("City", "Enter city", InputType.text)
                formField("Postal Code", "Enter postal code", InputType.number)
                formDropdown("State", "", listOf("") + states)
                formField("County", "Enter county", InputType.text)
            }

        }
    }
}

fun RBuilder.addressInput() = child(AddressInput::class) {}