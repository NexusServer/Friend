package friend.manage;

import friend.DataBase;
import friend.Main;

public class Manage {

	private Request request;
	private Chat chat;
	private Friend friend;

	private Main plugin;

	public Manage(Main plugin) {

		this.plugin = plugin;

		this.request = new Request(plugin);
		this.chat = new Chat(plugin);
		this.friend = new Friend(plugin);

	}

	public DataBase getBataBase() {
		return this.plugin.getDataBase();
	}

}
