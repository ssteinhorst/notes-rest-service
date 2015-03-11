package notes;

public class Note {
    private final String content;
    private final String title;
    private String id;

    public Note(String title, String content) {
        this.content = content;
        this.title = title;
    }

    public Note(String title) {
        this(title, "No Content");
    }

    public Note() {
        this("No Title");
    }

    public String getId() { return id; }

    public String getContent() { return content; }

    public String getTitle() { return title; }

    @Override
    public String toString() {
        return String.format("Note[id= %s, title=%s, content=%s]", id, title, content);
    }
}
