package com.callor.jc.repository;

import org.apache.ibatis.annotations.Select;

public interface DDL_Dao {

    // 이 문자열에 들어있는 명령문을 풀어서 써라
    @Select("${create_table}")
    public void create_table(String create_table);
}
