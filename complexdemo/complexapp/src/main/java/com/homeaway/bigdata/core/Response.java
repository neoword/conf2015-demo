/**
 *
 */
package com.homeaway.bigdata.core;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple message event
 */
public class Response {
    @NotEmpty
    private long time;
    private String message;

    public Response() {}

    public Response(long time, String message) {
        this.time = time;
        this.message = message;
    }

    @JsonProperty
    public long getTime() {
        return time;
    }
    @JsonProperty
    public void setTime(long time) {
        this.time = time;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }
    @JsonProperty
    public void setMessage(String message) {
        this.message = message;
    }
}
