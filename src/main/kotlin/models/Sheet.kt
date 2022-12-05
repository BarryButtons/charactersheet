package models

data class Sheet (
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
)

//is character dead


/*fun getCharacterSheet(): String {
   """
    __________________________________________________________________________
                                 ${characterName}                             |
    |________________________________________________________________________|
    |            Class:${characterClass}            Race:${characterRace}       Level:${characterLevel}            |
    |________________________________________________________________________|
    |                              Attributes                                |
    |     STR:${strength}     DEX:${dexterity}     CON:${constitution}     INT:${intelligence}     WIS:${wisdom}      CHAR:${charisma}     |
    |________________________________________________________________________|
"""
}*/