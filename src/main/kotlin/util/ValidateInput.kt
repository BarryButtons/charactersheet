package util

import utils.ScannerInput.readNextInt
import java.util.*

object ValidateInput {

    @JvmStatic
    fun readValidRace(prompt: String?): String {
        print(prompt)
        var input = Scanner(System.`in`).nextLine()
        do {
            if (CategoryUtility.isValidRace(input))
                return input
            else {
                print("Invalid Race $input.  Please try again: ")
                input = Scanner(System.`in`).nextLine()
            }
        } while (true)
    }

    @JvmStatic
    fun readValidClass(prompt: String?): String {
        print(prompt)
        var input = Scanner(System.`in`).nextLine()
        do {
            if (CategoryUtility.isValidClass(input))
                return input
            else {
                print("Invalid Class $input.  Please try again: ")
                input = Scanner(System.`in`).nextLine()
            }
        } while (true)
    }

    @JvmStatic
    fun readValidNumber(prompt: String?): Int {
        var input =  readNextInt(prompt)
        do {
            if (Utilities.validRange(input, 1, 20))//needs to be changed to 20
                return input
            else {
                print("Invalid entry $input.")
                input = readNextInt(prompt)
            }
        } while (true)
    }

}