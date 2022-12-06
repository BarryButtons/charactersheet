package controllers

import models.Sheet
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import java.io.File
import kotlin.test.assertEquals
class characterAPITest {

    private var Grog: Sheet? = null
    private var Anees: Sheet? = null
    private var Davos: Sheet? = null
    private var Ben: Sheet? =null

    @BeforeEach
    fun setup(){
        Grog = Sheet( "Grog Strongjaw","Goliath","Barbarian",20,20,14,18,6,10,10)
        Anees = Sheet("Anees","Halfling", )
    }
}