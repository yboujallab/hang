package com.ma.hang.core.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author yboujallab
 * DAO Operations interface
 * @param <T>
 */
public interface IOperations<T extends Serializable> {

    /**
     * @param id
     * @return T
     */
    T findOne(final int id);

    /**
     * @return list of T
     */
    List<T> findAll();

    /**
     * @param entity
     */
    void create(final T entity);

    /**
     * @param entity
     * @return updated T
     */
    T update(final T entity);

    /**
     * @param entity
     */
    void delete(final T entity);

    /**
     * @param entityId
     */
    void deleteById(final int entityId);
    

}
