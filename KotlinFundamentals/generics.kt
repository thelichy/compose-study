class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
) {
}

fun main() {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
    val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")

    println(question1.questionText + "\n" + question1.answer + "\n" + question1.difficulty + "\n")
    println(question2.questionText + "\n" + question2.answer + "\n" + question2.difficulty + "\n")
    println(question3.questionText + "\n" + question3.answer + "\n" + question3.difficulty + "\n")
}
