package gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * Class to read all sprites for map tiles and characters
 * Sprites from https://www.spriters-resource.com/pc_computer/R.html
 *
 * @author Iván Torrijos
 *
 */public class Asset {
private static final int width = 32, height = 32;

/**
 * The 12 sprites of the player archer
 */
public static BufferedImage[] archer = new BufferedImage[12];
/**
 * The 12 sprites of the player knight
 */
public static BufferedImage[] knight = new BufferedImage[12];
/**
 * The 12 sprites of the player mage
 */
public static BufferedImage[] mage = new BufferedImage[12];
/**
 * The 12 sprites of the enemy goblin
 */
public static BufferedImage[] goblin = new BufferedImage[12];
/**
 * The 12 sprites of the enemy skeleton
 */
public static BufferedImage[] skeleton = new BufferedImage[12];
/**
 * The 12 sprites of the enemy ghost
 */
public static BufferedImage[] ghost = new BufferedImage[12];

/**
 * The sprite of the different tiles
 */
public static BufferedImage grass, rock, dirt, water, dirtinGrass, rockinGrass;
/**
 * More sprites of the different tiles
 */
public static BufferedImage rockWall1, rockWall2, bush, brick, floorGold, treasure;
/**
 * Sprites of the background of the battles
 */
public static BufferedImage battle1, battle2, battle3;

/**
 * The types of attacks: one per player and enemy
 */
public static BufferedImage archerAttack, knightAttack, mageAttack, goblinAttack, skeletonAttack, ghostAttack;


/**
 * Function to load a image from the disk
 * @param path path and name of the file
 * @return the image
 */
public static BufferedImage loadImage (String path){
        try {
        return ImageIO.read(Objects.requireNonNull(Asset.class.getResource(path)));
        } catch (Exception e) {
        System.out.println("Cannot read image file:"+path);
        e.printStackTrace();
        System.exit(1);
        }
        return null;
        }

/**
 * Load all the assets: player sprites and pictures of the tiles
 */
public static void init() {
        BufferedImage sheet = Asset.loadImage("/textures/RPG Maker VX - Characters.png");
        int px, py;
        // Positions of the different sprintes 3x3
        // front1 front2 front3
        // left1  left3  left3
        // right1 right2 right3
        // back1  back2  back3

        //PLAYER 1,2,3
        px=774; py=130;
        archer[0] = sheet.getSubimage(px, py, width, height);             //player 0 front 1
        archer[1] = sheet.getSubimage(px+width, py, width, height);    //player 0 front 2
        archer[2] = sheet.getSubimage(px+width*2, py, width, height);  //player 0 front 3

        py+=height;
        archer[3] = sheet.getSubimage(px, py, width, height);             //player 0 left 1
        archer[4] = sheet.getSubimage(px+width, py, width, height);
        archer[5] = sheet.getSubimage(px+width*2, py, width, height);

        py+=height;
        archer[6] = sheet.getSubimage(px, py, width, height);             //player 0 right 1
        archer[7] = sheet.getSubimage(px+width, py, width, height);
        archer[8] = sheet.getSubimage(px+width*2, py, width, height);

        py+=height;
        archer[9] = sheet.getSubimage(px, py, width, height);             //player 0 back 1
        archer[10] = sheet.getSubimage(px+width, py, width, height);
        archer[11] = sheet.getSubimage(px+width*2, py, width, height);

        px=580; py=650;
        knight[0] = sheet.getSubimage(px, py, width, height);             //player 1 front 1
        knight[1] = sheet.getSubimage(px+width, py, width, height);    //player 1 front 2
        knight[2] = sheet.getSubimage(px+width*2, py, width, height);  //player 1 front 3

        py+=height;
        knight[3] = sheet.getSubimage(px, py, width, height);             //player 1 left 1
        knight[4] = sheet.getSubimage(px+width, py, width, height);
        knight[5] = sheet.getSubimage(px+width*2, py, width, height);

        py+=height;
        knight[6] = sheet.getSubimage(px, py, width, height);             //player 1 right 1
        knight[7] = sheet.getSubimage(px+width, py, width, height);
        knight[8] = sheet.getSubimage(px+width*2, py, width, height);

        py+=height;
        knight[9] = sheet.getSubimage(px, py, width, height);             //player 1 back 1
        knight[10] = sheet.getSubimage(px+width, py, width, height);
        knight[11] = sheet.getSubimage(px+width*2, py, width, height);

        px=486; py=390;
        mage[0] = sheet.getSubimage(px, py, width, height);             //player 2 front 1
        mage[1] = sheet.getSubimage(px+width, py, width, height);    //player 2 front 2
        mage[2] = sheet.getSubimage(px+width*2, py, width, height);  //player 2 front 3

        py+=height;
        mage[3] = sheet.getSubimage(px, py, width, height);             //player 2 left 1
        mage[4] = sheet.getSubimage(px+width, py, width, height);
        mage[5] = sheet.getSubimage(px+width*2, py, width, height);

        py+=height;
        mage[6] = sheet.getSubimage(px, py, width, height);             //player 2 right 1
        mage[7] = sheet.getSubimage(px+width, py, width, height);
        mage[8] = sheet.getSubimage(px+width*2, py, width, height);

        py+=height;
        mage[9] = sheet.getSubimage(px, py, width, height);             //player 2 back 1
        mage[10] = sheet.getSubimage(px+width, py, width, height);
        mage[11] = sheet.getSubimage(px+width*2, py, width, height);

        //ENEMY 1,2,3
        px=966; py=782;
        goblin[0] = sheet.getSubimage(px, py, width, height);             //enemy 0 front 1
        goblin[1] = sheet.getSubimage(px+width, py, width, height);    //enemy 0 front 2
        goblin[2] = sheet.getSubimage(px+width*2, py, width, height);  //enemy 0 front 3

        py+=height;
        goblin[3] = sheet.getSubimage(px, py, width, height);             //enemy 0 left 1
        goblin[4] = sheet.getSubimage(px+width, py, width, height);
        goblin[5] = sheet.getSubimage(px+width*2, py, width, height);

        py+=height;
        goblin[6] = sheet.getSubimage(px, py, width, height);             //enemy 0 right 1
        goblin[7] = sheet.getSubimage(px+width, py, width, height);
        goblin[8] = sheet.getSubimage(px+width*2, py, width, height);

        py+=height;
        goblin[9] = sheet.getSubimage(px, py, width, height);             //enemy 0 back 1
        goblin[10] = sheet.getSubimage(px+width, py, width, height);
        goblin[11] = sheet.getSubimage(px+width*2, py, width, height);

        px=870; py=782;
        skeleton[0] = sheet.getSubimage(px, py, width, height);             //enemy 1 front 1
        skeleton[1] = sheet.getSubimage(px+width, py, width, height);    //enemy 1 front 2
        skeleton[2] = sheet.getSubimage(px+width*2, py, width, height);  //enemy 1 front 3

        py+=height;
        skeleton[3] = sheet.getSubimage(px, py, width, height);             //enemy 1 left 1
        skeleton[4] = sheet.getSubimage(px+width, py, width, height);
        skeleton[5] = sheet.getSubimage(px+width*2, py, width, height);

        py+=height;
        skeleton[6] = sheet.getSubimage(px, py, width, height);             //enemy 1 right 1
        skeleton[7] = sheet.getSubimage(px+width, py, width, height);
        skeleton[8] = sheet.getSubimage(px+width*2, py, width, height);

        py+=height;
        skeleton[9] = sheet.getSubimage(px, py, width, height);             //enemy 1 back 1
        skeleton[10] = sheet.getSubimage(px+width, py, width, height);
        skeleton[11] = sheet.getSubimage(px+width*2, py, width, height);

        px=774; py=782;
        ghost[0] = sheet.getSubimage(px, py, width, height);             //enemy 2 front 1
        ghost[1] = sheet.getSubimage(px+width, py, width, height);    //enemy 2 front 2
        ghost[2] = sheet.getSubimage(px+width*2, py, width, height);  //enemy 2 front 3

        py+=height;
        ghost[3] = sheet.getSubimage(px, py, width, height);             //enemy 2 left 1
        ghost[4] = sheet.getSubimage(px+width, py, width, height);
        ghost[5] = sheet.getSubimage(px+width*2, py, width, height);

        py+=height;
        ghost[6] = sheet.getSubimage(px, py, width, height);             //enemy 2 right 1
        ghost[7] = sheet.getSubimage(px+width, py, width, height);
        ghost[8] = sheet.getSubimage(px+width*2, py, width, height);

        py+=height;
        ghost[9] = sheet.getSubimage(px, py, width, height);             //enemy 2 back 1
        ghost[10] = sheet.getSubimage(px+width, py, width, height);
        ghost[11] = sheet.getSubimage(px+width*2, py, width, height);
        sheet.flush();

        //TILES
        BufferedImage sheet2 = Asset.loadImage("/textures/RPG Maker VX - outside.png");
        grass = sheet2.getSubimage(516, 2, width, height);
        dirt = sheet2.getSubimage(516, 98, width, height);
        rock = sheet2.getSubimage(676, 2, width, height);
        water = sheet2.getSubimage(740, 582, width, height);
        dirtinGrass = sheet2.getSubimage(580, 2, width, height);
        rockinGrass = sheet2.getSubimage(644, 2, width, height);
        rockWall1 = sheet2.getSubimage(258, 582, width, height);
        rockWall2 = sheet2.getSubimage(518, 646, width, height);
        bush = sheet2.getSubimage(386, 422, width, height);
        brick = sheet2.getSubimage(2, 422, width, height);
        floorGold = sheet2.getSubimage(644, 646, width, height);
        treasure = sheet2.getSubimage(708, 646, width, height);
        sheet2.flush();

        //BATTLE BACKGROUNDS
        battle1 = Asset.loadImage("/backgrounds/battle1.jpg");
        battle2 = Asset.loadImage("/backgrounds/battle2.jpg");
        battle3 = Asset.loadImage("/backgrounds/battle3.jpg");

        //ATTACKS
        BufferedImage sheet3;
        sheet3 = Asset.loadImage("/attacks/RPG Maker VX - attack 0.png"); //archer
        archerAttack = sheet3.getSubimage(810, 50, 100, 100);
        sheet3 = Asset.loadImage("/attacks/RPG Maker VX - attack 1.png"); //knight
        knightAttack = sheet3.getSubimage(755, 95, 100, 100);
        sheet3 = Asset.loadImage("/attacks/RPG Maker VX - attack 2.png"); //mage
        mageAttack = sheet3.getSubimage(430, 238, 100, 100);
        sheet3 = Asset.loadImage("/attacks/RPG Maker VX - attack 3.png"); //goblin
        goblinAttack = sheet3.getSubimage(227, 47, 100, 100);
        sheet3 = Asset.loadImage("/attacks/RPG Maker VX - attack 4.png"); //skeleton
        skeletonAttack = sheet3.getSubimage(770, 65, 100, 100);
        sheet3 = Asset.loadImage("/attacks/RPG Maker VX - attack 5.png"); //ghost
        ghostAttack = sheet3.getSubimage(623, 47, 100, 100);
        sheet3.flush();
        }

 }

