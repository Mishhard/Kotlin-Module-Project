class Note(
    val name: String,
    private val content: String
) {
    fun viewNote() {
        println("Заголовок: $name")
        println("Содержание: $content")
        println("Нажмите Enter чтобы вернуться.")
        readLine()
    }
}
