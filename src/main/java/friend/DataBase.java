package friend;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.nukkit.Player;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.utils.Config;

public class DataBase {

	private Plugin plugin;
	private LinkedHashMap<String, Object> FriendDB;

	public DataBase(Plugin plugin) {
		this.plugin = plugin;
		plugin.getDataFolder().mkdirs();

	}

	public void initDB() {
		FriendDB = (LinkedHashMap<String, Object>) new Config(new File(plugin.getDataFolder(), "Friend.json"),
				Config.JSON).getAll();

	}

	public void save() {
		Config FriendDB = new Config(new File(plugin.getDataFolder(), "Friend.json"), Config.JSON);
		FriendDB.setAll(this.FriendDB);
		FriendDB.save();
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Player> getFriend(String player) {
		ArrayList<Player> friend = new ArrayList<>();

		for (String str : (List<String>) ((Map<String, Object>) this.FriendDB.get(player.toLowerCase())).get("friends")) {
			friend.add(plugin.getServer().getPlayer(str));
		}

		return friend;

	}
}
