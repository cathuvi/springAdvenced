package com.cathuvi.springadvenced.app.v3;

import com.cathuvi.springadvenced.trace.TraceId;
import com.cathuvi.springadvenced.trace.TraceStatus;
import com.cathuvi.springadvenced.trace.hellotrace.HelloTraceV2;
import com.cathuvi.springadvenced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId){
        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);

        }catch (Exception e){
            trace.exception(status,e);
            throw e;
        }

    }

}
