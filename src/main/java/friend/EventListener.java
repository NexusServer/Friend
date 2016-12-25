package friend;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
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

		if (command.getName().equals("친구")) {
			if (args.length < 1 || args == null) {
				sender.sendMessage(getMaunal());
				return true;
			}

			switch (args[0]) {
			case "추가":

				break;

			case "삭제":
				break;
			case "목록":

				break;
			case "관리":

				break;
			case "워프요청":
				getManage().warpRequest((Player) sender, args[1]);
			}

		}

		return false;

	}

	@EventHandler
	public void onWarpRequest(PlayerChatEvent event) {
		if (getManage().isTarget(event.getPlayer())) {
			if (event.getMessage().equals("수락")) {
				getManage().accept(event.getPlayer());
			} else {
				getManage().refuse(event.getPlayer());
			}
		}
	}

	private String getMaunal() {
		String str = "";
		str = str + "";

		return str;
	}
}
