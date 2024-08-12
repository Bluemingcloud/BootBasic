package com.simple.basic.memo;

import com.simple.basic.command.MemoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("memoService")
public class MemoServiceImpl implements MemoService {

    @Autowired
    MemoMapper memoMapper; // Mapper 구현체를 넣어줌

    @Override
    public ArrayList<MemoDTO> getMemoList() {
        return memoMapper.getMemoList();
    }

    @Override
    public void writeMemo(MemoDTO dto) {
        memoMapper.insertMemo(dto);
    }

    @Override
    public MemoDTO getMemo(Integer mno) {
        return memoMapper.selectMemo(mno);
    }

    @Override
    public void editMemo(MemoDTO dto) {
        memoMapper.updateMemo(dto);
    }
}
