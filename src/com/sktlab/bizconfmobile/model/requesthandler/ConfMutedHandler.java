package com.sktlab.bizconfmobile.model.requesthandler;

import com.sktlab.bizconfmobile.mina.MinaUtil;
import com.sktlab.bizconfmobile.model.manager.CommunicationManager;
import com.sktlab.bizconfmobile.util.Util;

public class ConfMutedHandler extends RequestHandler {

	public static final String TAG = "ConfMuteHandler";
	
	@Override
	public void handleRequest(String request) {
	
		//Util.BIZ_CONF_DEBUG(TAG, "receive msg from server: " + request);
		
		if (request.contains(MinaUtil.MSG_CONF_MUTE)) {
			
			//Util.BIZ_CONF_DEBUG(TAG, "receive roll call msg");
			
			commManager.notifyConfChanged(CommunicationManager.CONF_MUTE);
			
		}else if(!Util.isEmpty(successor)) {
			
			this.successor.handleRequest(request);
		}
		
	}

}
