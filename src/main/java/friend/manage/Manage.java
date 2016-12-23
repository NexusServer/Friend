package friend.manage;

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

	public boolean isFirst(Player player) {
		return this.friend.isFirst(player);
	}

}
