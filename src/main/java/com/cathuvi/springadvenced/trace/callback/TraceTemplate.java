package com.cathuvi.springadvenced.trace.callback;

import com.cathuvi.springadvenced.trace.TraceStatus;
import com.cathuvi.springadvenced.trace.logtrace.LogTrace;

public class TraceTemplate {

    private final LogTrace trace;


    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback){
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            T result = callback.call();
            trace.end(status);
            return  result;

        }catch (Exception e){
            trace.exception(status,e);
            throw e;
        }
    }

}
