package cn.edu.ncu.carlos.model;

/**
 * Description:
 *
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2019/1/12 20:41
 * @version : 1.0
 */
public class Book {
    private Integer id;
    private String name;
    private String author;
    private String publisher;
    private String publishedTime;
    private double rating;

    public Book() {
    }

    public Book(String name, String author, String publisher, String publishedTime, double rating) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publishedTime = publishedTime;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedTime='" + publishedTime + '\'' +
                ", rating=" + rating +
                '}';
    }
}
