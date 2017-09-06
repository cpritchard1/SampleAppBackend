package com.myapp.MyAppBackend.infrastructure.web.response;

import static com.myapp.MyAppBackend.infrastructure.web.response.ResponseMessageType.DEBUG;

/**
 * WarnResponseMessage is a subclass of ResponseMessage that always sets the ResponseMessageType to
 * {@link ResponseMessageType#DEBUG}
 *
 * @author azuroff
 */
public class DebugResponseMessage extends ResponseMessage {

    public DebugResponseMessage(String message) {
        super(DEBUG, message);
    }
}
