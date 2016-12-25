package friend.manage;

import java.util.List;

import cn.nukkit.Player;
import friend.DataBase;
import friend.Main;

public class Manage {

	private Friend friend;

	private Main plugin;

	public Manage(Main plugin) {

		this.plugin = plugin;

		this.friend = new Friend(plugin);

	}

	public DataBase getBataBase() {
		return this.plugin.getDataBase();
	}

	public void joinPlayer(Player player) {
		this.friend.joinPlayer(player);
	}

	public void register(Player player) {
		this.friend.register(player);
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

	public boolean friendExist(Player player) {
		return friend.friendExist(player);
	}

	public boolean friendExist(String player) {
		return friend.friendExist(player);
	}

	public boolean isRequester(Player player) {
		return friend.isRequester(player);
	}

	public void warpRequest(Player player, String target) {
		friend.warpRequest(player, target);
	}
	public void accept(Player player){
		friend.accept(player);
	}
}
