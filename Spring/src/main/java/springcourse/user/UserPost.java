package springcourse.user;

import java.util.Date;

public class UserPost {
    private String comment;
    private Date timestamp;

    public UserPost(String comment, Date timestamp) {
        super();
        this.comment = comment;
        this.timestamp = timestamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
