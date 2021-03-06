package demo.mapper;

import demo.mode.User;
import org.apache.ibatis.annotations.Param;
public interface UserMapper {
    User findByUsername(@Param("username") String username);
    User findUserById(@Param("Id") String Id);
}
