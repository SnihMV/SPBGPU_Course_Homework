package ru.devj120.lab_2_1_PhoneBook;

import java.util.Objects;

public class PhoneNumber {
    private final String areaCode;
    private final String localNum;
    private String strRepresent;

    public PhoneNumber(String areaCode, String localNum) {
        checkValue(areaCode, "Area Code");
        checkValue(localNum, "Local Number");
        this.areaCode = areaCode;
        this.localNum = localNum;
    }

    private void checkValue(String value, String name) {
        if (value == null) throw new NullPointerException("'" + name + "' is null");
        if (value.isEmpty()) throw new IllegalArgumentException("'" + name + "' is empty");
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i)))
                throw new IllegalArgumentException("'" + name + "' contains illegal character");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        PhoneNumber that = (PhoneNumber) obj;
        return areaCode.equals(that.areaCode) && localNum.equals(that.localNum);
    }

    public int hashCode() {
        return Objects.hash(areaCode,localNum);
    }

    @Override
    public String toString() {
        if (strRepresent == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("(").append(areaCode).append(")");
            int counter = 2 + localNum.length() % 2;
            if (counter < localNum.length()) {
                sb.append(localNum, 0, counter);
                while (counter <= (localNum.length() - 2)) {
                    sb.append("-").append(localNum, counter, counter + 2);
                    counter += 2;
                }
            } else
                sb.append(localNum);
            strRepresent = sb.toString();
        }
        return strRepresent;
    }
}
