package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.IBulletBehaviour;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.entityparts.ExpirationPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;


public class BulletCreator implements IBulletBehaviour {

    public Entity bulletCreator(Entity origin) {
        PositionPart originPos = origin.getPart(PositionPart.class);

        float r = origin.getRadius();
        float x = originPos.getX();
        float y = originPos.getY();
        float radians = originPos.getRadians();
        final int bulletRadius = 2;

        x += (float) Math.cos(radians) * r * bulletRadius;
        y += (float) Math.sin(radians) * r * bulletRadius;

        Entity bullet = new Bullet();
        bullet.setRadius(bulletRadius);
        bullet.add(new MovingPart(0, 9001, 400, 0));
        bullet.add(new PositionPart(x, y, radians));
        bullet.add(new ExpirationPart(1));

        return bullet;
    }
}
