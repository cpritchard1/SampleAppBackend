package com.myapp.MyAppBackend.infrastructure.web.response;

import static com.myapp.MyAppBackend.infrastructure.web.response.ResponseMessageType.WARN;

/**
 * WarnResponseMessage is a subclass of ResponseMessage that always sets the ResponseMessageType to
 * {@link ResponseMessageType#WARN}
 *
 * @author azuroff
 */
public class WarnResponseMessage extends ResponseMessage {

    public WarnResponseMessage(String message) {
        super(WARN, message);
    }

    public WarnResponseMessage(String message, String title) {
        super(WARN, message, title, false);
    }

    public WarnResponseMessage(String message, String title, boolean userVisible) {
        super(WARN, message, title, userVisible);
    }
}
