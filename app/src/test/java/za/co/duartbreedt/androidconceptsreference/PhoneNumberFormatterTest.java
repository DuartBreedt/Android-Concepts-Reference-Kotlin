package za.co.duartbreedt.androidconceptsreference;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class PhoneNumberFormatterTest {

    @Test
    public void format_numberOnlySupplied_simpleNumber_succeeds() {
        String formattedNumber = PhoneNumberFormatter.format("0757463446");

        assertEquals("0757463446", formattedNumber);
    }

    @Test
    public void format_numberOnlySupplied_internationalNumber_succeeds() {
        String formattedNumber = PhoneNumberFormatter.format("+61757463446");

        assertEquals("0757463446", formattedNumber);
    }

    @Test
    public void format_numberOnlySupplied_blankNumber_fails() {
        try {
            PhoneNumberFormatter.format("    ");
        } catch (IllegalArgumentException e) {
            assertEquals("Number has to be a valid phone number.", e.getMessage());
        }
    }

    @Test
    public void format_numberOnlySupplied_unsupportedNumber_fails() {
        try {
            PhoneNumberFormatter.format("+57123456789");
        } catch (IllegalArgumentException e) {
            assertEquals("Number does not have a valid dialing code!", e.getMessage());
        }
    }

    @Test
    public void format_numberOnlySupplied_invalidNumber_fails() {
        try {
            PhoneNumberFormatter.format("123456789");
        } catch (IllegalArgumentException e) {
            assertEquals("Number does not have a valid dialing code!", e.getMessage());
        }
    }
}