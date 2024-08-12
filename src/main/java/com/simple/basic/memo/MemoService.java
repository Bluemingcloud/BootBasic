package com.simple.basic.memo;

import com.simple.basic.command.MemoDTO;

import java.util.ArrayList;

public interface MemoService {
    public ArrayList<MemoDTO> getMemoList();
    public void writeMemo(MemoDTO dto);
    public MemoDTO getMemo(Integer mno);
    public void editMemo(MemoDTO dto);
}
