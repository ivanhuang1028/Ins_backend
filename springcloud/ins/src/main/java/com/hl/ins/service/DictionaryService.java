package com.hl.ins.service;

import com.hl.ins.mapper.DictionaryMapper;
import com.hl.ins.vo.dic.DicVO;

import java.util.List;

public interface DictionaryService<T> extends BaseService<T>, DictionaryMapper<T> {

    List<DicVO> queryByName(String dic_name);

    List<DicVO> queryUserLabels(String user_id);
}
