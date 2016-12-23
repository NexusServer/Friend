package friend.manage;

import friend.Main;

public class Manage {

	private Request request;
	private Main plugin;

	public Manage(Main plugin) {
		this.plugin = plugin;
		this.request = new Request(plugin);

	}

	public Request getRequest() {

		return this.request;
	}

}
