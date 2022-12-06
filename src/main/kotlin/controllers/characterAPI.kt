package controllers

import models.Sheet
import persistence.XMLSerializer

class characterAPI(xmlSerializer: XMLSerializer) {
    private var sheets = ArrayList<Sheet>()

    fun add(sheet: Sheet): Boolean {
        return sheets.add(sheet)
    }

    fun listAllSheets(): String {
        return if (sheets.isEmpty()) {
            "No Character stored"
        } else {
            var listOfSheets = ""
            for (i in sheets.indices) {
                listOfSheets += "${i}: ${sheets[i]} \n"
            }
            listOfSheets
        }
    }

    fun updateCharacter(indexToUpdate: Int, note: Sheet?): Boolean {
        //find the note object by the index number
        val foundCharacter = findCharacter(indexToUpdate)

        //if the Character exists, use the Character details passed as parameters to update the found Character in the ArrayList.
        if ((foundCharacter != null) && (note != null)) {
            foundCharacter.characterName = note.characterName
            foundCharacter.characterRace = note.characterRace
            foundCharacter.characterClass = note.characterClass
            foundCharacter.characterLevel = note.characterLevel
            foundCharacter.strength = note.strength
            foundCharacter.dexterity = note.dexterity
            foundCharacter.constitution = note.constitution
            foundCharacter.intelligence = note.intelligence
            foundCharacter.wisdom = note.wisdom
            foundCharacter.charisma = note.charisma
            return true
        }

        //if the note was not found, return false, indicating that the update was not successful
        return false
    }

    fun deleteCharacter(indexToDelete: Int): Sheet? {
        return if (isValidListIndex(indexToDelete, sheets)) {
            sheets.removeAt(indexToDelete)
        } else null
    }

    fun numberOfCharacters(): Int = sheets.size


    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0 && index < list.size)
    }

    fun isValidIndex(index: Int) :Boolean{
        return isValidListIndex(index, sheets);
    }

    fun findCharacter(index: Int): Sheet? {
        return if (isValidListIndex(index, sheets)) {
            sheets[index]
        } else null
    }


}
