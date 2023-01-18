public class Song {
    private String title;
    private Double duration;

    public Song(String name, Double duration) {
        this.title = name;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Hey your listening to Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
