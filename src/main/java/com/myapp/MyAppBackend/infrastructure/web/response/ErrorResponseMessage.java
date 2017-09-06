package com.myapp.MyAppBackend.infrastructure.web.response;

import static com.myapp.MyAppBackend.infrastructure.web.response.ResponseMessageType.ERROR;

/**
 * ErrorResponseMessage is a subclass of ResponseMessage that always sets the ResponseMessageType to
 * {@link ResponseMessageType#ERROR}.
 *
 * @author azuroff
 */
public class ErrorResponseMessage extends ResponseMessage {

    /**
     * Create a new ErrorResponseMessage with the given message.
     *
     * @param message the message to return to the caller
     */
    public ErrorResponseMessage(String message) {
        super(ERROR, message);
    }

    public ErrorResponseMessage(String message, String title) {
        super(ERROR, message, title, false);
    }

    public ErrorResponseMessage(String message, String title, boolean userVisible) {
        super(ERROR, message, title, userVisible);
    }
}
