package exam.bean;

/**
 * @author tiandao
 * @date 2018/8/13 11:46
 */
public class Film {

    private int filmId;
    private String title;
    private String description;
    private int languageId;
    private String languageName;

    public Film() {
    }

    public Film(int filmId, String title, String description, int languageId) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.languageId = languageId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", languageId=" + languageId +
                ", languageName='" + languageName + '\'' +
                '}';
    }
}
