package friend.manage;

import friend.Main;

public class Manage {

	private Request request;

	public Manage(Main plugin) {
		this.request = new Request(plugin);

	}

	public Request getRequest() {
		
		return this.request;
	}

}
