package poly.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.service.IMqttService;

@Service("MqttService")
public class MqttdService implements IMqttService{
	
	private Logger log = Logger.getLogger(this.getClass().getName());
	
	@RequestMapping(value="/mqtt/getMessage")
	public String mqttSub() {
		log.info(this.getClass().getName() + "mqttSub Start!!");
		log.info(this.getClass().getName() + "mqttSub END!!");
		
		return "";
	}
	
	
}
