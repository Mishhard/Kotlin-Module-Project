import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val archiveManager = ArchiveManager(scanner)
    archiveManager.showMainMenu()
}