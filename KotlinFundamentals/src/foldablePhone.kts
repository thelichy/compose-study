
open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

class FoldablePhone(var isFolded: Boolean = false) :
    Phone() {
    override fun switchOn() {
        if (!isFolded) {
            super.switchOn()
        }
    }

    fun foldPhone() {
        isFolded = true
    }
    fun unfoldPhone() {
        isFolded = false
    }
}


fun main() {
    val fphone = FoldablePhone(isFolded = true)

    fphone.checkPhoneScreenLight()

    fphone.switchOn()
    fphone.checkPhoneScreenLight()

    fphone.unfoldPhone()
    fphone.switchOn()
    fphone.checkPhoneScreenLight()
}
