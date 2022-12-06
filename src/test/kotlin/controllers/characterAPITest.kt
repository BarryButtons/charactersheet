package controllers

import models.Sheet
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import persistence.XMLSerializer
import java.io.File
import kotlin.test.assertEquals
class characterAPITest {

    private var Grog: Sheet? = null
    private var Anees: Sheet? = null
    private var Davos: Sheet? = null
    private var Ben: Sheet? =null
    private var createdCharacters: characterAPI? = characterAPI(XMLSerializer(File("character.xml")))
    private var noCharacters: characterAPI? = characterAPI(XMLSerializer(File("notes.xml")))

    @BeforeEach
    fun setup(){
        Grog = Sheet( "Grog Strongjaw","Goliath","Barbarian",20,20,14,18,6,10,10)
        Anees = Sheet("Anees","Halfling", "Rogue",10,8,18,14,13,10,13)
        Davos = Sheet("Davos Mortaine","Human","Bard", 14,8,14,15,12,14,18)
        Ben = Sheet("Ben","Human","Wizard", 2,8,10,12,18,13,13 )

        //add 4 character to character api
        createdCharacters!!.add(Grog!!)
        createdCharacters!!.add(Anees!!)
        createdCharacters!!.add(Davos!!)
        createdCharacters!!.add(Ben!!)

    }

    @AfterEach
    fun tearDown(){
        Grog = null
        Anees = null
        Davos = null
        Ben = null
    }

    @Nested
    inner class AddCharacter{
        @Test
        fun `adding a character to a populated list adds to ArrayList`(){
          val newCharacter = Sheet("Alfonse","Human", "Bard", 5,8,14,12,12,12,18)
            assertEquals(4, createdCharacters!!.numberOfCharacters())
            assertTrue(createdCharacters!!.add(newCharacter))
            assertEquals(5,createdCharacters!!.numberOfCharacters())
            assertEquals(newCharacter, createdCharacters!!.findCharacter(createdCharacters!!.numberOfCharacters()-1))
        }

        @Test
        fun `adding a Character to an empty list adds to ArrayList`(){
            val newCharacter = Sheet("Alfonse","Human", "Bard", 5,8,14,12,12,12,18)
            assertEquals(0,noCharacters!!.numberOfCharacters())
            assertTrue(noCharacters!!.add(newCharacter))
            assertEquals(1,noCharacters!!.numberOfCharacters())
            assertEquals(newCharacter, noCharacters!!.findCharacter(noCharacters!!.numberOfCharacters() -1 ))
        }
    }
}

