package com.cathuvi.springadvenced.trace.logtrace;

import com.cathuvi.springadvenced.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);
    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
