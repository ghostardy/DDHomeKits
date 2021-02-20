package family.dd.DDHomeKits.HomePage.interfaces.dto;

import family.dd.DDHomeKits.HomePage.domain.MessagePublisher.repository.MessageBoardPO;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PublishedMessageDTO {
    public PublishedMessageDTO(String title, String content, String author, Timestamp pubDate) {
        this.title = title;
        this.content = content;
        this.author = author;
        setPubDate(pubDate);
    }
    public PublishedMessageDTO(MessageBoardPO po) {
        this(po.getTitle(), po.getContent(), po.getAuthor(), po.getPubDate());
    }

    private String title;
    private String content;
    private String author;
    private String pubDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public void setPubDate(Timestamp pubDate) {
        this.pubDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(pubDate);
    }
}
