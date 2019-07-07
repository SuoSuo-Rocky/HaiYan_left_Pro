package org.shiwei.service.Impl;

import org.shiwei.dao.MessageDao;
import org.shiwei.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService_Impl implements MessageService{

	
	@Autowired
	MessageDao messageDao;

	public MessageDao getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	
	
}
