package com.hq;

import com.hq.mapper.UserMapper;
import com.hq.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void select() {
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
        Set<User> collect2 = userList.stream().filter(e -> e.getId() > 3).collect(Collectors.toSet());
        List<User> collect1 = userList.stream().map(e->{
            User a = new User();
            String username = e.getUsername();
            a.setUsername(username);
            return a;
//            BeanUtils.copyProperties();
        }).collect(Collectors.toList());
//                .forEach(e->System.out.println(e));
    }
    @Test
    void  insertUser(){
        User user = new User();
        user.setUsername("hqqs");
        user.setPassword("123");
        user.setEmail("1448856457@qq.com");
        user.setAddress("南江");
        user.setPerm("user:add");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
    @Test
    void  updateUser(){
        User  user = new User();
        user.setId(1357208091360591876L);
        user.setAddress("地球1233");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }
    //测试乐观锁成功
    @Test
    public void testOptimsiticLockersuccess(){
        User  user =  userMapper.selectById(1L);
        user.setAddress("22222ss");
        user.setEmail("11222");
        int user1 = userMapper.updateById(user);
    }

    //测试乐观锁失败
    @Test
    public void testOptimsiticLockerfail(){
        List<User> userList = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        userList.stream().forEach(e-> System.out.println(e));

    }
}
