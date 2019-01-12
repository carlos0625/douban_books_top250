package cn.edu.ncu.carlos;

import cn.edu.ncu.carlos.model.Book;
import cn.edu.ncu.carlos.service.BookService;
import cn.edu.ncu.carlos.util.URLFecter;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 启动程序
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2019/1/12 20:49
 * @version : 1.0
 */
public class App {

    private static Logger logger = Logger.getLogger(App.class);

    private BookService bookService = new BookService();

    public static void main(String[] args) throws IOException {
        //存储所有250条记录
        List<Book> allBooks = new ArrayList<Book>();

        //存储爬取每页的结果
        List<Book> books = null;

        //初始化一个HTTPClient
        HttpClient client = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet();

        //设置header 避免403forbidden
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");

        //将每次爬取的结果存入总数中
        for (int i = 0; i < 10; i++) {
            httpGet.setURI(URI.create("https://book.douban.com/top250?start=" + (i * 25)));
            //抓取数据
            books = URLFecter.URLParser(client,httpGet);
            allBooks.addAll(books);
        }

        for (Book book : allBooks){
            logger.debug(book.toString());
//            //添加进数据库
//            bookService.addBook(book);
        }

        logger.debug("爬取了" + allBooks.size() + "本");
    }
}
