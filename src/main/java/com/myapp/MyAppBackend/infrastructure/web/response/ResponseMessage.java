package com.myapp.MyAppBackend.infrastructure.web.response;

/**
 * ResponseMessage is a wrapper for responses that are to be returned to the client in the {@link
 * CommonWebResponse#msg} portion of the {@link CommonWebResponse}
 *
 * @author azuroff
 */
public abstract class ResponseMessage {

    /**
     * The type of message being returned. Can be one of {@link ResponseMessageType#INFO}, {@link
     * ResponseMessageType#WARN}, or {@link ResponseMessageType#ERROR}
     */
    public final ResponseMessageType type;

    /** The message itself. */
    public final String message;

    /** The title itself. */
    public final String title;

    /** The userVisible itself. */
    public final boolean userVisible;

    /**
     * Create a new ResponseMessage with the given {@link ResponseMessageType} and message
     *
     * @param type the type of message being returned
     * @param message the message itself
     */
    public ResponseMessage(ResponseMessageType type, String message) {
        this(type, message, type.toString(), true);
    }

    public ResponseMessage(
            ResponseMessageType type, String message, String title, boolean userVisible) {
        this.type = type;
        this.message = message;
        this.title = title;
        this.userVisible = userVisible;
    }
}
