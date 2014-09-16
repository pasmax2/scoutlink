package uk.org.mattford.scoutlink.model;

import java.util.ArrayList;

import android.util.Log;

public class Conversation {
	
	public String CONVERSATION_NAME;
	private ArrayList<Message> messages;
	private ArrayList<Message> buffer;

	public Conversation(String name) {
		this.CONVERSATION_NAME = name;
		this.messages = new ArrayList<Message>();
		this.buffer = new ArrayList<Message>();
	}
	
	public String getName() {
		return this.CONVERSATION_NAME;
	}
	
	public ArrayList<Message> getMessages() {
		return this.messages;
	}
	
	public ArrayList<Message> getBuffer() {
		return this.buffer;
	}
	
	public void flushBuffer() {
		for (Message message : this.buffer) {
			messages.add(message);
		}
		this.buffer = null;
		this.buffer = new ArrayList<Message>();
	}
	
	public void addMessage(Message msg) {
		Log.d("ScoutLink", "Adding new message from : "+msg.sender+" to conversation.");
		buffer.add(msg);
	}
}