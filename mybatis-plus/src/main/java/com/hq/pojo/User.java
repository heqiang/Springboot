package com.hq.pojo;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /*
    * auto 主键自增  mysql主键要设为自增 主键类型 bigint
    * input  手动输入 不然没有id值
    *
    * */
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String sex;
    private String email;
    private String  address;
    private String perm;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    private Integer version;



}
