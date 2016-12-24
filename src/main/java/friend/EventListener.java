package friend;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
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

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		if (getManage().isFirst(event.getPlayer())) {
			event.getPlayer().sendMessage("친구 데이터가 존재하지 않습니다... 데이터를 불러올 수 없습니다");

		} else {
			getManage().onJoin(event.getPlayer());
		}
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (!command.getName().equals("친구")) {
			return true;
		}

		if (args.length <= 0) {
			sender.sendMessage(this.getMaunal());
			return true;
		}

		switch (args[0]) {
		case "request":
		case "신청":
			
			break;
		case "del":
		case "삭제":

			if (getManage().isFriend(sender.getName(), args[1])) {
				getManage().delFriend(sender.getName(), args[1]);
				return true;
			}

			break;
		case "list":
		case "목록":

			break;
		case "help":
		case "도움말":
			sender.sendMessage(this.getMaunal());
			break;
		}

		return false;

	}

	private String getMaunal() {
		String str = "";
		str = str + "";

		return str;
	}
}
