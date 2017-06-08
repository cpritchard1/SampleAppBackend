package com.myapp.MyAppBackend.infrastructure.web.response;

import java.util.List;

/**
 * SuccessWebResponse is a subclass of CommonWebResponse that automatically sets the success flag to
 * true.
 *
 * @param <T> The type of data being returned for this response.
 * @author azuroff
 */
public class SuccessWebResponse<T> extends CommonWebResponse<T> {

    /**
     * Create a SuccessWebResponse object with all data provided up front.
     *
     * @param data the data to be serialized and returned to the caller
     * @param msg  an array of 0 or more messages to be returned to the caller
     */
    public SuccessWebResponse(T data, ResponseMessage... msg) {
        super(true, data, msg);
    }

    /**
     * Create a SuccessWebResponse object with all data provided up front.
     *
     * @param data the data to be serialized and returned to the caller
     * @param msg  a list of 0 or more messages to be returned to the caller
     */
    public SuccessWebResponse(T data, List<ResponseMessage> msg) {
        super(true, data, msg);
    }

    /**
     * Create an empty FailureWebResponse object. The data and any messages will be added later.
     */
    @SuppressWarnings("unused")
    public SuccessWebResponse() {
        super(true);
    }
}
