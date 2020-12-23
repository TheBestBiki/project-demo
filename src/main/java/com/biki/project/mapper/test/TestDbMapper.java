package com.biki.project.mapper.test;


import com.biki.project.dto.test.TestTable;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface TestDbMapper {

    @Select("select t.user_name from s_user t where id=1")
    String  finId();

    @Select("select * from test_table")
    List<TestTable> testSameData();

    @Select("select t.user_name from s_user t where t.id=#{id} and t.user_name=#{name}")
    String testInsertByMap(Map<String, Object> map);
}
