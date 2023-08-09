package classes_and_collections


enum class DayPart {
    MORNING, AFTERNOON, EVENING
}

data class Event(
    var title: String,
    var description: String?,
    var dayPart: DayPart,
    var duration: Int
)


fun main() {
    val event = Event(
        "Study Kotlin",
        "Commit to studying Kotlin at least 15 minutes per day.",
        DayPart.EVENING,
        15
    )

    println(event)
}
