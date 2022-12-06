import controllers.characterAPI
import models.Sheet
import mu.KotlinLogging
import persistence.XMLSerializer
import util.CategoryUtility
import util.ValidateInput.readValidClass
import util.ValidateInput.readValidNumber
import utils.ScannerInput
import utils.ScannerInput.readNextInt
import utils.ScannerInput.readNextLine
import util.ValidateInput.readValidRace
import java.io.File
import java.lang.System.exit


private val logger = KotlinLogging.logger {}
private val characterAPI= characterAPI(XMLSerializer(File("character.xml")))

fun main(args: Array<String>) {
    runMenu()
}

fun mainMenu() : Int {

    return ScannerInput.readNextInt(""" 
         > -------------------------------------------------------------------------------------------------
         > \                       Character Creator (No of Characters here)                               /
         > /                                                                                               \
         > -------------------------------------------------------------------------------------------------
         > \                                          MENU                                                 /
         > /      1)Create Character   2)View Characters   3)Update a Character   4)Delete a Character     \
         > \                                                                                               / 
         > --------------------------------------------------------------------------------------------------
         > |   0) Exit                                                                                      |
         > --------------------------------------------------------------------------------------------------
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
    //logger.info { "Create a Characters"}
    val characterName = readNextLine("Character Name:")
    val characterRace = readValidRace("Choose Character Race from ${CategoryUtility.races}:")
    val characterClass = readValidClass("Choose Character Class ${CategoryUtility.classes}:")
    val characterLevel = readValidNumber("Enter Character Level 1-20:")
    val strength = readValidNumber("Enter Character Strength 1-20:")
    val dexterity = readValidNumber("Enter Character Dexterity 1-20:")
    val constitution = readValidNumber("Enter Character Constitution 1-20:")
    val intelligence =  readValidNumber("Enter Character Intelligence 1-20:")
    val wisdom = readValidNumber("Enter Character Wisdom 1-20:")
    val charisma = readValidNumber("Enter Character Charisma 1-20:")

    val isAdded = characterAPI.add(Sheet(characterName, characterRace, characterClass, characterLevel, strength, dexterity, constitution, intelligence, wisdom, charisma))

    if (isAdded) {
        println("Added Successfully")
    } else {
        println("Add Failed")
    }
}


fun listCharacters(){
    //logger.info { "View Characters" }
    if (characterAPI.numberOfCharacters() > 0) {
        val option = readNextInt(
            """
                  > --------------------------------------------------------
                  > |   1) View ALL Characters  2) Display Character Sheet |
                  > --------------------------------------------------------
         > ==>> """.trimMargin(">"))

        when (option) {
            1 -> listAllSheets();
            //2 -> getCharacter();
            //3 -> ;
            else -> println("Invalid option entered: $option");
        }
    } else {
        println("Option Invalid - NO Characters");
    }
}

fun characterFind(){
    //logger.info { "View Characters" }
    if (characterAPI.numberOfCharacters() > 0) {
        val option = readNextInt(
            """
                  > --------------------------------------------------------
                  > |   1) View ALL Characters
                  > --------------------------------------------------------
         > ==>> """.trimMargin(">"))

        when (option) {
            1 -> listAllSheets();
            else -> println("Invalid option entered: $option");
        }
    } else {
        println("Option Invalid - NO Characters");
    }
}

/*fun getCharacter(){
 val printSheet = characterFind()
    if (printSheet != null)
        println(printSheet.getCharacterSheet)
}*/




fun updateCharacter(){
    //logger.info { "Update a Character" }
    characterFind()
    if (characterAPI.numberOfCharacters() > 0) {
        //only ask the user to choose the character if they exist
        val indexToUpdate = readNextInt("Enter the index of the Character to update: ")
        if (characterAPI.isValidIndex(indexToUpdate)) {
            val characterName = readNextLine("Character Name:")
            val characterRace = readValidRace("Choose Character Race from ${CategoryUtility.races}:")
            val characterClass = readValidClass("Choose Character Class ${CategoryUtility.classes}:")
            val characterLevel = readValidNumber("Enter Character Level 1-20:")
            val strength = readValidNumber("Enter Character Strength 1-20:")
            val dexterity = readValidNumber("Enter Character Dexterity 1-20:")
            val constitution = readValidNumber("Enter Character Constitution 1-20:")
            val intelligence =  readValidNumber("Enter Character Intelligence 1-20:")
            val wisdom = readValidNumber("Enter Character Wisdom 1-20:")
            val charisma = readValidNumber("Enter Character Charisma 1-20:")

            //pass the index of the note and the new note details to NoteAPI for updating and check for success.
            if (characterAPI.updateCharacter(indexToUpdate,Sheet(characterName, characterRace, characterClass, characterLevel, strength, dexterity, constitution, intelligence, wisdom, charisma))){
                println("Update Successful")
            } else {
                println("Update Failed")
            }
        } else {
            println("There are no Character for this index number")
        }
    }
}

fun deleteCharacter(){
    //logger.info { "Delete a Character" }

    characterFind()
    if (characterAPI.numberOfCharacters() > 0) {
        //only ask the user to choose the Character to delete if they exist
        val indexToDelete = readNextInt("Enter the index of the character to delete: ")
        //pass the index of the note to NoteAPI for deleting and check for success.
        val characterToDelete = characterAPI.deleteCharacter(indexToDelete)
        if (characterToDelete != null) {
            println("Delete Successful! Deleted ${characterToDelete.characterName}")
        } else {
            println("Delete NOT Successful")
        }
    }
}

fun exitApp(){
    logger.info { "exitApp() function invoked" }
    exit(0)
}


fun listAllSheets() {
    println(characterAPI.listAllSheets())
}




