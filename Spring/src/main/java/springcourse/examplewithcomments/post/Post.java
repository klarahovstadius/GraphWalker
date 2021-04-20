package springcourse.examplewithcomments.post;

import java.util.Date;

public class Post {

    private Date date;
    private String postBody;
    private Integer userId;
    private Integer postId;

    public Post(Integer userId, Integer postID, Date date, String postBody) {
        this.date = date;
        this.postBody = postBody;
        this.userId = userId;
        this.postId = postID;
    }

    @Override
    public String toString() {
        return "{" +
                "date=" + date +
                ", postBody='" + postBody + '\'' +
                '}';
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}
