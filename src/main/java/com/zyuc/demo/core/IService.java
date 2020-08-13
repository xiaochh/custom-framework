package com.zyuc.demo.core;

import com.zyuc.demo.common.ServiceException;

import java.io.Serializable;

/**
 * @Version 1.0
 * @Description Service 层 基础接口，其他Service 接口 请继承该接口
 * @Date 2020/7/2 10:30
 * @Created by ChenHao
 */
public interface IService<T> extends Serializable {

    T insert(T model) throws ServiceException;

    boolean update(T model) throws ServiceException;

    boolean delete(Integer id) throws ServiceException;

    T get(Integer id) throws ServiceException;

}
