
class song(val title: String, val artist: String, val yearPublished: Int) {
    var isPopular: Boolean = false

    constructor(title: String, artist: String, yearPublished: Int, playCount: Long) : this(title, artist, yearPublished) {
        isPopular = playCount > 1000
    }

    fun printSong() {
        println("$title, performed by $artist, was released in $yearPublished. It is popular: $isPopular")
    }
}

/*class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
){
    val isPopular: Boolean
        get() = playCount >= 1000

    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }
}*/

fun main() {
    val prettyFly = song("Pretty Fly for a White Guy", "The Offspring", 1998, 20000)
    val miseryBusiness = song("Misery Business", "Paramore", 2007, 999)

    prettyFly.printSong()
    miseryBusiness.printSong()
}
