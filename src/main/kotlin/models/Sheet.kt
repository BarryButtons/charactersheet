package models

class Sheet (
    var characterName: String,
    var characterRace: String,
    var characterClass: String,
    var characterLevel: Int,
    var strength: Int,
    var dexterity: Int,
    var constitution: Int,
    var intelligence: Int,
    var wisdom: Int,
    var charisma: Int
) {
        fun getCharacterSheet()=
           """
            >__________________________________________________________________________
            >                            $characterName                             |
            >|________________________________________________________________________|
            >|            Class:${characterClass}            Race:${characterRace}       Level:${characterLevel}            |
            >|________________________________________________________________________|
            >|                              Attributes                                |
            >|     STR:${strength}     DEX:${dexterity}     CON:${constitution}     INT:${intelligence}     WIS:${wisdom}      CHAR:${charisma}     |
            >|________________________________________________________________________|
          ===>""".trimMargin(">")

    override fun toString(): String {
        return "Sheet(characterName='$characterName'," +
                "characterRace='$characterRace' " +
                "characterClass='$characterClass'" +
                "characterLevel=$characterLevel " +
                "strength=$strength " +
                "dexterity=$dexterity " +
                "constitution='$constitution' " +
                "intelligence='$intelligence " +
                "wisdom='$wisdom " +
                "charisma='$charisma')"
    }
    }
