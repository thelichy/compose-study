package classes_and_collections


enum class DayPart {
    MORNING, AFTERNOON, EVENING
}

data class Event(
    var title: String,
    var description: String? = null,
    var dayPart: DayPart,
    var duration: Int
)


val Event.durationOfEvent: String
    get() = if (duration < 60) {
        "short"
    } else {
        "long"
    }

fun main() {
    val events = mutableListOf<Event>()

    events.add(
        Event(
            title = "Wake up",
            description = "Time to get up",
            dayPart = DayPart.MORNING,
            duration = 0
        )
    )
    events.add(
        Event(
            title = "Eat breakfast",
            dayPart = DayPart.MORNING,
            duration = 15
        )
    )

    println(events[0].durationOfEvent)
}
