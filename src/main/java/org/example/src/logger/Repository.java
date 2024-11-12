package org.example.src.logger;

public interface Repository<T> {
    void save(T text);
}
