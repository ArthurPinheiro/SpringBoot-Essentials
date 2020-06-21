package br.com.devdojo.error;

public class ValidationErrorDetails extends ErrorDetails {

    private String field;
    private String fieldMessage;

    public String getField() {
        return field;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timeStamp;
        private String developMessage;
        private String field;
        private String fieldMessage;

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

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder fieldMessage(String fieldMessage) {
            this.fieldMessage = fieldMessage;
            return this;
        }

        public ValidationErrorDetails build() {
            ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
            validationErrorDetails.setTimeStamp(timeStamp);
            validationErrorDetails.setTitle(title);
            validationErrorDetails.setStatus(status);
            validationErrorDetails.setDetail(detail);
            validationErrorDetails.setDevelopMessage(developMessage);
            validationErrorDetails.field = field;
            validationErrorDetails.fieldMessage = fieldMessage;
            return validationErrorDetails;
        }
    }
}
