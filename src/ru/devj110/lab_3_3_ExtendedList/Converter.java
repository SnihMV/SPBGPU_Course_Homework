package ru.devj110.lab_3_3_ExtendedList;

public interface Converter<E,R> {
    R convert(E value);
}
