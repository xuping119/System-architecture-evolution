package com.yrlx.cmsserver;

import com.yrlx.cmsserver.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;

public class UserTest {

    @Test
    public void checkUsertest(){
        //定义读取文件名
        String resources = "config/mybatis-config.xml";
        //创建流
        Reader reader=null;
        try {
            //一般不使用这个配置文件，在springboot中
            //读取mybatis-config.xml文件到reader对象中
            reader= Resources.getResourceAsReader(resources);
            } catch (IOException e) {
                e.printStackTrace();
            }
        //初始化mybatis,创建SqlSessionFactory类的实例
        SqlSessionFactory sqlMapper=new SqlSessionFactoryBuilder().build(reader);
        //创建session实例
        SqlSession session=sqlMapper.openSession();
        //传入参数查询，返回结果
        User user=session.selectOne("checkUser","xp");
        //输出结果
        System.out.println(user.toString());
        //关闭session
        session.close();

    }
}
