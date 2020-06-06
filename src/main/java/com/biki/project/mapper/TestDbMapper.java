package com.biki.project.mapper;


import org.apache.ibatis.annotations.Select;

public interface TestDbMapper {

    @Select("select t.user_name from s_user t where id=1")
    String  finId();

}
