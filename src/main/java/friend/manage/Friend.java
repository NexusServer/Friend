package friend.manage;

import friend.DataBase;
import friend.Main;

public class Friend {

	private Main plugin;

	public Friend(Main plugin) {
		this.plugin = plugin;

	}

	public DataBase getDataBase() {
		return plugin.getDataBase();
	}

	public Manage getManage() {
		return plugin.getManage();
	}
	public boolean isFriend(String p1, String p2){
		return true;
	}
}
