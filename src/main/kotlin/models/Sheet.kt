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