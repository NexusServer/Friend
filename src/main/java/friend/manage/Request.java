package friend.manage;

import friend.DataBase;
import friend.Main;

public class Request {

	private Main plugin;

	public Request(Main plugin) {
		this.plugin = plugin;
	}

	public DataBase getDataBase() {
		return this.plugin.getDataBase();
	}
	
	public Manage getManage(){
		return plugin.getManage();
	}
}
