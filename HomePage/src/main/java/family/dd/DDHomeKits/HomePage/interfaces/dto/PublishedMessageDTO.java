package family.dd.DDHomeKits.HomePage.interfaces.dto;

public class PublishedMessageDTO {
    public PublishedMessageDTO(String icon, String title, String body) {
        this.title = title;
        this.body = body;
        this.icon = icon;
    }

    private String title;
    private String body;
    private String icon;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
