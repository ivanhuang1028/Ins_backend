package com.hl.ins.service;

import com.hl.ins.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BaseService<T> extends BaseMapper<T> {

     Integer deleteByPrimaryKeys(Object... keys) throws Exception;  //通过多个id删除对象

}
