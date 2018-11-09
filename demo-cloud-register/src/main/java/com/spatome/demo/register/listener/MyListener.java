package com.spatome.demo.register.listener;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.eureka.EurekaServerConfig;

import lombok.extern.slf4j.Slf4j;

@Component
@Async
@Slf4j
public class MyListener {

	/**
	 * 注册服务启动事件
	 * 打印参数
	 */
	@EventListener
	public void handlerEurekaServerStartedEvent(EurekaServerStartedEvent event){
		try {
			log.info("==================启动参数===================");
			EurekaServerConfig esc = (EurekaServerConfig)event.getSource();
			this.printObject(esc);
		} catch (Exception e) {
		}
	};

	/**
	 * 客户端注册事件
	 */
	@EventListener
	public void handlerEurekaInstanceRegisteredEvent(EurekaInstanceRegisteredEvent event){
		try {
			log.info("==================客户端注册参数===================");
			InstanceInfo instanceInfo = event.getInstanceInfo();
			this.printObject(instanceInfo);
			log.info("====>leaseDuration:"+event.getLeaseDuration());
			log.info("====>isReplication:"+event.isReplication());
		} catch (Exception e) {
		}
	}

	private <T> void printObject(T obj){
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				String name = field.getName();
				String methodName = "get"+name.substring(0,1).toUpperCase()+name.substring(1);
				Method method = obj.getClass().getMethod(methodName);
				Object ret = method.invoke(obj);
				log.info("==>"+name+":"+ret);
			} catch (Exception e) {
			}
		}
	}
}
