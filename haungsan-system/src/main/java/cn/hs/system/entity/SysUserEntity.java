package cn.hs.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统_用户
 *
 * @author huangsan
 * @email 1173234554@qq.com
 * @date 2020-05-23 16:26:24
 */
@TableName("sys_user")
@Data
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Integer userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String userPassword;
    /**
     * 姓名
     */
    private String realName;
    /**
     * 状态
     */
    private String userStatus;
    /**
     * 描述
     */
    private String userDesc;
    /**
     * 电话
     */
    private String userTelephone;
    /**
     * 手机号
     */
    private String userMobile;
    /**
     * 邮箱
     */
    private String userEmail;
    /**
     * 备注
     */
    private String userRemark;
    /**
     * 末次密码更新时间
     */
    private Date passwordResetTime;
    /**
     * 创建人
     */
    private Integer createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private Integer updateUser;
    /**
     * 更新时间
     */
    private Date updateTime;

}
