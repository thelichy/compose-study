package classes_and_collections

data class Event(
    var title: String,
    var description: String?,
    var dayPart: String,
    var duration: Int
)


fun main() {
    val event = Event(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        "Evening",
        15
    )

    println(event)
}
