package cn.edu.ncu.carlos.util;

import cn.edu.ncu.carlos.model.Book;
import cn.edu.ncu.carlos.parse.Parse;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2019/1/12 20:48
 * @version : 1.0
 */
public class URLFecter {

    public static List<Book> URLParser(HttpClient client, HttpGet httpGet) throws IOException {
        //用来接收解析的数据
        List<Book> books = new ArrayList<Book>();
        //获取网站响应的HTML
        HttpResponse response = client.execute(httpGet);
        //获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        //如果状态码为200，则获取HTML实例内容或者json文件
        if (statusCode == 200){
            String entity = EntityUtils.toString(response.getEntity(),"utf-8");
            books = Parse.getData(entity);
            EntityUtils.consume(response.getEntity());
        } else {
            //否则，消耗掉实体
            EntityUtils.consume(response.getEntity());
        }
        return books;
    }
}
