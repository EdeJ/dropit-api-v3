package nl.saxofoonleren.dropit.payload.request;

import javax.persistence.Entity;

public class ReviewRequest {

    private long commentId;
    private String message;
    private long demoId;

    public long getCommentId() {
        return commentId;
    }

//    public void setCommentId(long commentId) {
//        this.commentId = commentId;
//    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getDemoId() {
        return demoId;
    }

    public void setDemoId(long demoId) {
        this.demoId = demoId;
    }
}
