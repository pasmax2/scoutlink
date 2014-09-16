package uk.org.mattford.scoutlink.adapter;

import java.util.LinkedList;

import uk.org.mattford.scoutlink.model.Conversation;
import uk.org.mattford.scoutlink.model.Message;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class MessageListAdapter extends BaseAdapter implements ListAdapter {
	
	private LinkedList<TextView> messages;
	private Conversation conversation;
	private Context context;
	
	public MessageListAdapter(Conversation conversation, Context context) {
		super();
		this.conversation = conversation;
		this.context = context;
		this.messages = new LinkedList<TextView>();
		TextView test = new TextView(context);
		test.setText("Testing");
		messages.add(test);
		notifyDataSetChanged();
	}
	
	public void addMessage(Message message) {
		TextView tv = new TextView(this.context);
		tv.setText(message.sender + ": " + message.text);
		Log.d("ScoutLink", "MessageListAdapter.addMessage() called, adding: " + message.sender + ": " + message.text);
		messages.add(tv);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		Log.d("ScoutLink", "MessageListAdapter.getCount() ("+this.conversation.getName()+") called, returing: " + messages.size());
		return messages.size();
	}

	@Override
	public TextView getItem(int position) {
		Log.d("ScoutLink", "MessageListAdapter.getItem() ("+this.conversation.getName()+") called: " + position);
		return messages.get(position);
	}

	@Override
	public long getItemId(int position) {
		Log.d("ScoutLink", "MessageListAdapter.getItemId() ("+this.conversation.getName()+") called: "+position);
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Log.d("ScoutLink", "MessageListAdapter.getView() called: " + position);
		return getItem(position);
	}



}
