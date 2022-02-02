package io.priax.process.services;

import static io.cloudevents.core.CloudEventUtils.mapData;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.kie.kogito.event.cloudevents.utils.CloudEventUtils.Mapper;

import io.cloudevents.CloudEvent;
import io.cloudevents.core.data.PojoCloudEventData;
import io.cloudevents.jackson.PojoCloudEventDataMapper;
import io.priax.process.AlertKpiStatusComposition;
import io.smallrye.reactive.messaging.annotations.Blocking;
import io.vertx.core.impl.logging.Logger;
import io.vertx.core.impl.logging.LoggerFactory;

@ApplicationScoped
public class AlertProcessConsumer {

    private static final Logger logger = LoggerFactory.getLogger(AlertProcessConsumer.class);

    
    @Incoming("kpistatus-processor")
    @Blocking("kpiflow-pool")
    public CompletionStage<Void> consume(Message<String> kpistatusEvent){
        try {
            
            Optional<CloudEvent> cloud = Optional.of(Mapper.mapper().readValue(kpistatusEvent.getPayload(), CloudEvent.class));
            PojoCloudEventData<AlertKpiStatusComposition> cloudEventData = mapData(
                cloud.get(),
                PojoCloudEventDataMapper.from(Mapper.mapper(),AlertKpiStatusComposition.class)
            );
            Map<String,Object> requestData = new HashMap<>();
            requestData.put("alertKpiComposition", cloudEventData.getValue());
            //logger.info(new Date());
            
        }catch (Exception e) {
            e.printStackTrace();
            return kpistatusEvent.nack(e);
        }
        logger.info(new Date());
        return kpistatusEvent.ack();
    }
}
