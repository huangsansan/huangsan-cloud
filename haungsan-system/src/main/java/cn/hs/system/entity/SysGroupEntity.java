package cn.hs.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统_用户组
 *
 * @author huangsan
 * @email 1173234554@qq.com
 * @date 2020-05-23 16:26:24
 */
@TableName("sys_group")
@Data
public class SysGroupEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户组ID
     */
    @TableId(type = IdType.AUTO)
    private Integer groupId;
    /**
     * 用户组名
     */
    private String groupName;
    /**
     * 描述
     */
    private String groupDesc;
    /**
     * 备注
     */
    private String groupRemark;
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
