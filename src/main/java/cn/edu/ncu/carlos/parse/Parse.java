package cn.edu.ncu.carlos.parse;

import cn.edu.ncu.carlos.model.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2019/1/12 20:42
 * @version : 1.0
 */
public class Parse {
    public static List<Book> getData(String html){
        List<Book> data = new ArrayList<Book>();
        Document doc = Jsoup.parse(html);
        Elements elements = doc.select("div[class=indent]").select("table");
        for (Element ele : elements) {
            String name = ele.select("div[class=pl2]").text();
            String publishInfo = ele.select("p").text();
            String[] infos = publishInfo.split("/");
            String ratingStr = ele.select("div[class=star clearfix]").select("span[class=rating_nums]").text();
            Double rating = Double.valueOf(ratingStr);
            //创建一个对象，这里可以看出，使用Model的优势，直接进行封装
            Book book = new Book();
            book.setName(name.split("\\s+")[0]);
            book.setAuthor(infos[0].trim());
            book.setPublisher(infos[infos.length-3].trim());
            book.setPublishedTime(infos[infos.length-2].trim());
            book.setRating(rating);
            //将每一个对象的值，保存到list集合中
            data.add(book);
        }
        return data;
    }
}
