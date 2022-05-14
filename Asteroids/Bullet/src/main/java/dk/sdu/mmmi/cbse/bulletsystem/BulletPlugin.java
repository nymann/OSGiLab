package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.openide.util.lookup.ServiceProvider;


@ServiceProvider(service = IGamePluginService.class)
public class BulletPlugin implements IGamePluginService {

    public BulletPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
    }


    @Override
    public void stop(GameData gameData, World world) {
        world.getEntities().removeIf(entity -> entity instanceof Bullet);
    }
}