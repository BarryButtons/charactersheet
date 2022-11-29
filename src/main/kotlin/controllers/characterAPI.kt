package controllers

import models.Sheet

class characterAPI {
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

    fun numberOfCharacters(): Int = sheets.size

}
