package com.jumia.phonevalidation.ui.model.response;

public enum ErrorMessages {

    NO_DATA_FOUND("No Data Match Your Search"),
    BAD_REQUEST("You Made A Bad Request");
    

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
