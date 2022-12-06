package util

object CategoryUtility {

    //NOTE: JvmStatic annotation means that the categories variable is static (i.e. we can reference it through the class
    //      name; we don't have to create an object of CategoryUtility to use it.
    @JvmStatic
    val races = setOf ("Human","Halfling","Elf","Half-Elf","Goliath","Dwarf","Gnome")  //add more categories in here.

    @JvmStatic
    fun isValidRace(categoryToCheck: String?): Boolean {
        for (category in races) {
            if (category.equals(categoryToCheck, ignoreCase = true)) {
                return true
            }
        }
        return false
    }

    @JvmStatic
    val classes = setOf ("Rogue", "Paladin", "Warlock", "Barbarian", "Wizard", "Cleric", "Fighter","Bard")  //add more categories in here.

    @JvmStatic
    fun isValidClass(categoryToCheck: String?): Boolean {
        for (category in classes) {
            if (category.equals(categoryToCheck, ignoreCase = true)) {
                return true
            }
        }
        return false
    }


}