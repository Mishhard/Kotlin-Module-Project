import java.util.Scanner

class Archive(val name: String, private val scanner: Scanner) {
    private val notes = mutableListOf<Note>()

    fun showNoteMenu() {
        while (true) {
            println("Заметки в архиве '$name':")
            println("0. Создать заметку")
            for (i in notes.indices) {
                println("${i + 1}. ${notes[i].name}")
            }
            println("${notes.size + 1}. Назад")
            val noteNumber :Int? = scanner.nextLine().toIntOrNull()
            when {
                noteNumber == null -> println("Введите число.")
                noteNumber == 0 -> createNote()
                noteNumber in 1..notes.size -> notes[noteNumber - 1].viewNote()
                noteNumber == notes.size + 1 -> {
                    println("Возвращаемся\n")
                    return
                }
                else -> println("Некорректный ввод.")
            }
        }
    }

    private fun createNote() {
        println("Для возврата в предыдущее меню введите \"..\"")
        println("Введите название заметки:")
        val name :String? = scanner.nextLine()
        if (name == null ||  name.equals("")) {
            println("Название заметки не может быть пустым.")
            return
        }
        else if (name.equals("..")) {
            println("Возвращаемся\n")
            return
        }
        println("Введите текст заметки:")
        val content :String? = scanner.nextLine()
        if (content  == null ||  content.equals("")) {
            println("Текст не может быть пустым.")
            return
        }
        else if (content.equals("..")) {
            println("Возвращаемся\n")
            return
        }

        notes.add(Note(name, content))
        println("Заметка '$name' создана.")
    }
}
