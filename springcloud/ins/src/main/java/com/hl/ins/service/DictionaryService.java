package com.hl.ins.service;

import com.hl.ins.mapper.DictionaryMapper;
import java.util.List;

public interface DictionaryService<T> extends BaseService<T>, DictionaryMapper<T> {
    List selectByName(String dicNameSpeDateType);

//    T updateByPrimaryKeyReturnT(T t);

}
