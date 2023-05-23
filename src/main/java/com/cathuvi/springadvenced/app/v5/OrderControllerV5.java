package com.cathuvi.springadvenced.app.v5;

import com.cathuvi.springadvenced.trace.callback.TraceCallback;
import com.cathuvi.springadvenced.trace.callback.TraceTemplate;
import com.cathuvi.springadvenced.trace.logtrace.LogTrace;
import com.cathuvi.springadvenced.trace.template.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }


    @GetMapping("/v5/request")
    public  String request(String itemId){
        return template.execute("OrderControllerV5.request()", new TraceCallback<String>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }
}
