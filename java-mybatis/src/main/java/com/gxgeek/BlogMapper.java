package com.gxgeek;

import org.apache.ibatis.annotations.Select;

public interface BlogMapper {

//    @Select("select * from Blog where id = #{id}")
    Blog selectBlog(Integer id);
}
