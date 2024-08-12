package com.simple.basic.memo;

import com.simple.basic.command.MemoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper // 이게 붙은 인터페이스를 마이바티스가 인식함
public interface MemoMapper {
    public String hello();
    public ArrayList<MemoDTO> getMemoList();
    public void insertMemo(MemoDTO dto);
    public MemoDTO selectMemo(Integer mno);
    public void updateMemo(MemoDTO dto);
}
