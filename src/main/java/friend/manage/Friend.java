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

	public void unFriend(String player, String target) {
		getFriends(player).remove(target);
		getFriends(target).remove(player);
	}

	public List<String> getFriends(String player) {
		return (ArrayList<String>) this.getDataBase().FriendDB.get(player.toLowerCase());
	}

	public List<String> getFriends(Player player) {
		return this.getFriends(player.getName().toLowerCase());
	}

	public boolean isFriend(String p1, String p2) {
		return this.getFriends(p1.toLowerCase()).contains(p2.toLowerCase());
	}

	public boolean isFriend(Player p1, Player p2) {
		return this.isFriend(p1.getName().toLowerCase(), p2.getName().toLowerCase());
	}

	public boolean isFriend(String p1, Player p2) {
		return this.isFriend(p1.toLowerCase(), p2.getName().toLowerCase());
	}

	public boolean isFriend(Player p1, String p2) {
		return this.isFriend(p1.getName().toLowerCase(), p2.toLowerCase());
	}

}
