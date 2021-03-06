package cn.hs.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统_角色_功能
 *
 * @author huangsan
 * @email 1173234554@qq.com
 * @date 2020-05-23 16:26:24
 */
@TableName("sys_role_function")
@Data
public class SysRoleFunctionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 关系ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 功能ID
     */
    private Integer functionId;
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
