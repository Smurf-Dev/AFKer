package afk.scripts;

import org.powerbot.script.Condition;
import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Game.Tab;

import afk.node.Task;

public class AFK1 extends Task {
	
    public static String paintStatus = "Loaded.";

	public AFK1(ClientContext ctx) {
		super(ctx);
	}
	
	@Override
    public boolean activate() {
        return ctx.game.loggedIn();
    }

    @Override
    public void execute() {
    	
    	int rand = Random.nextInt(0, 15);
    	
    	switch(rand){
    	
    	/// Random Running
		case 0:
			if (ctx.movement.running(true)){
				paintStatus = "Random: Run Toggle.";
				Condition.sleep(Random.nextInt(1000, 4000));
				ctx.movement.running(false);
				Condition.sleep(Random.nextInt(1000, 4000));
			}
			
			if (ctx.movement.running(false)){
				paintStatus = "Random: Run Toggle.";
				Condition.sleep(Random.nextInt(1000, 4000));
				ctx.movement.running(true);
				Condition.sleep(Random.nextInt(1000, 4000));
			}
			Condition.sleep(Random.nextInt(1000, 4000));
			break;
			
		/// Random Tabs
		case 1:
			int randomTab = Random.nextInt(1, 20);
			
			if(randomTab == 1){
				paintStatus = "Random Tab: Attack.";
				ctx.game.tab(Tab.ATTACK);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 2){
				paintStatus = "Random Tab: Clan Chat.";
				ctx.game.tab(Tab.CLAN_CHAT);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 3){
				paintStatus = "Random Tab: Emotes.";
				ctx.game.tab(Tab.EMOTES);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 4){
				paintStatus = "Random Tab: Equipment.";
				ctx.game.tab(Tab.EQUIPMENT);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 5){
				paintStatus = "Random Tab: Friends List.";
				ctx.game.tab(Tab.FRIENDS_LIST);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 6){
				paintStatus = "Random Tab: Ignored List.";
				ctx.game.tab(Tab.IGNORED_LIST);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 7){
				paintStatus = "Random Tab: Inventory.";
				ctx.game.tab(Tab.INVENTORY);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 8){
				paintStatus = "Random Tab: Logout.";
				ctx.game.tab(Tab.LOGOUT);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 9){
				paintStatus = "Random Tab: Magic.";
				ctx.game.tab(Tab.MAGIC);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 10){
				paintStatus = "Random Tab: Music.";
				ctx.game.tab(Tab.MUSIC);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 11){
				paintStatus = "Random Tab: Options.";
				ctx.game.tab(Tab.OPTIONS);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 12){
				paintStatus = "Random Tab: Prayer.";
				ctx.game.tab(Tab.PRAYER);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 13){
				paintStatus = "Random Tab: Quests.";
				ctx.game.tab(Tab.QUESTS);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
				
			}else if(randomTab == 14){
				paintStatus = "Random Tab: Stats.";
				ctx.game.tab(Tab.STATS);
				Condition.sleep(Random.nextInt(800, 1800));
				ctx.game.tab(Tab.INVENTORY);
			}
				break;
			
			/// Random Camera
			case 3:
				paintStatus = "Random Camera: Angle.";
				ctx.camera.angle(Random.nextInt(1, 359));
				Condition.sleep(Random.nextInt(1000, 2000));
				break;
				
			case 4:
				paintStatus = "Random Camera: Pitch.";
				ctx.camera.pitch(Random.nextInt(1, 100));
				Condition.sleep(Random.nextInt(1000, 2000));
				break;
				
			case 5:
				paintStatus = "Random Camera: Pitch & Angle.";
				ctx.camera.angle(Random.nextInt(1, 359));
				ctx.camera.pitch(Random.nextInt(1, 100));
				Condition.sleep(Random.nextInt(1000, 2000));
				break;
				
			/// Random Move To Myself
			case 6:
				final Tile meme = new Tile(ctx.players.local().tile().x(), ctx.players.local().tile().y());
				paintStatus = "Random Movement: "+meme;
				ctx.movement.step(meme);
				Condition.sleep(Random.nextInt(1000, 2000));
				break;
			
			/// Random Wait
			case 7:
				paintStatus = "Nuthin...";
				Condition.sleep(Random.nextInt(100, 800));
				break;
				
			/// Random Bank Open
			case 8:
				paintStatus = "Random: Bank Open & Close...";
				GameObject bankBooth = ctx.objects.select().nearest().poll();
				if (bankBooth.inViewport()){
					bankBooth.interact("Bank");
					Condition.sleep(Random.nextInt(10000, 20000));
					ctx.menu.close();
				}
    	}
    	
    }
    
}