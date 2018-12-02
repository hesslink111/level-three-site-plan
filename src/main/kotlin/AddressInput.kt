import kotlinx.html.InputType
import kotlinx.html.classes
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h3
import react.dom.section

class AddressInput: RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        section {
            attrs {
                classes = setOf("section")
            }
            h3 {
                attrs {
                    classes = setOf("title is-4")
                }
                +"Address"
            }

            formDropdown("Country Type", "US", listOf("US", "International", "Canada"))
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

fun RBuilder.addressInput() = child(AddressInput::class) {}