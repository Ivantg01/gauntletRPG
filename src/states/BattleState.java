package states;

import entities.*;
import gfx.Asset;
import handler.Handler;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BattleState extends State{

    private int width, height;
    private Enemy enemy;
    private Player player;
    private BufferedImage battleBackground;
    private boolean playerTurn;
    private Ability lastAbilityUsed;
    private String message;
    private Random random;

    private long lastAttackTimer=System.currentTimeMillis(), attackCooldown=3000, attackTimer = 0;


    /**
     * Constructor of the State class
     *
     * @param handler
     */
    public BattleState(Handler handler) {
        super(handler);
        width = handler.getWidth();
        height = handler.getHeight();
    }

    /**
     * Init a new battle and create the scenario
     */
    @Override
    public void initState() {
        if (enemy == null) return;

        Utils.writeLog("New Battle with a "+ enemy.getName());

        if (enemy instanceof Goblin)
            battleBackground = Asset.battle1;
        else if (enemy instanceof Skeleton)
            battleBackground = Asset.battle2;
        else battleBackground = Asset.battle3;

        player = handler.getPlayer();
        player.recoverStats();
        playerTurn = (player.getSpeed() > enemy.getSpeed());
        random = new Random(System.currentTimeMillis());
    }

    /**
     * time process to make any process before drawing
     */
    @Override
    public void tick() {
        if (playerTurn){
            playerAttack();
        }else {
            enemyAttack();
        }
    }

    /**
     * time process to draw anything needed
     * @param g
     */
    @Override
    public void render(Graphics g) {
        drawScenario(g);
        if (lastAbilityUsed == null) {
            message = "Press 1, 2, 3 to use an ability";
            drawMessage(g);
            return;
        }
        drawAttack(g);
        drawMessage(g);
    }

    /**
     * Draw the battle scenario, background, information bars and creatures
     * @param g graphics object used to draw
     */
    private void drawScenario(Graphics g) {
        g.drawImage(battleBackground, 20, 100, width - 40, height - 200,null);
        g.drawRect(20,100,width-40,height-200);
        g.fillRect(20,100,width-40,26);
        g.fillRect(20,height - 67,width-40,26);
        g.setColor(Color.white);
        g.setFont(new Font("Fixedsys", Font.PLAIN, 16));
        g.drawString("Player Hp/Mp:", 25, 120);
        g.drawString("Enemy Hp/Mp:", width - 200, 120);
        g.setColor(Color.cyan);
        g.drawString(handler.getPlayer().getHp()+"/"+handler.getPlayer().getMp(), 140, 120);
        g.drawString(enemy.getHp()+"/"+enemy.getMp(), width-80, 120);
        g.drawImage(handler.getPlayer().getSprites()[7], 175, height-250, 96,96, null);
        g.drawImage(enemy.getSprites()[3], 375, height-250, 96,96, null);
    }

    /**
     * Draw the last attack
     * @param g graphics object used to draw
     */
    private void drawAttack(Graphics g) {
        g.drawImage(lastAbilityUsed.getSprite(), 275, height-250, 100,100, null);
    }

    /**
     * Change to state game over if the player fails
     */
    private void gameover (){
        Utils.writeLog("Game Over");
        GameoverState gameoverState = new GameoverState(handler);
        gameoverState.initState();
        handler.getGame().setCurrentState(gameoverState);
    }

    /**
     * Open the hidden wall to the treasure when no more enemies
     */
    private void openTreasureRoom () {
        handler.getWorld().UNIVERSE[1][3]=handler.getWorld().WORLD13bis;
        Utils.writeLog("Treasure room open. You win");
    }

    /**
     * Player turn to attack enemy
     */
    private void playerAttack() {

        //select an action
        if(handler.getKeyManager().key1) {
            lastAbilityUsed = player.action1();
        } else if (handler.getKeyManager().key2) {
            lastAbilityUsed = player.action2();
        } else if (handler.getKeyManager().key3) {
            lastAbilityUsed = player.action3();
        } else {
            return;
        }

        //attack calculation
        int mpCost = lastAbilityUsed.getMpCost();
        int dmg = (int) (player.getDmg()*lastAbilityUsed.getDmg()*lastAbilityUsed.getAccuracy());
        player.setMp(player.getMp() - mpCost);
        enemy.setHp(enemy.getHp() - dmg);

        message = player.getName()+" used ability "+lastAbilityUsed.getName() + " Mp "+mpCost+" Dmg "+dmg;
        Utils.writeLog(message);
        playerTurn = false;
        if(enemy.getHp()<=0) {
            enemy.setActive(false);
            if (handler.getWorld().stillEnemiesAlive())
                openTreasureRoom();

            handler.getGame().setCurrentState( handler.getGame().getGameState());
        }

        //init enemy time to attack
        lastAttackTimer=System.currentTimeMillis();
        attackTimer = 0;
    }

    /**
     * Enemy turn to attack player
     */
    private void enemyAttack() {
        attackTimer += System.currentTimeMillis() - lastAttackTimer;
        lastAttackTimer = System.currentTimeMillis();

        if (attackTimer < attackCooldown)
            return;

        //select an action
        int randomAction = random.nextInt(2);
        if(randomAction == 0) {
            lastAbilityUsed = enemy.action1();
        } else if (randomAction == 1) {
            lastAbilityUsed = enemy.action2();
        } else if (randomAction == 2) {
            lastAbilityUsed = enemy.action3();
        }
        //attack calculation
        int mpCost = lastAbilityUsed.getMpCost();
        int dmg = (int) (enemy.getDmg()*lastAbilityUsed.getDmg()*lastAbilityUsed.getAccuracy());
        enemy.setMp(enemy.getMp() - mpCost);
        player.setHp(player.getHp() - dmg);

        message = enemy.getName()+" used ability "+lastAbilityUsed.getName() + " Mp "+mpCost+" Dmg "+dmg;
        Utils.writeLog(message);
        playerTurn = true;

        if(player.getHp()<=0)
            gameover();
    }

    /**
     * Draw a message to tell the keys to attack
     * @param g graphics objet used to draw
     */
    private void drawMessage(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Fixedsys", Font.PLAIN, 16));
        g.drawString(message, 25, height - 50);
    }
    //SETTERS and GETTERS

    /**
     * Set the enemy object participating in the battle
     * @param enemy entity object
     */
    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
}
