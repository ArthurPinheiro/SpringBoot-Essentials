package br.com.devdojo.error;

public class ErrorDetails {

    private String title;
    private int status;
    private String detail;
    private long timeStamp;
    private String developMessage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getDevelopMessage() {
        return developMessage;
    }

    public void setDevelopMessage(String developMessage) {
        this.developMessage = developMessage;
    }


    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timeStamp;
        private String developMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timeStamp(long timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Builder developMessage(String developMessage) {
            this.developMessage = developMessage;
            return this;
        }

        public ErrorDetails build() {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setTitle(title);
            errorDetails.setStatus(status);
            errorDetails.setDetail(detail);
            errorDetails.setTimeStamp(timeStamp);
            errorDetails.setDevelopMessage(developMessage);
            return errorDetails;
        }
    }
}
