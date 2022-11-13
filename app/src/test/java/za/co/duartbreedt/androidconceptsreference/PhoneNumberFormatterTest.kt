package za.co.duartbreedt.androidconceptsreference

import org.junit.Assert
import org.junit.Test

class PhoneNumberFormatterTest {

    @Test
    fun format_numberOnlySupplied_simpleNumber_succeeds() {
        val formattedNumber = PhoneNumberFormatter.format("0757463446")
        Assert.assertEquals("0757463446", formattedNumber)
    }

    @Test
    fun format_numberOnlySupplied_internationalNumber_succeeds() {
        val formattedNumber = PhoneNumberFormatter.format("+61757463446")
        Assert.assertEquals("0757463446", formattedNumber)
    }

    @Test
    fun format_numberOnlySupplied_blankNumber_fails() {
        try {
            PhoneNumberFormatter.format("    ")
        } catch (e: IllegalArgumentException) {
            Assert.assertEquals("Number has to be a valid phone number.", e.message)
        }
    }

    @Test
    fun format_numberOnlySupplied_unsupportedNumber_fails() {
        try {
            PhoneNumberFormatter.format("+57123456789")
        } catch (e: IllegalArgumentException) {
            Assert.assertEquals("Number does not have a valid dialing code!", e.message)
        }
    }

    @Test
    fun format_numberOnlySupplied_invalidNumber_fails() {
        try {
            PhoneNumberFormatter.format("123456789")
        } catch (e: IllegalArgumentException) {
            Assert.assertEquals("Number does not have a valid dialing code!", e.message)
        }
    }

}