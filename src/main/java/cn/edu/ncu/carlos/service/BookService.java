package cn.edu.ncu.carlos.service;

import cn.edu.ncu.carlos.dao.BookMapper;
import cn.edu.ncu.carlos.model.Book;
import cn.edu.ncu.carlos.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2019/1/12 22:00
 * @version : 1.0
 */
public class BookService {
    private BookMapper bookMapper = null;
    private SqlSession sqlSession = null;

    public BookService() {
    }

    public int addBook(Book book) {
        int i = 0;
        try {
            sqlSession = SqlSessionFactoryUtil.openSession();
            bookMapper = sqlSession.getMapper(BookMapper.class);
            i = bookMapper.addBook(book);
            sqlSession.commit();
        }
        catch (Exception e) {
            sqlSession.rollback();
        }
        finally {
            sqlSession.close();
        }
        return i;
    }
}
