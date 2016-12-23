package friend.manage;

import java.util.ArrayList;
import java.util.List;

import cn.nukkit.Player;
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

	public List<String> getFriends(String player) {
		return (ArrayList<String>) this.getDataBase().FriendDB.get(player);
	}

	public boolean isFriend(String p1, String p2) {
		return true;
	}

}
