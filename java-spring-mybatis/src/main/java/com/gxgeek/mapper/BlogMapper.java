package com.gxgeek.mapper;

import com.gxgeek.Blog;

public interface BlogMapper {

//    @Select("select * from Blog where id = #{id}")
    Blog selectBlog(Integer id);
}
