package cn.hs.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统_功能
 *
 * @author huangsan
 * @email 1173234554@qq.com
 * @date 2020-05-23 16:26:24
 */
@TableName("sys_function")
@Data
public class SysFunctionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 功能ID
     */
    @TableId(type = IdType.AUTO)
    private Integer functionId;
    /**
     * 功能代码
     */
    private String functionCode;
    /**
     * 功能名称
     */
    private String functionName;
    /**
     *
     */
    private String functionIcon;
    /**
     * 父级功能ID
     */
    private Integer parentId;
    /**
     * 功能描述
     */
    private String functionDesc;
    /**
     * 功能URL
     */
    private String functionUrl;
    /**
     * 功能备注
     */
    private String functionRemark;
    /**
     * 功能类型
     */
    private Integer functionType;
    /**
     *
     */
    private String target;
    /**
     *
     */
    private Integer sort;
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
