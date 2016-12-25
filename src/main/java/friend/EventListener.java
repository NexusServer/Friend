package friend;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.utils.TextFormat;
import friend.manage.Manage;

public class EventListener implements Listener {

	private Main plugin;

	public EventListener(Main plugin) {
		this.plugin = plugin;
	}

	public Main getPlugin() {
		return plugin;
	}

	public DataBase getDataBase() {
		return plugin.getDataBase();
	}

	public Manage getManage() {
		return plugin.getManage();
	}

	

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!command.getName().equals("친구")) {
			return true;
		}

		if (args.length <= 0) {
			sender.sendMessage(this.getMaunal());
			return true;
		}

		return false;

	}

	private String getMaunal() {
		String str = "";
		str = str + "";

		return str;
	}
}
