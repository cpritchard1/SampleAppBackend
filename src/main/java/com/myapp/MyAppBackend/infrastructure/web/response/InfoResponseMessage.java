package com.myapp.MyAppBackend.infrastructure.web.response;

import static com.myapp.MyAppBackend.infrastructure.web.response.ResponseMessageType.INFO;

/**
 * InfoResponseMessage is a subclass of ResponseMessage that always sets the ResponseMessageType to
 * {@link ResponseMessageType#INFO}
 *
 * @author azuroff
 */
public class InfoResponseMessage extends ResponseMessage {

    /**
     * Create a new ErrorResponseMessage with the given message.
     *
     * @param message the message to return to the caller
     */
    public InfoResponseMessage(String message) {
        super(INFO, message);
    }

    public InfoResponseMessage(String message, String title) {
        super(INFO, message, title, true);
    }

    public InfoResponseMessage(String message, String title, boolean userVisible) {
        super(INFO, message, title, userVisible);
    }
}
