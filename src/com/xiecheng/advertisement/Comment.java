package com.xiecheng.advertisement;

public class Comment {
    private String commentID;
    private String content;
    private String userID;

    public Comment(String commentID, String content, String userID) {
        this.commentID = commentID;
        this.content = content;
        this.userID = userID;
    }

    // Getter 和 Setter
    public String getCommentID() { return commentID; }
    public void setCommentID(String commentID) { this.commentID = commentID; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }
}
