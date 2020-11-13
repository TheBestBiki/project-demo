package com.biki.project.mapper;


import com.biki.project.dto.TestTable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestDbMapper {

    @Select("select t.user_name from s_user t where id=1")
    String  finId();

    @Select("select * from test_table")
    List<TestTable> testSameData();
}
