package com.myapp.MyAppBackend.infrastructure.web.response;

import com.myapp.MyAppBackend.common.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The CommonWebResponse is the base response class for all API Controller endpoints. Every
 * {@literal @RestController} class method with a {@literal @RequestMapping} annotation should
 * return a subclass of this class.
 *
 * @param <T> The type of data being returned for this response.
 * @author azuroff
 */
@SuppressWarnings("WeakerAccess")
@ResponseBody
public abstract class CommonWebResponse<T> {

    // Fields are public so they will be automatically picked up by Jackson
    // and serialized to JSON.
    @JsonView(Views.Any.class)
    public final Boolean success;

    @JsonView(Views.Any.class)
    public final List<ResponseMessage> msg;

    @JsonView(Views.Any.class)
    public T data;

    /**
     * Create a CommonWebResponse object with all data provided up front.
     *
     * @param success true or false to indicate a successful request or not
     * @param data    the data to be serialized and returned to the caller
     * @param msg     an array of 0 or more messages to be returned to the caller
     */
    public CommonWebResponse(Boolean success, T data, ResponseMessage... msg) {
        this.success = success;
        this.data = data;
        this.msg = Arrays.asList(msg);
    }

    /**
     * Create a CommonWebResponse object with all data provided up front.
     *
     * @param success true or false to indicate a successful request or not
     * @param data    the data to be serialized and returned to the caller
     * @param msg     an list of 0 or more messages to be returned to the caller
     */
    public CommonWebResponse(Boolean success, T data, List<ResponseMessage> msg) {
        this.success = success;
        this.data = data;
        this.msg = msg;
    }

    /**
     * Create a CommonWebResponse object with only the success value proved up front. The data and
     * any messages will be added later.
     *
     * @param success true or false to indicate a successful request or not
     */
    public CommonWebResponse(Boolean success) {
        this.success = success;
        this.data = null;
        this.msg = new ArrayList<>();
    }

    /**
     * Sets the data for the response.
     *
     * @param data the data to be serialized and returned to the caller
     * @throws IllegalStateException if the data field has been set previously
     */
    public void setData(T data) {
        if (this.data != null) {
            throw new IllegalStateException("Data has already been defined for CommonWebResponse!");
        }

        this.data = data;
    }

    /**
     * Adds a message to the list of ResponseMessage objects.
     *
     * @param msg a ResponseMessage to be returned to the caller
     */
    public void addResponseMessage(ResponseMessage msg) {
        this.msg.add(msg);
    }
}
