package dk.sdu.mmmi.cbse.common.bullet;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.EntityType;

public class Bullet extends Entity {

    public Bullet() {
        hexColor = "B4DED5";
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.BULLET;
    }
}
