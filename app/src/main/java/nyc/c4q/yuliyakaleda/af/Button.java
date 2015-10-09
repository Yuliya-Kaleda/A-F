package nyc.c4q.yuliyakaleda.af;


public class Button {
    private String target;
    private String title;

    public Button (String target, String title) {
        this.target = target;
        this.title = title;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
