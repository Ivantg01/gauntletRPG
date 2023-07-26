package states;

import entities.Archer;
import entities.Knight;
import entities.Mage;
import gfx.Asset;
import handler.Handler;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * state when the menu is shown
 *
 * @author Iván Torrijos
 *
 */
public class MenuState extends State{

    private JFrame frame;

    private JRadioButton optionArcher, optionKnight, optionMage;
    private ImageIcon iconArcher = new ImageIcon(Asset.archer[0].getScaledInstance(64,64, Image.SCALE_SMOOTH));
    private ImageIcon iconKnight = new ImageIcon(Asset.knight[0].getScaledInstance(64,64, Image.SCALE_SMOOTH));
    private ImageIcon iconMage = new ImageIcon(Asset.mage[0].getScaledInstance(64,64, Image.SCALE_SMOOTH));

    /**
     * Creates the menu windows to select the playable character
     * Change to gameState when the play button is pressed
     * @param handler
     */
    public MenuState(Handler handler) {
        super(handler);
        frame = handler.getDisplay().getFrame();
    }

    /**
     * time process to make any process before drawing
     */
    @Override
    public void tick() {
    }

    /**
     * time process to draw anything needed
     */
    @Override
    public void render(Graphics g) {
    }

    /**
     * Init the menuState and display the menu to select the player
     */
    @Override
    public void initState() {
        JPanel panel = new JPanel();
        panel.setBounds(0,0,handler.getWidth(),handler.getHeight());
        panel.setLayout(null);

        JLabel l = new JLabel("Select a Character:");
        l.setBounds(210, 50, 380, 30);
        l.setFont(new Font("Serif", Font.BOLD, 24));
        panel.add(l);

        optionArcher = new JRadioButton("  Archer", true);
        optionArcher.setFont(new Font("Serif", Font.BOLD, 20));
        optionArcher.setFocusable(false);
        optionArcher.setBounds(250, 130, 150, 30);
        optionArcher.setSelected(true);
        optionKnight = new JRadioButton("  Knight     ");
        optionKnight.setFont(new Font("Serif", Font.BOLD, 20));
        optionKnight.setFocusable(false);
        optionKnight.setBounds(250, 180, 150, 30);
        optionMage = new JRadioButton("  Mage");
        optionMage.setFont(new Font("Serif", Font.BOLD, 20));
        optionMage.setFocusable(false);
        optionMage.setBounds(250, 230,150, 30);
        panel.add(optionArcher);
        panel.add(optionKnight);
        panel.add(optionMage);

        ButtonGroup group = new ButtonGroup();
        group.add(optionArcher);
        group.add(optionKnight);
        group.add(optionMage);

        JLabel playerImage = new JLabel();
        playerImage.setIcon(iconArcher);
        playerImage.setBounds(400, 170, 64, 64);
        panel.add(playerImage);
        optionArcher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerImage.setIcon(iconArcher);
            }
        });
        optionKnight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerImage.setIcon(iconKnight);
            }
        });
        optionMage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerImage.setIcon(iconMage);
            }
        });

        Object [] columns = {"Name","HP","Damage","MP","Speed"};
        Object [][] rows = {
                {Archer.DEFAULT_NAME, Archer.DEFAULT_HP, Archer.DEFAULT_DMG, Archer.DEFAULT_MP, Archer.DEFAULT_SPEED},
                {Knight.DEFAULT_NAME, Knight.DEFAULT_HP, Knight.DEFAULT_DMG, Knight.DEFAULT_MP, Knight.DEFAULT_SPEED},
                {Mage.DEFAULT_NAME, Mage.DEFAULT_HP, Mage.DEFAULT_DMG, Mage.DEFAULT_MP, Mage.DEFAULT_SPEED}};
        JTable table = new JTable(rows, columns);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(125, 310, 380, 71);
        panel.add(scroll);

        JButton button = new JButton(" Play ");
        button.setBounds(250, 420, 120, 25);
        button.setFont(new Font("Serif", Font.BOLD, 20));
        button.setFocusable(false);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                int selectedOption = 0;
                if (optionArcher.isSelected()) {
                    selectedOption = 0;
                } else if (optionKnight.isSelected()) {
                    selectedOption = 1;
                } else if (optionMage.isSelected()) {
                    selectedOption = 2;
                }
                Utils.writeLog("Player selection:"+selectedOption);
                handler.getGame().setPlayerSelected(selectedOption);
                handler.getGame().getDisplay().getCanvas().setVisible(true);
                handler.getGame().setCurrentState( handler.getGame().getGameState());
                handler.getGame().getCurrentState().initState();
            }
        });

        frame.add(panel);
        panel.repaint();
        frame.setVisible(true);
    }

}


