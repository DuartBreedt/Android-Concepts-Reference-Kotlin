package za.co.duartbreedt.androidconceptsreference

import java.util.regex.Pattern

object PhoneNumberFormatter {

    fun format(number: String, format: PhoneFormat? = PhoneFormat.SIMPLE): String {
        return format(number, PhoneFormat.SIMPLE, CountryCode.ZA)
    }

    fun format(number: String, format: PhoneFormat?, countryCode: CountryCode): String {

        // Remove white space
        val formattedNumber = number.replace("\\s".toRegex(), "")

        // Validation
        require(formattedNumber.isNotEmpty()) { "Number has to be a valid phone number." }

        return when (format) {
            PhoneFormat.SIMPLE -> {
                if (isNumberSimple(number)) number
                else convertInternationalNumberToSimpleNumber(number)
            }
            PhoneFormat.INTERNATIONAL -> {
                if (!isNumberSimple(number)) number
                else convertSimpleNumberToInternationalNumber(number, countryCode)
            }
            else -> number
        }
    }

    private fun isNumberSimple(number: String): Boolean {
        val containsWhitespace = Pattern.compile("\\s").matcher(number).find()
        return number[0] == '0' && !containsWhitespace
    }

    private fun convertInternationalNumberToSimpleNumber(number: String): String {
        val countryCode = CountryCode.getCountryCode(number)
        return "0${number.substring(countryCode.diallingCode.length)}"
    }

    private fun convertSimpleNumberToInternationalNumber(
        number: String,
        countryCode: CountryCode
    ): String {
        require(isNumberSimple(number)) { "Number is required to be a simple number!" }
        return countryCode.diallingCode + number.substring(1)
    }

    enum class CountryCode(var diallingCode: String) {
        ZA("+27"), AU("+61"), NZ("+64");

        companion object {
            fun getCountryCode(number: String): CountryCode {
                for (i in values().indices) {
                    if (number.startsWith(values()[i].diallingCode)) {
                        return values()[i]
                    }
                }
                throw IllegalArgumentException("Number does not have a valid dialing code!")
            }
        }
    }

    enum class PhoneFormat {
        INTERNATIONAL, SIMPLE
    }
}