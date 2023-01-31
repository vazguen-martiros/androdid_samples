package com.dev.vazguen.unittest

import io.mockk.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CalculatorTest{
    private  val tracker:Tracker = spyk()
    private  val logger:Logger = mockk(relaxed = true)
    private val calculator:Calculator = Calculator(
        tracker,
        logger
    )
    @Before
    fun setUp(){
        every { tracker.sendMessage(any()) }just runs
        // every { logger.log(any())}just runs //Opcion 2
    }

    @Test
    fun `Square calculates the proper result`(){
        val result = calculator.square(2)
        assertTrue(4==result)
    }
    @Test
    fun `WHEN squere is called THEn logger is called`(){
        calculator.square(1234)
        verify(exactly = 1) { logger.log(any()) }
    }
    @Test
    fun `WHEN square is called THEN tracker sends a message`(){
        calculator.square(1234)
        verify(exactly = 1) { tracker.sendMessage(any()) }
    }
    @Test
    fun `WHEN square is called THEN tracker sends the right message`(){
        val number=1234
        calculator.square(number)

        val slot = slot<Message>()
        verify(atLeast = 1, atMost = 1) { tracker.sendMessage(capture(slot)) }

        val captured:Message = slot.captured
        assertTrue(captured.texto=="Calculating square of $number...")
        assertTrue(captured.code== Message.Code.CODE_1)
    }
}