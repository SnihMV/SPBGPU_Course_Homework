package ru.devj110.lab_3_1_List;

public interface Transformer<T, R> {
    R transform(T value);
}
