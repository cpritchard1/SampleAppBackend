package com.myapp.MyAppBackend.infrastructure.web.response;

/**
 * A helper enum class for limiting the types of {@link ResponseMessage} objects that can be sent to
 * the client.
 *
 * @author azuroff
 */
enum ResponseMessageType {
    DEBUG,
    INFO,
    WARN,
    ERROR
}

