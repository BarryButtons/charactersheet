import mu.KotlinLogging
import utils.ScannerInput
import java.lang.System.exit

private val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    runMenu()
}

fun mainMenu() : Int {
    return ScannerInput.readNextInt(""" 
         > ----------------------------------
         > |        NOTE KEEPER APP         |
         > ----------------------------------
         > | NOTE MENU                      |
         > |   1) Create Character          |
         > |   2) View Characters           |
         > |   3) Update a Character        |
         > |   4) Delete a Character        |
         > ----------------------------------
         > |   0) Exit                      |
         > ----------------------------------
         > ==>> """.trimMargin(">"))
}

fun runMenu() {
    do {
        val option = mainMenu()
        when (option) {
            1  -> addCharacter()
            2  -> listCharacters()
            3  -> updateCharacter()
            4  -> deleteCharacter()
            0  -> exitApp()
            else -> println("Invalid option entered: ${option}")
        }
    } while (true)
}

fun addCharacter(){
    logger.info { "Create a Characters"}
}

fun listCharacters(){
    logger.info { "View Characters" }
}

fun updateCharacter(){
    logger.info { "Update a Character" }
}

fun deleteCharacter(){
    logger.info { "Delete a Character" }
}

fun exitApp(){
    logger.info { "exitApp() function invoked" }
    exit(0)
}
