package cn.hs.sys.dao;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统_用户
 *
 * @author huangsan
 * @email 1173234554@qq.com
 * @date 2020-05-23 16:26:24
 */
@Entity(name = "sysUserEntity")
@Data
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @Id
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
    @Ignore
    private String realName;
    /**
     * 状态
     */
    private String userStatus;
    /**
     * 描述
     */
    @Ignore
    private String userDesc;
    /**
     * 电话
     */
    @Ignore
    private String userTelephone;
    /**
     * 手机号
     */
    @Ignore
    private String userMobile;
    /**
     * 邮箱
     */
    @Ignore
    private String userEmail;
    /**
     * 备注
     */
    @Ignore
    private String userRemark;
    /**
     * 末次密码更新时间
     */
    @Ignore
    private Date passwordResetTime;
    /**
     * 创建人
     */
    @Ignore
    private Integer createUser;
    /**
     * 创建时间
     */
    @Ignore
    private Date createTime;
    /**
     * 更新人
     */
    @Ignore
    private Integer updateUser;
    /**
     * 更新时间
     */
    @Ignore
    private Date updateTime;

}
