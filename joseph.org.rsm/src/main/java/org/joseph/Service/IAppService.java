package org.joseph.Service;

public interface IAppService<T, J> {
    void add(T createObject);
    void update(T updateObject);
    void delete(T deleteObject);
    J get(T getObject);
}
