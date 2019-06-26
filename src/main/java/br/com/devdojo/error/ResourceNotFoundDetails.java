package br.com.devdojo.error;

public class ResourceNotFoundDetails {

    private String title;
    private int status;
    private String detail;
    private long timeStamp;
    private String developMessage;

    private ResourceNotFoundDetails(){}



    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getDevelopMessage() {
        return developMessage;
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

        public ResourceNotFoundDetails build() {
            ResourceNotFoundDetails resourceNotFoundDetails = new ResourceNotFoundDetails();
            resourceNotFoundDetails.timeStamp = this.timeStamp;
            resourceNotFoundDetails.title = this.title;
            resourceNotFoundDetails.status = this.status;
            resourceNotFoundDetails.detail = this.detail;
            resourceNotFoundDetails.developMessage = this.developMessage;
            return resourceNotFoundDetails;
        }
    }
}
