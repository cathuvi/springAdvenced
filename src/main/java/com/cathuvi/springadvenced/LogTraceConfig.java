package com.cathuvi.springadvenced;

import com.cathuvi.springadvenced.trace.logtrace.FiledLogTrace;
import com.cathuvi.springadvenced.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new FiledLogTrace();
    }
}
