package cn.edu.ncu.carlos.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2019/1/12 21:53
 * @version : 1.0
 */
public class SqlSessionFactoryUtil {
    private static final Class<SqlSessionFactoryUtil> LOCK = SqlSessionFactoryUtil.class;

    private static SqlSessionFactory sqlSessionFactory = null;

    private SqlSessionFactoryUtil() {

    }

    private static SqlSessionFactory getInstance() {
        if (sqlSessionFactory == null) {
            synchronized (LOCK) {
                if (sqlSessionFactory == null) {
                    String resource = "mybatis-config.xml";
                    InputStream inputStream = null;
                    try {
                        inputStream = Resources.getResourceAsStream(resource);
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                        return sqlSessionFactory;
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return sqlSessionFactory;
    }

    public static SqlSession openSession() {
        if (sqlSessionFactory == null)
            sqlSessionFactory = getInstance();
        return sqlSessionFactory.openSession();
    }
}
