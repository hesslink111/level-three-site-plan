import kotlinx.html.js.onClickFunction
import react.*
import react.dom.*
import kotlin.browser.document

fun main(args: Array<String>) {
    render(document.getElementById("react-root")) {
        app()
    }
}

class App: RComponent<RProps, App.State>() {

    interface State: RState {
        var page: String
    }

    init {
        state = object: State {
            override var page = "contact"
        }
    }

    override fun RBuilder.render() {
        topHeader()
        topHeader()
        topHeader()
        topHeader()

        button {
            +"Change page"
            attrs {
                onClickFunction = {
                    setState {
                        page = if(state.page == "contact") "address" else "contact"
                    }
                }
            }
        }

        if(state.page == "contact") {
            contactInput()
        } else {
            addressInput()
        }
    }
}

fun RBuilder.app() = child(App::class) {}