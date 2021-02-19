package family.dd.DDHomeKits.HomePage.domain.MessageBoard.entity;

public class Message {
    private final int MAX_TITLE_LENGTH = 128;
    private final int MAX_CONTENT_LENGTH = 256;
    private final int MAX_AUTHOR_LENGTH = 64;
    private String title;
    private String content;
    private String author;

    public Message(String title, String content, String author) {
        this.title = title.substring(0, MAX_TITLE_LENGTH);
        this.content = content.substring(0, MAX_CONTENT_LENGTH);
        this.author = author.substring(0, MAX_AUTHOR_LENGTH);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title.substring(0, MAX_TITLE_LENGTH);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content.substring(0, MAX_CONTENT_LENGTH);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author.substring(0, MAX_AUTHOR_LENGTH);
    }
}
