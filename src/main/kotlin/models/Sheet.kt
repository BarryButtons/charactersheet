package models

data class Sheet (val characterName: String,
                  val characterRace: String,
                  val characterClass: String,
                  val characterLevel: Int,
                  val strength: Int,
                  val dexterity: Int,
                  val constitution: Int,
                  val intelligence: Int,
                  val wisdom: Int,
                  val charisma: Int
)