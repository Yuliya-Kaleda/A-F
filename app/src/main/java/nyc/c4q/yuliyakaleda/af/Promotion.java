package nyc.c4q.yuliyakaleda.af;

import java.io.Serializable;
import java.util.List;

public class Promotion implements Serializable {
    private String title;
    private String image;
    private String description;
    private String footer;
    private List<Button> buttons;

    public Promotion(String title, String image, String description, String footer, List<Button> buttons) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.footer = footer;
        this.buttons = buttons;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Button> getButtons() {
        return buttons;
    }

    public void setButtons(List<Button> buttons) {
        this.buttons = buttons;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }
}
