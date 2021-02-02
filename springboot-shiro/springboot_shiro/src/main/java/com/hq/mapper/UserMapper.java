package com.hq.mapper;


import com.hq.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository//表示这个类是持久层的 操作数据库的
public interface UserMapper {

    List<User> queryList();

    User queryById(@Param("uid") int id);

    User queryByName(@Param("name") String username);

    int addUser(User user);
}
