package za.co.duartbreedt.androidconceptsreference;

import java.util.regex.Pattern;

public class PhoneNumberFormatter {

    public static String format(String number) {
        return format(number, PhoneFormat.SIMPLE);
    }

    public static String format(String number, PhoneFormat format) {
        return format(number, PhoneFormat.SIMPLE, CountryCode.ZA);
    }

    public static String format(String number, PhoneFormat format, CountryCode countryCode) {

        // Remove white space
        number = number.replaceAll("\\s", "");

        if (number.isEmpty()) {
            throw new IllegalArgumentException("Number has to be a valid phone number.");
        }

        switch (format) {
            case SIMPLE:
                if (isNumberSimple(number)) {
                    return number;
                }

                number = convertInternationalNumberToSimpleNumber(number);

                break;
            case INTERNATIONAL:

                if (!isNumberSimple(number)) {
                    number = convertInternationalNumberToSimpleNumber(number);
                }

                number = convertSimpleNumberToInternationalNumber(number, countryCode);

                break;
        }

        return number;
    }

    private static boolean isNumberSimple(String number) {
        boolean containsWhitespace = Pattern.compile("\\s").matcher(number).find();
        return number.charAt(0) == '0' && !containsWhitespace;
    }

    private static String convertInternationalNumberToSimpleNumber(String number) {
        CountryCode countryCode = CountryCode.getCountryCode(number);

        number = number.substring(countryCode.diallingCode.length());

        return "0" + number;
    }

    private static String convertSimpleNumberToInternationalNumber(String number, CountryCode countryCode) {
        if (!isNumberSimple(number)) {
            throw new IllegalArgumentException("Number is required to be a simple number!");
        }

        return countryCode.diallingCode + number.substring(1);
    }

    enum CountryCode {
        ZA("+27"),
        AU("+61"),
        NZ("+64");

        public String diallingCode;

        CountryCode(String diallingCode) {
            this.diallingCode = diallingCode;
        }

        public static CountryCode getCountryCode(String number) {
            for (int i = 0; i < values().length; i++) {
                if(number.startsWith(values()[i].diallingCode)) {
                    return values()[i];
                }
            }

            throw new IllegalArgumentException("Number does not have a valid dialing code!");
        }
    }

    enum PhoneFormat {
        INTERNATIONAL,
        SIMPLE
    }
}
