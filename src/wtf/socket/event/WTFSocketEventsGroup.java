package wtf.socket.event;

import org.springframework.stereotype.Component;
import wtf.socket.exception.WTFSocketException;
import wtf.socket.routing.item.WTFSocketRoutingItem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * Created by zfly on 2017/4/25.
 */
@Component("wtf.socket.eventsGroup")
public class WTFSocketEventsGroup {

    private final Map<WTFSocketEventsType, Set<WTFSocketEventListener>> group = new HashMap<WTFSocketEventsType, Set<WTFSocketEventListener>>(4) {{
        for (WTFSocketEventsType eventsType : WTFSocketEventsType.values()) {
            put(eventsType, new HashSet<>(3));
        }
    }};

    public void addEventListener(WTFSocketEventListener eventListener, WTFSocketEventsType eventsType) {
        group.get(eventsType).add(eventListener);
    }

    public void removeEventListener(WTFSocketEventListener eventListener, WTFSocketEventsType eventsType) {
        group.get(eventsType).remove(eventListener);
    }

    public void occur(WTFSocketRoutingItem item, Object info, WTFSocketEventsType eventsType) throws WTFSocketException{
        for (WTFSocketEventListener eventListener : group.get(eventsType)) {
            eventListener.notify(item, info);
        }
    }

}
