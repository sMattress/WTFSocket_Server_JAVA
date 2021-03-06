package wtf.socket.controller;

import org.springframework.stereotype.Controller;
import wtf.socket.exception.WTFSocketException;
import wtf.socket.protocol.WTFSocketMsg;
import wtf.socket.routing.item.WTFSocketRoutingItem;

import java.util.List;

/**
 * 服务器功能接口
 */
@Controller
public interface WTFSocketController {

    boolean isResponse(WTFSocketMsg msg);

    void work(WTFSocketRoutingItem item, WTFSocketMsg request, List<WTFSocketMsg> responses) throws WTFSocketException;

}
