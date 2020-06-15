package cn.hs.sys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @description:
 * @Author: huangsan
 * @Date: 2020/5/23 5:21 下午
 */
public interface UserPermissionRepository extends JpaRepository<SysUserEntity, Integer> {

    @Query(value = "SELECT\n" +
            "\tsf.function_code \n" +
            "FROM\n" +
            "\tsys_user su\n" +
            "\tLEFT JOIN sys_group_user sgu ON su.user_id = sgu.user_id\n" +
            "\tLEFT JOIN sys_group sg ON sg.group_id = sgu.group_id\n" +
            "\tLEFT JOIN sys_role_group srg ON srg.group_id = sg.group_id\n" +
            "\tLEFT JOIN sys_role sr ON sr.role_id = srg.role_id\n" +
            "\tLEFT JOIN sys_role_function srf ON srf.role_id = sr.role_id\n" +
            "\tLEFT JOIN sys_function sf ON sf.function_id = srf.function_id \n" +
            "WHERE\n" +
            "\tsu.user_id = ?1", nativeQuery = true)
    List<String> listPermissionById(Integer id);

    @Query(value = "SELECT * FROM sys_user WHERE user_name = ?1", nativeQuery = true)
    SysUserEntity findUserIdByName(String username);
}
