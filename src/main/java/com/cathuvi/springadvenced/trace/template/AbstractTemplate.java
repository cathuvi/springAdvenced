package com.cathuvi.springadvenced.trace.template;

import com.cathuvi.springadvenced.trace.TraceStatus;
import com.cathuvi.springadvenced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    protected AbstractTemplate(LogTrace logTrace) {
        this.trace = logTrace;
    }

    public T excute(String message){
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            T result = call();

            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}
