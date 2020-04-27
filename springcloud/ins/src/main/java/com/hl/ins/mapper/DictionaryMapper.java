package com.hl.ins.mapper;

import com.hl.ins.module.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author ivan.huang
 */
@Mapper
public interface DictionaryMapper<T> extends BaseMapper<T> {
    List<Dictionary> selectByName(@Param("name") String name);

}
