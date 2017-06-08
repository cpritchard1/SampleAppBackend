package com.myapp.MyAppBackend.infrastructure.web.response;

import java.util.List;

/**
 * FailureWebResponse is a subclass of CommonWebResponse that automatically sets the success flag to
 * false.
 *
 * @param <T> The type of data being returned for this response.
 * @author azuroff
 */
@SuppressWarnings("WeakerAccess")
public class FailureWebResponse<T> extends CommonWebResponse<T> {

    /**
     * Create a FailureWebResponse object with all data provided up front.
     *
     * @param data the data to be serialized and returned to the caller
     * @param msg  an array of 0 or more messages to be returned to the caller
     */
    public FailureWebResponse(T data, ResponseMessage... msg) {
        super(false, data, msg);
    }

    /**
     * Create a FailureWebResponse object with all data provided up front.
     *
     * @param data the data to be serialized and returned to the caller
     * @param msg  a list of 0 or more messages to be returned to the caller
     */
    @SuppressWarnings("unused")
    public FailureWebResponse(T data, List<ResponseMessage> msg) {
        super(false, data, msg);
    }

    /**
     * Create an empty FailureWebResponse object. The data and any messages will be added later.
     */
    public FailureWebResponse() {
        super(false);
    }
}
