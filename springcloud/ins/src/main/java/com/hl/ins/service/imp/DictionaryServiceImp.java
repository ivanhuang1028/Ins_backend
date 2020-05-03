package com.hl.ins.service.imp;

import com.hl.ins.mapper.BaseMapper;
import com.hl.ins.mapper.DictionaryMapper;
import com.hl.ins.module.Dictionary;
import com.hl.ins.service.DictionaryService;
import com.hl.ins.service.imp.BaseServiceImp;
import com.hl.ins.vo.dic.DicVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author ivan.huang
 */
@Slf4j
@Service("dictionaryService")
public class DictionaryServiceImp<T> extends BaseServiceImp<T> implements DictionaryService<T> {

    @Override
    public DictionaryMapper<T> getMapper() {
        return (DictionaryMapper<T>) mapper;
    }

    @Override
    @Autowired
    public void setMapper(@Qualifier("dictionaryMapper") BaseMapper<T> mapper) {
        super.setMapper(mapper);
    }


    @Override
    public List<DicVO> queryByName(String dic_name) {
        return getMapper().queryByName(dic_name);
    }

    @Override
    public List<DicVO> queryUserLabels(String user_id) {
        return getMapper().queryUserLabels(user_id);
    }
}
