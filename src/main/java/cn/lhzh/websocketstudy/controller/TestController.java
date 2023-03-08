package cn.lhzh.websocketstudy.controller;

import cn.lhzh.websocketstudy.dto.MsgResponseVo;
import cn.lhzh.websocketstudy.websocketserver.WebSocketServer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 卢宏政
 * @date 2023/3/8 19:14
 */
@RestController()
@RequestMapping("test")
public class TestController {

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/testWebSocket")
    public Map<String,Object> testWebSocket() throws IOException {
        Map<String,Object>map = new HashMap<>();
        //消息体
        MsgResponseVo technicianMsgResponseVo = new MsgResponseVo();
        technicianMsgResponseVo.setRole("Technician");
        technicianMsgResponseVo.setRoleId(1);
        technicianMsgResponseVo.setMsg("您的订单已取消");
        technicianMsgResponseVo.setMsgStatus("CANCEL_ORDER");
        technicianMsgResponseVo.setOrderNo("test");
        //发送消息
        WebSocketServer.sendInfo(objectMapper.writeValueAsString(technicianMsgResponseVo));
        map.put("result","success");
        return map;
    }
}
