package world;

public class BossAI extends CreatureAI {

    private Creature player;


    public BossAI(Creature creature,Creature player) {
        super(creature);
        this.player = player;
    }

    public void onUpdate() {
        movetoattack();
    }

    private void movetoattack() {
        int sx = creature.x() - player.x();
        int sy = creature.y() - player.y();
        int dx = Math.abs(sx);
        int dy = Math.abs(sy);
        if (dx + dy <= 2) {
            creature.attack(player);
        }
        else {
            int newx = sx / dx;
            int newy = sy / dy;
            creature.moveBy(newx, newy);
        }
    }
}
