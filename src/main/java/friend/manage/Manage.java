package friend.manage;

import friend.DataBase;
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

	public DataBase getBataBase() {
		return this.plugin.getDataBase();
	}

}
