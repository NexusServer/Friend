package friend.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.utils.TextFormat;
import friend.DataBase;
import friend.Main;

public class Friend {

	private Main plugin;
	private Map<Player, Player> requestWarp;

	public Friend(Main plugin) {
		this.plugin = plugin;
		this.requestWarp = new HashMap<>();

	}

	public DataBase getDataBase() {
		return plugin.getDataBase();
	}

	public Manage getManage() {
		return plugin.getManage();
	}

	public boolean friendExist(Player player) {
		return this.friendExist(player.getName());
	}

	public boolean friendExist(String player) {
		return !getDataBase().FriendDB.containsKey(player.toLowerCase());
	}

	public void register(Player player) {
		getDataBase().FriendDB.put(player.getName().toLowerCase(), new ArrayList<String>());
	}

	public void delFriend(String player, String target) {
		getFriends(player).remove(target);
		getFriends(target).remove(player);
	}

	@SuppressWarnings("unchecked")
	public List<String> getFriends(String player) {
		ArrayList<String> list = new ArrayList<>();
		list.addAll((List<String>) getDataBase().FriendDB.get(player.toLowerCase()));
		return list;
	}

	public List<String> getFriends(Player player) {
		return this.getFriends(player.getName());
	}

	public void addFriend(String player, String target) {
		getFriends(player).add(target.toLowerCase());
		getFriends(target).add(player.toLowerCase());
		return;
	}

	public void addFriend(Player player, Player target) {
		List<String> list = getFriends(player);
		list.add(target.getName().toLowerCase());
		getDataBase().FriendDB.put(player.getName().toLowerCase(), list);

		List<String> list1 = getFriends(target);
		list.add(player.getName().toLowerCase());
		getDataBase().FriendDB.put(target.getName().toLowerCase(), list1);
	}

	public boolean isFriend(String p1, String p2) {
		return this.getFriends(p1.toLowerCase()).contains(p2.toLowerCase());
	}

	public boolean isFriend(Player p1, Player p2) {
		return this.isFriend(p1.getName().toLowerCase(), p2.getName().toLowerCase());
	}

	public void joinPlayer(Player player) {

		player.sendData((Player[]) getFriends(player).toArray(),
				player.getDataProperties().putString(Entity.DATA_NAMETAG, TextFormat.GREEN + player.getName()));
		try {
			plugin.getServer().getOnlinePlayers().values().stream().filter(p -> getFriends(player).contains(p))
					.forEach((Player p) -> {
						p.sendData(player, player.getDataProperties().putString(Entity.DATA_NAMETAG,
								TextFormat.GREEN + player.getName()));
					});
		} catch (Exception e) {
			return;
		}
	}

	public Player getRequester(Player target) {
		return this.requestWarp.get(target);
	}

	public boolean isTarget(Player player) {
		return requestWarp.containsKey(player);
	}

	public void warpRequest(Player player, String target) {
		this.requestWarp.put(plugin.getServer().getPlayer(target), player);
	}

	public void accept(Player player) {

		this.requestWarp.get(player).teleport(player);
	}

	public void refuse(Player player) {
		this.requestWarp.remove(player);
	}

}
