package friend.manage;

import java.util.ArrayList;
import java.util.List;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.data.EntityMetadata;
import cn.nukkit.utils.TextFormat;
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

	public boolean isFirst(Player player) {
		return !getDataBase().FriendDB.containsKey(player);
	}

	public void delFriend(String player, String target) {
		getFriends(player).remove(target);
		getFriends(target).remove(player);
	}

	public void onJoin(Player player) {

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

	public List<String> getFriends(String player) {
		return (ArrayList<String>) this.getDataBase().FriendDB.get(player.toLowerCase());
	}

	public List<String> getFriends(Player player) {
		return this.getFriends(player.getName().toLowerCase());
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

}
