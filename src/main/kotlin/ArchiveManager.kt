import java.util.Scanner

class ArchiveManager(private val scanner: Scanner) {
    private val archives = mutableListOf<Archive>()

    fun showMainMenu() {
        while (true) {
            println("Архивы:")
            println("0. Создать архив")
            for (i in archives.indices) {
                println("${i + 1}. ${archives[i].name}")
            }
            println("${archives.size + 1}. Выход")

            val archiveNumber :Int? = scanner.nextLine().toIntOrNull()
            when {
                archiveNumber == null -> println("Введите число")
                archiveNumber == 0 -> createArchive()
                archiveNumber in 1..archives.size -> archives[archiveNumber - 1].showNoteMenu()
                archiveNumber == archives.size + 1 -> return
                else -> println("Некорректный ввод")
            }
        }
    }

    private fun createArchive() {
        while(true) {
            println("Для возврата в предыдущее меню введите \"..\"")
            println("Введите название архива:")
            val name :String? = scanner.nextLine()
            if (name == null || name.equals("")) {
                println("Название архива не может быть пустым")
            } else if (name.equals("..")) {
                println("Возвращаемся\n")
                return
            }
            else {
                archives.add(Archive(name, scanner))
                println("Архив '$name' создан")
                return
            }
        }

    }
}