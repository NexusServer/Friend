package friend.manage;

import java.util.List;

import cn.nukkit.Player;
import friend.DataBase;
import friend.Main;

public class Manage {

	private Request request;
	private Friend friend;

	private Main plugin;

	public Manage(Main plugin) {

		this.plugin = plugin;

		this.request = new Request(plugin);
		this.friend = new Friend(plugin);

	}

	public DataBase getBataBase() {
		return this.plugin.getDataBase();
	}

	public void onJoin(Player player) {
		this.friend.onJoin(player);
	}

	public void addFriend(String player, String target) {
		this.friend.addFriend(player, target);
	}

	public void addFriend(Player player, Player target) {
		this.friend.addFriend(player, target);
	}

	public void delFriend(String player, String target) {
		this.friend.delFriend(player, target);
	}

	public List<String> getFriends(Player player) {
		return friend.getFriends(player);
	}

	public List<String> getFriends(String player) {
		return friend.getFriends(player);
	}

	public boolean isFriend(String p1, String p2) {
		return this.friend.isFriend(p1, p2);
	}

	public boolean isFreind(Player p1, Player p2) {
		return this.friend.isFriend(p1, p2);
	}

	public boolean isFirst(Player player) {
		return this.friend.isFirst(player);
	}
	public void requestFriend(String target, String player){
		this.request.requestFriend(target, player);
	}

	public List<String> getRequester(String player) {
		return this.request.getRequester(player);
	}

}
