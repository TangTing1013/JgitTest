package com.tt.mybatis2.dao;

import com.tt.mybatis2.impl.UserDaoImpl;
import com.tt.mybatis2.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: TangTing
 * @date: 4.6.20 5:35 PM
 * @description: ${DESCRIPTION}
 * @version: v1.0
 */
public class UserDaoTest {
    public UserDao userDao;
    public SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {
        String resource="mybatis-config.xml";
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        sqlSession=sqlSessionFactory.openSession();
        this.userDao=new UserDaoImpl(sqlSession);
    }

    @Test
    public void queryUserById() throws Exception {
        System.out.println(this.userDao.queryUserById("1"));
    }


    @Test
    public void queryUserAll() throws Exception {
        List<User> userList=this.userDao.queryUserAll();
        for(User user:userList){
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() throws Exception {
        User adduser=new User();
        adduser.setAge(26);
        adduser.setBirthday(new Date("1993/01/15"));
        adduser.setName("吴倩");
        adduser.setPassword("123456");
        adduser.setSex(1);
        adduser.setUserName("evan");
        adduser.setId("1");
        this.userDao.insertUser(adduser);
        this.sqlSession.commit();
    }

    @Test
    public void updateUser() throws Exception {
        User upuser=new User();
        upuser.setAge(25);
        upuser.setBirthday(new Date("1994/01/15"));
        upuser.setName("姚锐");
        upuser.setPassword("123456");
        upuser.setSex(1);
        upuser.setUserName("evanrui");
        upuser.setId("1");
        this.userDao.updateUser(upuser);
        this.sqlSession.commit();
    }


    @Test
    public void deleteUser() throws Exception {
        this.userDao.deleteUser("2");
        this.sqlSession.commit();
    }

}