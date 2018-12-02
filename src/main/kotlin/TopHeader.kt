import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1
import react.dom.section

class TopHeader: RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        section {
            h1 {
                +"Top Header"
            }
        }
    }
}

fun RBuilder.topHeader() = child(TopHeader::class) {}