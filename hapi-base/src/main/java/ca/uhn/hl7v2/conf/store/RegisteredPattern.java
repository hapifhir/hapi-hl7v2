package ca.uhn.hl7v2.conf.store;

import java.util.regex.Pattern;

class RegisteredPattern {

    private String registration;
    private Pattern regex;

    public RegisteredPattern(String registration, String r) {
        this.registration = registration;
        regex = Pattern.compile(r);
    }

    public boolean matches(String registration, String matchValue) {
        return (registration.equals(this.registration) && regex.matcher(matchValue).matches());
    }

}