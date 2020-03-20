package service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import repository.IRepository;
import service.MessageService;

@Service(value = "messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	@Qualifier(value = "txtRepository")
	private IRepository repositoryTxt;

	@Autowired
	@Qualifier(value = "xmlRepository")
	private IRepository repositoryXml;
	/*
	 * public MessageServiceImpl(IRepository repository) { this.repository =
	 * repository; }
	 */

	public void save(String message, boolean xml) {
		if (xml) {
			repositoryXml.save(message);
		} else {
			repositoryTxt.save(message);
		}
	}

	/*
	 * @Autowired
	 * 
	 * @Qualifier(value ="xmlRepository")
	 * 
	 * 
	 * @Resource(name = "xmlRepository") public void setRepository(IRepository
	 * repository) { this.repository = repository; }
	 */

}
