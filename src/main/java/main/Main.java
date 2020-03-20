package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.MyBeanConfig;
import repository.IRepository;
import service.MessageService;

@Component(value = "main")
public class Main {
	
	public static void main(String[] args) {
		BeanFactory container = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		Main main = (Main)container.getBean("main");
		//main.annotationConfig();
		main.saveMessage(container, "Gladan sam!!!");
		
		((AnnotationConfigApplicationContext) container).close();
	}

	private void annotationConfig(BeanFactory container) {
		IRepository txtRepository = (IRepository)container.getBean("txtRepository");
		txtRepository.save("My plain message!");
		
		IRepository xmlRepository = container.getBean("xmlRepository", IRepository.class);
		xmlRepository.save("My xml message!");
		
		((AnnotationConfigApplicationContext) container).close();
	}
	
	private void saveMessage(BeanFactory container, String message) {
		
		MessageService messageService =	container.getBean("messageService", MessageService.class);
		messageService.save(message, false);
		((AnnotationConfigApplicationContext) container).close();
	}
}
