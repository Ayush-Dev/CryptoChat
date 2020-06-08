/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectFrames;

import ProjectDAO.FeedbackDAO;
import ProjectDAO.FriendDAO;
import ProjectDAO.MessageDAO;
import ProjectDAO.UserDAO;
import ProjectPojo.FeedbackPojo;
import ProjectPojo.FriendPojo;
import ProjectPojo.MessagePojo;
import ProjectPojo.UserPojo;
import ProjectPojo.testMessagePojo;
import ProjectSecurity.KeyExchange;
import ProjectSecurity.Security;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.MouseEvent;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import keeptoo.Drag;
import keeptoo.KButton;

/**
 *
 * @author Ayush's HP
 */
public class ChatApplication extends javax.swing.JFrame {

    public static String USERNAME;
    private int startY = 10;
    private static final int OFFLINE = 0;
    private ArrayList<Integer> sharedKey = null;
    testMessagePojo result = null;
    JPanel jPanelPendingRequest = null;
    static int flag = 0;

    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    SyncMessage messageSync = new SyncMessage();
    Thread messageSyncThread = new Thread(messageSync);
    Thread sharedKeyThread = new Thread(new SharedKeyGen());

    /**
     * Creates new form ChatApplication
     */
    public ChatApplication() {
        initComponents();
        USERNAME = UserPojo.getUserName();
        jLabelUSERNAME.setText(USERNAME);
        makeVisibleFalse();
        setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jTextFieldFriendSearch.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jTextFieldFriendSearch.setForeground(new Color(185, 185, 185));
        jTextFieldFriendSearch.setText("Search Friends");
        jButtonFriendSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jTextFieldChatSearch.setFont(new java.awt.Font("Segoe UI", 0, 24));
        jTextFieldChatSearch.setForeground(new Color(185, 185, 185));
        jTextFieldChatSearch.setText("Search");
        jComboBoxItems.setForeground(Color.WHITE);
        jTextAreaFeedback.setForeground(new Color(185,185,185));
        jTextAreaFeedback.setText("Describe the issue you've encountered");
        jButtonChatSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButtonSendMessage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButtonLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jLabelChatSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jScrollPaneMessage.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPaneMessage.getVerticalScrollBar().addAdjustmentListener((AdjustmentEvent ae) -> {
            if (kGradientPanelFriendSearch1 != null) {
                kGradientPanelFriendSearch1.repaint();
            }
        });
        jScrollPaneFriendsList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPaneFriendsList.getVerticalScrollBar().addAdjustmentListener((AdjustmentEvent ae) -> {
            if (kGradientPanelFriends != null) {
                kGradientPanelFriends.repaint();
            }
        });
        jScrollPanePendingFriendsList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPanePendingFriendsList.getVerticalScrollBar().addAdjustmentListener((AdjustmentEvent ae) -> {
            if (kGradientPanelPendingRequest != null) {
                kGradientPanelPendingRequest.repaint();
            }
        });
        jPanelMessages.setVisible(true);
        jPanelFriends.setVisible(false);
        jPanelSettings.setVisible(false);
        jPanelHelp.setVisible(false);
        jPanelHidden.setVisible(false);
        jPanelApplicationBoard.repaint();
        showFriends();
        kButtonFriend.setVisible(false);
        jLabelChatSearch.setVisible(false);
        jLabelChatStatus.setVisible(false);
        jPanelMessage.setAutoscrolls(false);
        jLabelMessage.setVisible(false);
        jButtonSendMessage.setVisible(false);
        jScrollPane1.getViewport().setOpaque(false);
        jRadioButtonIssues.setSelected(true);
        jTextFieldMessage.setEnabled(false);
        jTextFieldHidden.requestFocus();
        jLabelChatUsername.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelLogo = new javax.swing.JPanel();
        jLabelLogoDark = new javax.swing.JLabel();
        jPanelControlBoard = new javax.swing.JPanel();
        jButtonLogout = new javax.swing.JLabel();
        jLabelUSERNAME = new javax.swing.JLabel();
        jPanelNavigationBoard = new javax.swing.JPanel();
        rSButtonIconFriends = new rojerusan.RSButtonIconD();
        jPanelfriends = new javax.swing.JPanel();
        rSButtonIconMessages = new rojerusan.RSButtonIconD();
        jPanelmessages = new javax.swing.JPanel();
        rSButtonIconSettings = new rojerusan.RSButtonIconD();
        jPanelsettings = new javax.swing.JPanel();
        rSButtonIconHelp = new rojerusan.RSButtonIconD();
        jPanelhelp = new javax.swing.JPanel();
        jPanelApplicationBoard = new javax.swing.JPanel();
        jPanelMessages = new javax.swing.JPanel();
        kGradientPanelFriendSearch1 = new keeptoo.KGradientPanel();
        jButtonSendMessage = new javax.swing.JLabel();
        jTextFieldMessage = new javax.swing.JTextField();
        jLabelMessage = new javax.swing.JLabel();
        jScrollPaneMessage = new javax.swing.JScrollPane();
        jPanelMessage = new javax.swing.JPanel();
        jLabelChatUsername = new javax.swing.JLabel();
        jLabelChatStatus = new javax.swing.JLabel();
        kGradientPanelFriends = new keeptoo.KGradientPanel();
        jTextFieldHidden = new javax.swing.JTextField();
        jTextFieldChatSearch = new javax.swing.JTextField();
        jButtonChatSearch = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelChatSearch = new javax.swing.JLabel();
        jScrollPaneFriendsList = new javax.swing.JScrollPane();
        jPanelFriendList = new javax.swing.JPanel();
        jPanelFriends = new javax.swing.JPanel();
        kGradientPanelFriendSearch = new keeptoo.KGradientPanel();
        jTextFieldFriendSearch = new javax.swing.JTextField();
        jButtonFriendSearch = new javax.swing.JLabel();
        jLabelSearchBar = new javax.swing.JLabel();
        kButtonFriend = new keeptoo.KButton();
        jLabelFriendUsername = new javax.swing.JLabel();
        jLabelFriendFullName = new javax.swing.JLabel();
        jLabelFriendFullNameValue = new javax.swing.JLabel();
        jLabelFriendEmail = new javax.swing.JLabel();
        jLabelFriendEmailValue = new javax.swing.JLabel();
        jLabelFriendStatus = new javax.swing.JLabel();
        jLabelFriendStatusValue = new javax.swing.JLabel();
        kGradientPanelPendingRequest = new keeptoo.KGradientPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPanePendingFriendsList = new javax.swing.JScrollPane();
        jPanelPendingFriendList = new javax.swing.JPanel();
        jPanelSettings = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPasswordFieldOldPassword = new javax.swing.JPasswordField();
        jPasswordFieldNewPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPasswordFieldConfirmPassword = new javax.swing.JPasswordField();
        kButtonChangePassword = new keeptoo.KButton();
        jPanelHelp = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jRadioButtonIssues = new javax.swing.JRadioButton();
        jRadioButtonFeedback = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaFeedback = new javax.swing.JTextArea();
        jComboBoxItems = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        kButtonSubmitReport = new keeptoo.KButton();
        jPanelHidden = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanelLogo.setBackground(new java.awt.Color(45, 45, 45));

        jLabelLogoDark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectGraphics/DarkLogo_Small.png"))); // NOI18N
        jLabelLogoDark.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabelLogoDarkMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout jPanelLogoLayout = new javax.swing.GroupLayout(jPanelLogo);
        jPanelLogo.setLayout(jPanelLogoLayout);
        jPanelLogoLayout.setHorizontalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLogoDark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelLogoLayout.setVerticalGroup(
            jPanelLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLogoDark, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelControlBoard.setBackground(new java.awt.Color(45, 45, 45));

        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectGraphics/logoutLogo.png"))); // NOI18N
        jButtonLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLogoutMouseClicked(evt);
            }
        });

        jLabelUSERNAME.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabelUSERNAME.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUSERNAME.setText("dynamicText");

        javax.swing.GroupLayout jPanelControlBoardLayout = new javax.swing.GroupLayout(jPanelControlBoard);
        jPanelControlBoard.setLayout(jPanelControlBoardLayout);
        jPanelControlBoardLayout.setHorizontalGroup(
            jPanelControlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelControlBoardLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabelUSERNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLogout))
        );
        jPanelControlBoardLayout.setVerticalGroup(
            jPanelControlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelControlBoardLayout.createSequentialGroup()
                .addGroup(jPanelControlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelControlBoardLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelUSERNAME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButtonLogout))
                .addGap(0, 25, Short.MAX_VALUE))
        );

        jPanelNavigationBoard.setBackground(new java.awt.Color(45, 45, 45));

        rSButtonIconFriends.setBackground(new java.awt.Color(45, 45, 45));
        rSButtonIconFriends.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectGraphics/friendsLogo.png"))); // NOI18N
        rSButtonIconFriends.setText("Friends");
        rSButtonIconFriends.setColorHover(new java.awt.Color(54, 54, 54));
        rSButtonIconFriends.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        rSButtonIconFriends.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonIconFriendsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSButtonIconFriendsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSButtonIconFriendsMouseExited(evt);
            }
        });
        rSButtonIconFriends.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconFriendsActionPerformed(evt);
            }
        });

        jPanelfriends.setBackground(new java.awt.Color(45, 45, 45));

        javax.swing.GroupLayout jPanelfriendsLayout = new javax.swing.GroupLayout(jPanelfriends);
        jPanelfriends.setLayout(jPanelfriendsLayout);
        jPanelfriendsLayout.setHorizontalGroup(
            jPanelfriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanelfriendsLayout.setVerticalGroup(
            jPanelfriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        rSButtonIconMessages.setBackground(new java.awt.Color(45, 45, 45));
        rSButtonIconMessages.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectGraphics/messagesLogo.png"))); // NOI18N
        rSButtonIconMessages.setText("Messages");
        rSButtonIconMessages.setColorHover(new java.awt.Color(54, 54, 54));
        rSButtonIconMessages.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        rSButtonIconMessages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonIconMessagesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSButtonIconMessagesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSButtonIconMessagesMouseExited(evt);
            }
        });
        rSButtonIconMessages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconMessagesActionPerformed(evt);
            }
        });

        jPanelmessages.setBackground(new java.awt.Color(0, 113, 188));

        javax.swing.GroupLayout jPanelmessagesLayout = new javax.swing.GroupLayout(jPanelmessages);
        jPanelmessages.setLayout(jPanelmessagesLayout);
        jPanelmessagesLayout.setHorizontalGroup(
            jPanelmessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanelmessagesLayout.setVerticalGroup(
            jPanelmessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        rSButtonIconSettings.setBackground(new java.awt.Color(45, 45, 45));
        rSButtonIconSettings.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectGraphics/setingsLogo.png"))); // NOI18N
        rSButtonIconSettings.setText("Settings");
        rSButtonIconSettings.setColorHover(new java.awt.Color(54, 54, 54));
        rSButtonIconSettings.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        rSButtonIconSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonIconSettingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSButtonIconSettingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSButtonIconSettingsMouseExited(evt);
            }
        });
        rSButtonIconSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconSettingsActionPerformed(evt);
            }
        });

        jPanelsettings.setBackground(new java.awt.Color(45, 45, 45));

        javax.swing.GroupLayout jPanelsettingsLayout = new javax.swing.GroupLayout(jPanelsettings);
        jPanelsettings.setLayout(jPanelsettingsLayout);
        jPanelsettingsLayout.setHorizontalGroup(
            jPanelsettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanelsettingsLayout.setVerticalGroup(
            jPanelsettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        rSButtonIconHelp.setBackground(new java.awt.Color(45, 45, 45));
        rSButtonIconHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectGraphics/helpLogo.png"))); // NOI18N
        rSButtonIconHelp.setText("Help");
        rSButtonIconHelp.setColorHover(new java.awt.Color(54, 54, 54));
        rSButtonIconHelp.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        rSButtonIconHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSButtonIconHelpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSButtonIconHelpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSButtonIconHelpMouseExited(evt);
            }
        });
        rSButtonIconHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonIconHelpActionPerformed(evt);
            }
        });

        jPanelhelp.setBackground(new java.awt.Color(45, 45, 45));

        javax.swing.GroupLayout jPanelhelpLayout = new javax.swing.GroupLayout(jPanelhelp);
        jPanelhelp.setLayout(jPanelhelpLayout);
        jPanelhelpLayout.setHorizontalGroup(
            jPanelhelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanelhelpLayout.setVerticalGroup(
            jPanelhelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelNavigationBoardLayout = new javax.swing.GroupLayout(jPanelNavigationBoard);
        jPanelNavigationBoard.setLayout(jPanelNavigationBoardLayout);
        jPanelNavigationBoardLayout.setHorizontalGroup(
            jPanelNavigationBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNavigationBoardLayout.createSequentialGroup()
                .addComponent(jPanelsettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rSButtonIconSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelNavigationBoardLayout.createSequentialGroup()
                .addComponent(jPanelhelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rSButtonIconHelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelNavigationBoardLayout.createSequentialGroup()
                .addComponent(jPanelmessages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rSButtonIconMessages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelNavigationBoardLayout.createSequentialGroup()
                .addComponent(jPanelfriends, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rSButtonIconFriends, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNavigationBoardLayout.setVerticalGroup(
            jPanelNavigationBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNavigationBoardLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanelNavigationBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelmessages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonIconMessages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelNavigationBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelfriends, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonIconFriends, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelNavigationBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelsettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonIconSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelNavigationBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelhelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSButtonIconHelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(321, Short.MAX_VALUE))
        );

        jPanelApplicationBoard.setBackground(new java.awt.Color(255, 0, 0));
        jPanelApplicationBoard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanelFriendSearch1.setkBorderRadius(20);
        kGradientPanelFriendSearch1.setkEndColor(new java.awt.Color(0, 113, 188));
        kGradientPanelFriendSearch1.setkGradientFocus(1000);
        kGradientPanelFriendSearch1.setkStartColor(new java.awt.Color(153, 0, 51));
        kGradientPanelFriendSearch1.setkTransparentControls(false);
        kGradientPanelFriendSearch1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanelFriendSearch1MouseClicked(evt);
            }
        });
        kGradientPanelFriendSearch1.setLayout(null);

        jButtonSendMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jButtonSendMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectGraphics/SendLogoSmall.png"))); // NOI18N
        jButtonSendMessage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSendMessageMouseClicked(evt);
            }
        });
        kGradientPanelFriendSearch1.add(jButtonSendMessage);
        jButtonSendMessage.setBounds(360, 550, 50, 60);

        jTextFieldMessage.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jTextFieldMessage.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jTextFieldMessage.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jTextFieldMessage.setOpaque(false);
        jTextFieldMessage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldMessageKeyPressed(evt);
            }
        });
        kGradientPanelFriendSearch1.add(jTextFieldMessage);
        jTextFieldMessage.setBounds(40, 550, 300, 60);

        jLabelMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectGraphics/MessageFieldMedium.png"))); // NOI18N
        kGradientPanelFriendSearch1.add(jLabelMessage);
        jLabelMessage.setBounds(30, 540, 320, 80);

        jScrollPaneMessage.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jScrollPaneMessage.setBorder(null);
        jScrollPaneMessage.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        jPanelMessage.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jPanelMessage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPaneMessage.setViewportView(jPanelMessage);

        kGradientPanelFriendSearch1.add(jScrollPaneMessage);
        jScrollPaneMessage.setBounds(10, 90, 400, 440);

        jLabelChatUsername.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelChatUsername.setForeground(new java.awt.Color(255, 255, 255));
        jLabelChatUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelChatUsername.setText("dynamicUSERNAME");
        kGradientPanelFriendSearch1.add(jLabelChatUsername);
        jLabelChatUsername.setBounds(40, 10, 330, 50);

        jLabelChatStatus.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabelChatStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelChatStatus.setText("dynamicStatus");
        kGradientPanelFriendSearch1.add(jLabelChatStatus);
        jLabelChatStatus.setBounds(10, 60, 140, 20);

        kGradientPanelFriends.setkBorderRadius(20);
        kGradientPanelFriends.setkEndColor(new java.awt.Color(0, 113, 188));
        kGradientPanelFriends.setkStartColor(new java.awt.Color(153, 0, 51));
        kGradientPanelFriends.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        kGradientPanelFriends.add(jTextFieldHidden, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 580, 0, 10));

        jTextFieldChatSearch.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jTextFieldChatSearch.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jTextFieldChatSearch.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldChatSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jTextFieldChatSearch.setOpaque(false);
        jTextFieldChatSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldChatSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldChatSearchFocusLost(evt);
            }
        });
        jTextFieldChatSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldChatSearchKeyPressed(evt);
            }
        });
        kGradientPanelFriends.add(jTextFieldChatSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 220, 40));

        jButtonChatSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonChatSearchMouseClicked(evt);
            }
        });
        kGradientPanelFriends.add(jButtonChatSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 40, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectGraphics/SearchBarSmall.png"))); // NOI18N
        kGradientPanelFriends.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 280, 60));

        jLabelChatSearch.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelChatSearch.setForeground(new java.awt.Color(255, 255, 255));
        jLabelChatSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelChatSearch.setText("dynamicLabel");
        jLabelChatSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelChatSearchMouseClicked(evt);
            }
        });
        kGradientPanelFriends.add(jLabelChatSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 330, 50));

        jScrollPaneFriendsList.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jScrollPaneFriendsList.setBorder(null);
        jScrollPaneFriendsList.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        jPanelFriendList.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jPanelFriendList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPaneFriendsList.setViewportView(jPanelFriendList);

        kGradientPanelFriends.add(jScrollPaneFriendsList, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 360, 420));

        javax.swing.GroupLayout jPanelMessagesLayout = new javax.swing.GroupLayout(jPanelMessages);
        jPanelMessages.setLayout(jPanelMessagesLayout);
        jPanelMessagesLayout.setHorizontalGroup(
            jPanelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMessagesLayout.createSequentialGroup()
                .addComponent(kGradientPanelFriendSearch1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanelFriends, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelMessagesLayout.setVerticalGroup(
            jPanelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMessagesLayout.createSequentialGroup()
                .addGroup(jPanelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(kGradientPanelFriends, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addComponent(kGradientPanelFriendSearch1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelApplicationBoard.add(jPanelMessages, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 817, 630));

        jPanelFriends.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f)
        );

        kGradientPanelFriendSearch.setkBorderRadius(20);
        kGradientPanelFriendSearch.setkEndColor(new java.awt.Color(0, 113, 188));
        kGradientPanelFriendSearch.setkGradientFocus(1000);
        kGradientPanelFriendSearch.setkStartColor(new java.awt.Color(153, 0, 51));
        kGradientPanelFriendSearch.setkTransparentControls(false);
        kGradientPanelFriendSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanelFriendSearchMouseClicked(evt);
            }
        });
        kGradientPanelFriendSearch.setLayout(null);

        jTextFieldFriendSearch.setBackground(new java.awt.Color(0, 0, 0, 1));
        jTextFieldFriendSearch.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jTextFieldFriendSearch.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldFriendSearch.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jTextFieldFriendSearch.setOpaque(false);
        jTextFieldFriendSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldFriendSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldFriendSearchFocusLost(evt);
            }
        });
        jTextFieldFriendSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldFriendSearchKeyPressed(evt);
            }
        });
        kGradientPanelFriendSearch.add(jTextFieldFriendSearch);
        jTextFieldFriendSearch.setBounds(40, 10, 210, 50);

        jButtonFriendSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonFriendSearchMouseClicked(evt);
            }
        });
        kGradientPanelFriendSearch.add(jButtonFriendSearch);
        jButtonFriendSearch.setBounds(250, 20, 40, 30);

        jLabelSearchBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProjectGraphics/SearchBarSmall.png"))); // NOI18N
        kGradientPanelFriendSearch.add(jLabelSearchBar);
        jLabelSearchBar.setBounds(20, 10, 280, 50);

        kButtonFriend.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        kButtonFriend.setText("dynamicText");
        kButtonFriend.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kButtonFriend.setkBorderRadius(40);
        kButtonFriend.setkEndColor(new java.awt.Color(153, 0, 51));
        kButtonFriend.setkHoverEndColor(new java.awt.Color(0, 113, 188));
        kButtonFriend.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButtonFriend.setkHoverStartColor(new java.awt.Color(153, 0, 51));
        kButtonFriend.setkSelectedColor(new java.awt.Color(153, 0, 53));
        kButtonFriend.setkStartColor(new java.awt.Color(0, 113, 188));
        kButtonFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButtonFriendActionPerformed(evt);
            }
        });
        kGradientPanelFriendSearch.add(kButtonFriend);
        kButtonFriend.setBounds(30, 410, 185, 45);

        jLabelFriendUsername.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelFriendUsername.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFriendUsername.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFriendUsername.setText("Username");
        kGradientPanelFriendSearch.add(jLabelFriendUsername);
        jLabelFriendUsername.setBounds(80, 80, 151, 32);

        jLabelFriendFullName.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabelFriendFullName.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFriendFullName.setText("Full Name");
        kGradientPanelFriendSearch.add(jLabelFriendFullName);
        jLabelFriendFullName.setBounds(30, 150, 106, 25);

        jLabelFriendFullNameValue.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabelFriendFullNameValue.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanelFriendSearch.add(jLabelFriendFullNameValue);
        jLabelFriendFullNameValue.setBounds(30, 200, 280, 32);

        jLabelFriendEmail.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabelFriendEmail.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFriendEmail.setText("Email");
        kGradientPanelFriendSearch.add(jLabelFriendEmail);
        jLabelFriendEmail.setBounds(30, 250, 106, 25);

        jLabelFriendEmailValue.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabelFriendEmailValue.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanelFriendSearch.add(jLabelFriendEmailValue);
        jLabelFriendEmailValue.setBounds(30, 290, 280, 32);

        jLabelFriendStatus.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabelFriendStatus.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFriendStatus.setText("Status:");
        kGradientPanelFriendSearch.add(jLabelFriendStatus);
        jLabelFriendStatus.setBounds(30, 340, 73, 25);

        jLabelFriendStatusValue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelFriendStatusValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kGradientPanelFriendSearch.add(jLabelFriendStatusValue);
        jLabelFriendStatusValue.setBounds(120, 340, 120, 30);

        kGradientPanelPendingRequest.setkBorderRadius(20);
        kGradientPanelPendingRequest.setkEndColor(new java.awt.Color(0, 113, 188));
        kGradientPanelPendingRequest.setkStartColor(new java.awt.Color(153, 0, 51));
        kGradientPanelPendingRequest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pending Requests");
        kGradientPanelPendingRequest.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 259, 34));

        jScrollPanePendingFriendsList.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jScrollPanePendingFriendsList.setBorder(null);
        jScrollPanePendingFriendsList.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        jPanelPendingFriendList.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jPanelPendingFriendList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPanePendingFriendsList.setViewportView(jPanelPendingFriendList);

        kGradientPanelPendingRequest.add(jScrollPanePendingFriendsList, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 460, 520));

        javax.swing.GroupLayout jPanelFriendsLayout = new javax.swing.GroupLayout(jPanelFriends);
        jPanelFriends.setLayout(jPanelFriendsLayout);
        jPanelFriendsLayout.setHorizontalGroup(
            jPanelFriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFriendsLayout.createSequentialGroup()
                .addComponent(kGradientPanelFriendSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kGradientPanelPendingRequest, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
        );
        jPanelFriendsLayout.setVerticalGroup(
            jPanelFriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFriendsLayout.createSequentialGroup()
                .addGroup(jPanelFriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(kGradientPanelPendingRequest, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                    .addComponent(kGradientPanelFriendSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelApplicationBoard.add(jPanelFriends, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 817, 630));

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 113, 188));
        kGradientPanel1.setkGradientFocus(1000);
        kGradientPanel1.setkStartColor(new java.awt.Color(153, 0, 51));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Change Password");

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Old Password");

        jPasswordFieldOldPassword.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jPasswordFieldOldPassword.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jPasswordFieldOldPassword.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordFieldOldPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPasswordFieldOldPassword.setOpaque(false);
        jPasswordFieldOldPassword.setEchoChar('\u25CF');

        jPasswordFieldNewPassword.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jPasswordFieldNewPassword.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jPasswordFieldNewPassword.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordFieldNewPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPasswordFieldNewPassword.setOpaque(false);
        jPasswordFieldNewPassword.setEchoChar('\u25CF');

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New Password");

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirm Password");

        jPasswordFieldConfirmPassword.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jPasswordFieldConfirmPassword.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jPasswordFieldConfirmPassword.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordFieldConfirmPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPasswordFieldConfirmPassword.setOpaque(false);
        jPasswordFieldConfirmPassword.setEchoChar('\u25CF');
        jPasswordFieldConfirmPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldConfirmPasswordKeyReleased(evt);
            }
        });

        kButtonChangePassword.setText("Change");
        kButtonChangePassword.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kButtonChangePassword.setkBorderRadius(40);
        kButtonChangePassword.setkEndColor(new java.awt.Color(153, 0, 51));
        kButtonChangePassword.setkHoverEndColor(new java.awt.Color(0, 113, 188));
        kButtonChangePassword.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButtonChangePassword.setkHoverStartColor(new java.awt.Color(153, 0, 51));
        kButtonChangePassword.setkSelectedColor(new java.awt.Color(153, 0, 53));
        kButtonChangePassword.setkStartColor(new java.awt.Color(0, 113, 188));
        kButtonChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButtonChangePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kButtonChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPasswordFieldOldPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPasswordFieldNewPassword, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPasswordFieldConfirmPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(565, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPasswordFieldOldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jPasswordFieldNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jPasswordFieldConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(kButtonChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelSettingsLayout = new javax.swing.GroupLayout(jPanelSettings);
        jPanelSettings.setLayout(jPanelSettingsLayout);
        jPanelSettingsLayout.setHorizontalGroup(
            jPanelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );
        jPanelSettingsLayout.setVerticalGroup(
            jPanelSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSettingsLayout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelApplicationBoard.add(jPanelSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 817, 630));

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 113, 188));
        kGradientPanel2.setkGradientFocus(1000);
        kGradientPanel2.setkStartColor(new java.awt.Color(153, 0, 51));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Help & Support");

        jRadioButtonIssues.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        buttonGroup1.add(jRadioButtonIssues);
        jRadioButtonIssues.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jRadioButtonIssues.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonIssues.setText("Issues");
        jRadioButtonIssues.setOpaque(false);
        jRadioButtonIssues.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonIssuesMouseClicked(evt);
            }
        });

        jRadioButtonFeedback.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        buttonGroup1.add(jRadioButtonFeedback);
        jRadioButtonFeedback.setFont(new java.awt.Font("Segoe UI Light", 1, 24)); // NOI18N
        jRadioButtonFeedback.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButtonFeedback.setText("Feedback");
        jRadioButtonFeedback.setOpaque(false);
        jRadioButtonFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonFeedbackMouseClicked(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jScrollPane1.setOpaque(false);

        jTextAreaFeedback.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jTextAreaFeedback.setColumns(20);
        jTextAreaFeedback.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jTextAreaFeedback.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaFeedback.setLineWrap(true);
        jTextAreaFeedback.setRows(5);
        jTextAreaFeedback.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(240, 240, 240)));
        jTextAreaFeedback.setMargin(new java.awt.Insets(200, 200, 200, 200));
        jTextAreaFeedback.setOpaque(false);
        jTextAreaFeedback.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextAreaFeedbackFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaFeedback);

        jComboBoxItems.setBackground(new java.awt.Color(0.0f, 0.0f, 0.0f, 0.0f));
        jComboBoxItems.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jComboBoxItems.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxItems.setMaximumRowCount(4);
        jComboBoxItems.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Login", "Registration", "Friend Request", "Friend Search", "Messaging" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Select Items");

        kButtonSubmitReport.setText("Submit Report");
        kButtonSubmitReport.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        kButtonSubmitReport.setkBorderRadius(40);
        kButtonSubmitReport.setkEndColor(new java.awt.Color(153, 0, 51));
        kButtonSubmitReport.setkHoverEndColor(new java.awt.Color(0, 113, 188));
        kButtonSubmitReport.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButtonSubmitReport.setkHoverStartColor(new java.awt.Color(153, 0, 51));
        kButtonSubmitReport.setkSelectedColor(new java.awt.Color(153, 0, 53));
        kButtonSubmitReport.setkStartColor(new java.awt.Color(0, 113, 188));
        kButtonSubmitReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButtonSubmitReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kButtonSubmitReport, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                                .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addComponent(jRadioButtonIssues, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(jRadioButtonFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonIssues, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButtonFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(kButtonSubmitReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelHelpLayout = new javax.swing.GroupLayout(jPanelHelp);
        jPanelHelp.setLayout(jPanelHelpLayout);
        jPanelHelpLayout.setHorizontalGroup(
            jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );
        jPanelHelpLayout.setVerticalGroup(
            jPanelHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHelpLayout.createSequentialGroup()
                .addComponent(kGradientPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelApplicationBoard.add(jPanelHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 817, 630));

        jLabel9.setText("home");

        javax.swing.GroupLayout jPanelHiddenLayout = new javax.swing.GroupLayout(jPanelHidden);
        jPanelHidden.setLayout(jPanelHiddenLayout);
        jPanelHiddenLayout.setHorizontalGroup(
            jPanelHiddenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHiddenLayout.createSequentialGroup()
                .addGap(0, 785, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );
        jPanelHiddenLayout.setVerticalGroup(
            jPanelHiddenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHiddenLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 614, Short.MAX_VALUE))
        );

        jPanelApplicationBoard.add(jPanelHidden, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 817, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelNavigationBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelApplicationBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelControlBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanelControlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelApplicationBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanelNavigationBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonIconFriendsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonIconFriendsMouseEntered
        if (!jPanelfriends.getBackground().equals(new Color(0, 113, 188))) {
            jPanelfriends.setBackground(new Color(54, 54, 54));
        }
    }//GEN-LAST:event_rSButtonIconFriendsMouseEntered

    private void rSButtonIconMessagesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonIconMessagesMouseEntered
        if (!jPanelmessages.getBackground().equals(new Color(0, 113, 188))) {
            jPanelmessages.setBackground(new Color(54, 54, 54));
        }
    }//GEN-LAST:event_rSButtonIconMessagesMouseEntered

    private void rSButtonIconSettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonIconSettingsMouseEntered
        if (!jPanelsettings.getBackground().equals(new Color(0, 113, 188))) {
            jPanelsettings.setBackground(new Color(54, 54, 54));
        }
    }//GEN-LAST:event_rSButtonIconSettingsMouseEntered

    private void rSButtonIconHelpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonIconHelpMouseEntered
        if (!jPanelhelp.getBackground().equals(new Color(0, 113, 188))) {
            jPanelhelp.setBackground(new Color(54, 54, 54));
        }
    }//GEN-LAST:event_rSButtonIconHelpMouseEntered

    private void rSButtonIconFriendsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonIconFriendsMouseExited
        if (!jPanelfriends.getBackground().equals(new Color(0, 113, 188))) {
            jPanelfriends.setBackground(new Color(45, 45, 45));
        }
    }//GEN-LAST:event_rSButtonIconFriendsMouseExited

    private void rSButtonIconMessagesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonIconMessagesMouseExited
        if (!jPanelmessages.getBackground().equals(new Color(0, 113, 188))) {
            jPanelmessages.setBackground(new Color(45, 45, 45));
        }
    }//GEN-LAST:event_rSButtonIconMessagesMouseExited

    private void rSButtonIconSettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonIconSettingsMouseExited
        if (!jPanelsettings.getBackground().equals(new Color(0, 113, 188))) {
            jPanelsettings.setBackground(new Color(45, 45, 45));
        }
    }//GEN-LAST:event_rSButtonIconSettingsMouseExited

    private void rSButtonIconHelpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonIconHelpMouseExited
        if (!jPanelhelp.getBackground().equals(new Color(0, 113, 188))) {
            jPanelhelp.setBackground(new Color(45, 45, 45));
        }
    }//GEN-LAST:event_rSButtonIconHelpMouseExited

    private void rSButtonIconFriendsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonIconFriendsMouseClicked
        jPanelfriends.setBackground(new Color(0, 113, 188));
        jPanelmessages.setBackground(new Color(45, 45, 45));
        jPanelsettings.setBackground(new Color(45, 45, 45));
        jPanelhelp.setBackground(new Color(45, 45, 45));
    }//GEN-LAST:event_rSButtonIconFriendsMouseClicked

    private void rSButtonIconMessagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonIconMessagesMouseClicked
        jPanelfriends.setBackground(new Color(45, 45, 45));
        jPanelmessages.setBackground(new Color(0, 113, 188));
        jPanelsettings.setBackground(new Color(45, 45, 45));
        jPanelhelp.setBackground(new Color(45, 45, 45));
    }//GEN-LAST:event_rSButtonIconMessagesMouseClicked

    private void rSButtonIconSettingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonIconSettingsMouseClicked
        jPanelfriends.setBackground(new Color(45, 45, 45));
        jPanelmessages.setBackground(new Color(45, 45, 45));
        jPanelsettings.setBackground(new Color(0, 113, 188));
        jPanelhelp.setBackground(new Color(45, 45, 45));
    }//GEN-LAST:event_rSButtonIconSettingsMouseClicked

    private void rSButtonIconHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonIconHelpMouseClicked
        jPanelfriends.setBackground(new Color(45, 45, 45));
        jPanelmessages.setBackground(new Color(45, 45, 45));
        jPanelsettings.setBackground(new Color(45, 45, 45));
        jPanelhelp.setBackground(new Color(0, 113, 188));
    }//GEN-LAST:event_rSButtonIconHelpMouseClicked

    private void jLabelLogoDarkMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogoDarkMouseDragged
        new Drag(jPanelApplicationBoard).moveWindow(evt);
    }//GEN-LAST:event_jLabelLogoDarkMouseDragged

    private void rSButtonIconFriendsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconFriendsActionPerformed
        if (jPanelfriends.getBackground().equals(new Color(0, 113, 188))) {
            return;
        }
        jPanelHidden.setVisible(true);
        jPanelFriends.setVisible(true);
        jPanelMessages.setVisible(false);
        jPanelSettings.setVisible(false);
        jPanelHelp.setVisible(false);
        showPendingRequest();
        jPanelApplicationBoard.repaint();
    }//GEN-LAST:event_rSButtonIconFriendsActionPerformed

    private void rSButtonIconMessagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconMessagesActionPerformed
        if (jPanelmessages.getBackground().equals(new Color(0, 113, 188))) {
            return;
        }
        jPanelFriends.setVisible(false);
        jPanelMessages.setVisible(true);
        jPanelHidden.setVisible(true);
        jPanelSettings.setVisible(false);
        jPanelHelp.setVisible(false);
        jPanelApplicationBoard.repaint();
        showFriends();
    }//GEN-LAST:event_rSButtonIconMessagesActionPerformed

    private void rSButtonIconSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconSettingsActionPerformed
        if (jPanelsettings.getBackground().equals(new Color(0, 113, 188))) {
            return;
        }
        jPanelFriends.setVisible(false);
        jPanelMessages.setVisible(false);
        jPanelHidden.setVisible(true);
        jPanelSettings.setVisible(true);
        jPanelHelp.setVisible(false);
        jPanelApplicationBoard.repaint();
    }//GEN-LAST:event_rSButtonIconSettingsActionPerformed

    private void rSButtonIconHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonIconHelpActionPerformed
        if (jPanelhelp.getBackground().equals(new Color(0, 113, 188))) {
            return;
        }
        jPanelFriends.setVisible(false);
        jPanelMessages.setVisible(false);
        jPanelSettings.setVisible(false);
        jPanelHidden.setVisible(true);
        jPanelHelp.setVisible(true);
        jPanelApplicationBoard.repaint();
    }//GEN-LAST:event_rSButtonIconHelpActionPerformed

    private void jButtonLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLogoutMouseClicked
        logOut();
    }//GEN-LAST:event_jButtonLogoutMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        logOut();
    }//GEN-LAST:event_formWindowClosing

    private void kGradientPanelFriendSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanelFriendSearchMouseClicked
        // TODO add your handling code here:
        //DO NOTHING FOR COMPONENTS FOCUS LOST
    }//GEN-LAST:event_kGradientPanelFriendSearchMouseClicked

    private void kButtonFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButtonFriendActionPerformed
        UserPojo user = new UserPojo(jTextFieldFriendSearch.getText().trim());
        try {
            if (kButtonFriend.getText().equals("Add Friend")) {
                FriendDAO.sendFriendRequest(user, USERNAME);
                kButtonFriend.setText("Cancel");
                JOptionPane.showMessageDialog(null, "Friend Request Sent", "TIP", JOptionPane.INFORMATION_MESSAGE);
            } else if (kButtonFriend.getText().equals("Unfriend") && JOptionPane.showConfirmDialog(null, "Are you Sure ?", "TIP", JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
                FriendDAO.deleteFriendRequest(user, USERNAME);
                kButtonFriend.setText("Add Friend");
                JOptionPane.showMessageDialog(null, "Removed Friend", "TIP", JOptionPane.INFORMATION_MESSAGE);
            } else if (kButtonFriend.getText().equals("Cancel")) {
                FriendDAO.deleteFriendRequest(user, USERNAME);
                kButtonFriend.setText("Add Friend");
            } else {
                System.out.println("DATABASE ERROR");
            }
            makeVisibleFalse();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_kButtonFriendActionPerformed

    private void jButtonFriendSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonFriendSearchMouseClicked
        if (jTextFieldFriendSearch.getText().trim().isEmpty() || jTextFieldFriendSearch.getText().equals("Search Friends")) {
            jTextFieldFriendSearch.setFont(new java.awt.Font("Segoe UI", 0, 24));
            jTextFieldFriendSearch.setForeground(new Color(185, 185, 185));
            jTextFieldFriendSearch.setText("Search Friends");
            jButtonFriendSearch.requestFocus();
            return;
        }
        search();
    }//GEN-LAST:event_jButtonFriendSearchMouseClicked

    private void jTextFieldFriendSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFriendSearchFocusLost
        if (jTextFieldFriendSearch.getText().trim().equals("")) {
            jTextFieldFriendSearch.setFont(new java.awt.Font("Segoe UI", 0, 24));
            jTextFieldFriendSearch.setForeground(new Color(185, 185, 185));
            jTextFieldFriendSearch.setText("Search Friends");
        }
    }//GEN-LAST:event_jTextFieldFriendSearchFocusLost

    private void jTextFieldFriendSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldFriendSearchFocusGained
        if (jTextFieldFriendSearch.getText().trim().equals("Search Friends")) {
            jTextFieldFriendSearch.setText("");
        }
        jTextFieldFriendSearch.setForeground(Color.WHITE);
        jTextFieldFriendSearch.setFont(new java.awt.Font("Calibri", 1, 24));
    }//GEN-LAST:event_jTextFieldFriendSearchFocusGained

    private void kGradientPanelFriendSearch1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanelFriendSearch1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_kGradientPanelFriendSearch1MouseClicked

    private void jTextFieldChatSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldChatSearchFocusGained
        if (jTextFieldChatSearch.getText().trim().equals("Search")) {
            jTextFieldChatSearch.setText("");
        }
        jTextFieldChatSearch.setForeground(Color.WHITE);
        jTextFieldChatSearch.setFont(new java.awt.Font("Calibri", 1, 24));
    }//GEN-LAST:event_jTextFieldChatSearchFocusGained

    private void jTextFieldChatSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldChatSearchFocusLost
        if (jTextFieldChatSearch.getText().trim().equals("")) {
            jTextFieldChatSearch.setFont(new java.awt.Font("Segoe UI", 0, 24));
            jTextFieldChatSearch.setForeground(new Color(185, 185, 185));
            jTextFieldChatSearch.setText("Search");
        }
    }//GEN-LAST:event_jTextFieldChatSearchFocusLost

    private void jButtonSendMessageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSendMessageMouseClicked
        new SendMessage().start();
    }//GEN-LAST:event_jButtonSendMessageMouseClicked

    private void jTextFieldMessageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMessageKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            new SendMessage().start();
        }
    }//GEN-LAST:event_jTextFieldMessageKeyPressed

    private void jLabelChatSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelChatSearchMouseClicked
        String username = jLabelChatSearch.getText();
        jLabelChatUsername.setText(username);
        jLabelChatSearch.setVisible(false);
        jLabelMessage.setVisible(true);
        jButtonSendMessage.setVisible(true);
        jTextFieldChatSearch.setText("");

        try {
            jPanelMessage.removeAll();
            jLabelChatUsername.setText(username);
            UserPojo user = new UserPojo(username);
            FriendPojo obj = new FriendPojo(username);
            sharedKey = KeyExchange.generateSharedPackets(KeyExchange.generatePublicPackets(UserDAO.getFriendKey(obj)), KeyExchange.generatePrivatePackets(UserPojo.getPrivateKey()));
            jLabelMessage.setVisible(true);
            jTextFieldMessage.requestFocus();
            jButtonSendMessage.setVisible(true);
            jLabelChatStatus.setVisible(true);
            jTextFieldMessage.setEnabled(true);
            if (UserDAO.getUserStatus(user) == 1) {
                jLabelChatStatus.setText("Online");
            } else {
                jLabelChatStatus.setText("Offline");
            }
            kGradientPanelFriendSearch1.repaint();
        } catch (SQLException  ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch( NullPointerException e){}
        if (!messageSync.getStatus()) {                                     // Check if Thread is ACTIVE
            messageSync.stop();                                             // Stopping Message Sync
        }
        startY = 10;
        messageSyncThread = new Thread(messageSync);
        messageSyncThread.start();                                          // Starting Message Sync Thread
        System.gc();

    }//GEN-LAST:event_jLabelChatSearchMouseClicked

    private void jButtonChatSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonChatSearchMouseClicked
        if (jTextFieldChatSearch.getText().trim().equals("Search") || jTextFieldChatSearch.getText().trim().isEmpty()) {
            jTextFieldChatSearch.setFont(new java.awt.Font("Segoe UI", 0, 24));
            jTextFieldChatSearch.setForeground(new Color(185, 185, 185));
            jTextFieldChatSearch.setText("Search");
            jButtonChatSearch.requestFocus();
            return;
        }
        String username = jTextFieldChatSearch.getText().trim();
        UserPojo user = new UserPojo(username);
        try {
            if (!UserDAO.isUsernameAvailable(user)) {
                JOptionPane.showMessageDialog(null, "Username Not Available", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabelChatSearch.setVisible(true);
        jLabelChatSearch.setText(username);
    }//GEN-LAST:event_jButtonChatSearchMouseClicked

    private void jTextFieldChatSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldChatSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String username = jTextFieldChatSearch.getText().trim();
            UserPojo user = new UserPojo(username);
            try {
                if (!UserDAO.isUsernameAvailable(user)) {
                    JOptionPane.showMessageDialog(null, "Username Not Available", "ERROR", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
            jLabelChatSearch.setVisible(true);
            jLabelChatSearch.setText(username);
        }
    }//GEN-LAST:event_jTextFieldChatSearchKeyPressed

    private void jTextFieldFriendSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFriendSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            search();
        }
    }//GEN-LAST:event_jTextFieldFriendSearchKeyPressed

    private void jPasswordFieldConfirmPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldConfirmPasswordKeyReleased
        if (Arrays.toString(jPasswordFieldNewPassword.getPassword()).equals(Arrays.toString(jPasswordFieldConfirmPassword.getPassword()))) {
            jPasswordFieldConfirmPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GREEN));
        } else {
            jPasswordFieldConfirmPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, Color.RED));
        }
    }//GEN-LAST:event_jPasswordFieldConfirmPasswordKeyReleased

    private void kButtonChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButtonChangePasswordActionPerformed
        String oldPassword = USERNAME + Arrays.toString(jPasswordFieldOldPassword.getPassword());
        String originalPassword = null;
        try {
            oldPassword = Security.HashPassword(oldPassword);
            UserPojo user = new UserPojo(USERNAME);
            originalPassword = UserDAO.getUserPassword(user);
            if (originalPassword.equals("ERROR_PASSWORD")) {
                JOptionPane.showMessageDialog(null, "Database Error", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!originalPassword.equals(oldPassword)) {
                JOptionPane.showMessageDialog(null, "Password didn't match", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NoSuchAlgorithmException | SQLException ex) {
            Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        String newPassword = Arrays.toString(jPasswordFieldNewPassword.getPassword());
        String confirmPassword = Arrays.toString(jPasswordFieldConfirmPassword.getPassword());
        if (!(newPassword.equals(confirmPassword))) {
            JOptionPane.showMessageDialog(null, "Password didn't match", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            newPassword = USERNAME + newPassword;
            newPassword = Security.HashPassword(newPassword);
            UserPojo updatedUser = new UserPojo();
            updatedUser.setPassword(newPassword);
            if (UserDAO.updateUserPassword(updatedUser)) {
                JOptionPane.showMessageDialog(null, "Password Successfully Updated", "INFO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Password Didn't Updated", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException | NoSuchAlgorithmException ex) {
            Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButtonChangePasswordActionPerformed

    private void kButtonSubmitReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButtonSubmitReportActionPerformed
        String cateogry;
        if(jTextAreaFeedback.getText().equals("Tell us how you'd like to improve CryptoChat")){
            JOptionPane.showMessageDialog(null, "Empty Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(jTextAreaFeedback.getText().equals("Describe the issue you've encountered")){
            JOptionPane.showMessageDialog(null, "Empty Fields", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(jRadioButtonIssues.isSelected()){
            cateogry = "Issues";
        }
        else{
            cateogry = "Feedback";
        }
        String feedback = jTextAreaFeedback.getText();
        String item = jComboBoxItems.getSelectedItem().toString();
        FeedbackPojo report = new FeedbackPojo(USERNAME, feedback, item, cateogry);
        try {
            FeedbackDAO.sendFeedback(report);
            jTextAreaFeedback.setText("");
            JOptionPane.showMessageDialog(null, "Thanks for your Feedback", "TIP", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_kButtonSubmitReportActionPerformed

    private void jRadioButtonIssuesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonIssuesMouseClicked
        if(jTextAreaFeedback.getText().equals("Tell us how you'd like to improve CryptoChat") || jTextAreaFeedback.getText().equals("")){
            jTextAreaFeedback.setForeground(new Color(185,185,185));
            jTextAreaFeedback.setText("Describe the issue you've encountered");
        }
    }//GEN-LAST:event_jRadioButtonIssuesMouseClicked

    private void jRadioButtonFeedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonFeedbackMouseClicked
        if(jTextAreaFeedback.getText().equals("Describe the issue you've encountered") || jTextAreaFeedback.getText().equals("")){
            jTextAreaFeedback.setForeground(new Color(185,185,185));
            jTextAreaFeedback.setText("Tell us how you'd like to improve CryptoChat");
        }
    }//GEN-LAST:event_jRadioButtonFeedbackMouseClicked

    private void jTextAreaFeedbackFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextAreaFeedbackFocusGained
        if(jRadioButtonIssues.isSelected() && jTextAreaFeedback.getText().equals("Describe the issue you've encountered")){
            jTextAreaFeedback.setForeground(Color.WHITE);
            jTextAreaFeedback.setText("");
        }
        if(jRadioButtonFeedback.isSelected() && jTextAreaFeedback.getText().equals("Tell us how you'd like to improve CryptoChat")){
            jTextAreaFeedback.setForeground(Color.WHITE);
            jTextAreaFeedback.setText("");
        }
    }//GEN-LAST:event_jTextAreaFeedbackFocusGained

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChatApplication().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jButtonChatSearch;
    private javax.swing.JLabel jButtonFriendSearch;
    private javax.swing.JLabel jButtonLogout;
    private javax.swing.JLabel jButtonSendMessage;
    private javax.swing.JComboBox<String> jComboBoxItems;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelChatSearch;
    private javax.swing.JLabel jLabelChatStatus;
    private javax.swing.JLabel jLabelChatUsername;
    private javax.swing.JLabel jLabelFriendEmail;
    private javax.swing.JLabel jLabelFriendEmailValue;
    private javax.swing.JLabel jLabelFriendFullName;
    private javax.swing.JLabel jLabelFriendFullNameValue;
    private javax.swing.JLabel jLabelFriendStatus;
    private javax.swing.JLabel jLabelFriendStatusValue;
    private javax.swing.JLabel jLabelFriendUsername;
    private javax.swing.JLabel jLabelLogoDark;
    private javax.swing.JLabel jLabelMessage;
    private javax.swing.JLabel jLabelSearchBar;
    private javax.swing.JLabel jLabelUSERNAME;
    private javax.swing.JPanel jPanelApplicationBoard;
    private javax.swing.JPanel jPanelControlBoard;
    private javax.swing.JPanel jPanelFriendList;
    private javax.swing.JPanel jPanelFriends;
    private javax.swing.JPanel jPanelHelp;
    private javax.swing.JPanel jPanelHidden;
    private javax.swing.JPanel jPanelLogo;
    private javax.swing.JPanel jPanelMessage;
    private javax.swing.JPanel jPanelMessages;
    private javax.swing.JPanel jPanelNavigationBoard;
    private javax.swing.JPanel jPanelPendingFriendList;
    private javax.swing.JPanel jPanelSettings;
    private javax.swing.JPanel jPanelfriends;
    private javax.swing.JPanel jPanelhelp;
    private javax.swing.JPanel jPanelmessages;
    private javax.swing.JPanel jPanelsettings;
    private javax.swing.JPasswordField jPasswordFieldConfirmPassword;
    private javax.swing.JPasswordField jPasswordFieldNewPassword;
    private javax.swing.JPasswordField jPasswordFieldOldPassword;
    private javax.swing.JRadioButton jRadioButtonFeedback;
    private javax.swing.JRadioButton jRadioButtonIssues;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneFriendsList;
    private javax.swing.JScrollPane jScrollPaneMessage;
    private javax.swing.JScrollPane jScrollPanePendingFriendsList;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextAreaFeedback;
    private javax.swing.JTextField jTextFieldChatSearch;
    private javax.swing.JTextField jTextFieldFriendSearch;
    private javax.swing.JTextField jTextFieldHidden;
    private javax.swing.JTextField jTextFieldMessage;
    private keeptoo.KButton kButtonChangePassword;
    private keeptoo.KButton kButtonFriend;
    private keeptoo.KButton kButtonSubmitReport;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanelFriendSearch;
    private keeptoo.KGradientPanel kGradientPanelFriendSearch1;
    private keeptoo.KGradientPanel kGradientPanelFriends;
    private keeptoo.KGradientPanel kGradientPanelPendingRequest;
    private rojerusan.RSButtonIconD rSButtonIconFriends;
    private rojerusan.RSButtonIconD rSButtonIconHelp;
    private rojerusan.RSButtonIconD rSButtonIconMessages;
    private rojerusan.RSButtonIconD rSButtonIconSettings;
    // End of variables declaration//GEN-END:variables

    private void logOut() {
        messageSync.stop();                                                     // Stopping Message Sync Thread
        UserPojo user = new UserPojo(USERNAME, OFFLINE);                        // Preparing user to Shutdown
        try {
            while (messageSyncThread.isAlive()) {                               // Wait till Thread is Active then Shut it Down
                Thread.sleep(10);
            }
            UserDAO.updateUserStatus(user);                                     // Shutting Down User in Server
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (InterruptedException ex) {
            Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        USERNAME = null;                                                        // Clearing Username from Memory
        startY = 10;                                                            // Reseting Y axis of Y
        sharedKey = new ArrayList();                                            // Reseting sharedKey
        result = null;                                                          // Reseting Message object
        new LoginPage().setVisible(true);                                       // Moving to Login Page
        this.dispose();                                                         // Clearing this Page from Memory
    }

    private void search() {
        if (jTextFieldFriendSearch.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Empty Fields");
            return;
        }
        UserPojo user = new UserPojo(jTextFieldFriendSearch.getText().trim());
        try {
            if (USERNAME == null) {
                return;
            }
            if (user.getUsername().equals(USERNAME)) {
                JOptionPane.showMessageDialog(null, "You can't search Yourself", "TIP", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            UserPojo nameEmail = UserDAO.getUsernameAndEmail(user);
            
            jLabelFriendFullNameValue.setText(nameEmail.getname());
            jLabelFriendEmailValue.setText(nameEmail.getEmail());
            if (nameEmail.getStatus() == 1) {
                jLabelFriendStatusValue.setText("ONLINE");
            } else {
                jLabelFriendStatusValue.setText("OFFLINE");
            }
            if (FriendDAO.isFriend(user, USERNAME)) {
                kButtonFriend.setText("Unfriend");
            } else if (FriendDAO.isFriendRequestSent(user, USERNAME)) {
                kButtonFriend.setText("Cancel");
            } else {
                kButtonFriend.setText("Add Friend");
            }
            makeVisible();
            kButtonFriend.setVisible(true);
        } catch (SQLException ex) {
            if(ex.getErrorCode() == 1146){
                JOptionPane.showMessageDialog(null, "Username Not Available", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private JLabel pendingFriendLabelDesign(String friendName) {
        final JLabel label = new JLabel(friendName);
        label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        label.setForeground(new java.awt.Color(255, 255, 255));
        return label;
    }

    private ArrayList<JButton> buttonDesign(String username) {
        final JButton acceptButton, rejectButton;
        acceptButton = acceptButtonDesign(username);
        rejectButton = rejectButtonDesign(username);
        ArrayList<JButton> buttons = new ArrayList();
        buttons.add(acceptButton);
        buttons.add(rejectButton);
        return buttons;
    }

    private void showPendingRequest() {
        startY = 10;
        jPanelPendingFriendList.removeAll();
        kGradientPanelPendingRequest.updateUI();
        int startX = 10, accept = 180, reject = 320;
        try {
            FriendPojo friend = new FriendPojo();
            friend.setUsername(USERNAME);
            ArrayList<String> friends = FriendDAO.pendingFriendRequest(friend);
            JLabel friendName[] = new JLabel[friends.size()];
            ArrayList<ArrayList> button = new ArrayList(friends.size());

            for (int i = 0; i < friends.size(); i++, startY += 55) {
                friendName[i] = pendingFriendLabelDesign(friends.get(i));
                jPanelPendingFriendList.add(friendName[i], new org.netbeans.lib.awtextra.AbsoluteConstraints(startX, startY, 170, 45));
                button.add(buttonDesign(friends.get(i)));
                jPanelPendingFriendList.add((Component) button.get(i).get(0),
                        new org.netbeans.lib.awtextra.AbsoluteConstraints(accept, startY, 120, -1));
                jPanelPendingFriendList.add((Component) button.get(i).get(1),
                        new org.netbeans.lib.awtextra.AbsoluteConstraints(reject, startY, 120, -1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private KButton acceptButtonDesign(String username) {
        final KButton acceptButton = new KButton();
        acceptButton.setText("Accept");
        acceptButton.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        acceptButton.setkBorderRadius(40);
        acceptButton.setkHoverEndColor(new java.awt.Color(51, 51, 51));
        acceptButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        acceptButton.setkHoverStartColor(new java.awt.Color(51, 153, 0));
        acceptButton.setkStartColor(new java.awt.Color(0, 113, 188));
        acceptButton.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }

            private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    if (FriendDAO.acceptFriendRequest(username, USERNAME)) {
                        JOptionPane.showMessageDialog(null, "Accepted");
                        showPendingRequest();

                    }
                } catch (SQLException | InterruptedException ex) {
                    Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        return acceptButton;
    }

    private KButton rejectButtonDesign(String username) {
        final KButton rejectButton = new KButton();
        rejectButton.setText("Reject");
        rejectButton.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        rejectButton.setkBorderRadius(40);
        rejectButton.setkEndColor(new java.awt.Color(255, 0, 0));
        rejectButton.setkHoverEndColor(new java.awt.Color(51, 51, 51));
        rejectButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        rejectButton.setkHoverStartColor(new java.awt.Color(153, 0, 0));
        rejectButton.setkStartColor(new java.awt.Color(0, 113, 188));
        rejectButton.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
        rejectButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                rejectButtonActionPerformed(evt);
            }

            private void rejectButtonActionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    FriendDAO.rejectFriendRequest(username, USERNAME);
                    showPendingRequest();

                } catch (SQLException ex) {
                    Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        return rejectButton;
    }

    private void makeVisible() {
        jLabelFriendUsername.setVisible(true);
        jLabelFriendFullName.setVisible(true);
        jLabelFriendFullNameValue.setVisible(true);
        jLabelFriendEmail.setVisible(true);
        jLabelFriendEmailValue.setVisible(true);
        jLabelFriendStatus.setVisible(true);
        jLabelFriendStatusValue.setVisible(true);
        kButtonFriend.setVisible(true);
    }

    private void makeVisibleFalse() {
        jLabelFriendUsername.setVisible(false);
        jTextFieldFriendSearch.setText("");
        jLabelFriendFullName.setVisible(false);
        jLabelFriendFullNameValue.setVisible(false);
        jLabelFriendEmail.setVisible(false);
        jLabelFriendEmailValue.setVisible(false);
        jLabelFriendStatus.setVisible(false);
        jLabelFriendStatusValue.setVisible(false);
        kButtonFriend.setVisible(false);
    }

    private void showFriends() {
        jPanelFriendList.removeAll();                                               // Update Friend Request panel
        jPanelFriendList.updateUI();                                                // Update Friend Request panel
        jPanelFriendList.setLayout(new BoxLayout(jPanelFriendList, BoxLayout.Y_AXIS));
        try {
            FriendPojo friend = new FriendPojo();
            friend.setUsername(USERNAME);
            ArrayList<String> Friends = FriendDAO.onlineFriends();              // Load all Online Friends.
            JLabel label[] = new JLabel[Friends.size()];
            for (int i = 0; i < Friends.size(); i++) {
                label[i] = labelFriend(Friends.get(i));
                jPanelFriendList.add(label[i]);
            }
            Friends = FriendDAO.offlineFriends();                               // Load all Offline Friends.
            JLabel l1[] = new JLabel[Friends.size()];
            for (int i = 0; i < Friends.size(); i++) {
                l1[i] = labelFriend(Friends.get(i));
                jPanelFriendList.add(l1[i]);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private JLabel labelFriend(String friendName) {
        final JLabel label;
        label = new JLabel(friendName);
//        label.setPreferredSize(new Dimension(340, 20));
        label.setForeground(new java.awt.Color(255, 255, 255));
        label.setFont(new java.awt.Font("Segoe UI Light", 1, 24));
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));// NOI18N
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            //-----------------------Label Mouse Clicked----------------------//
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FriendLabelMouseClicked(evt);
            }

            //--------------------------On Click------------------------------//
            private void FriendLabelMouseClicked(MouseEvent evt) {
                if (jLabelChatUsername.getText() == null || !jLabelChatUsername.getText().equals(friendName)) {
                    try {
                        jPanelMessage.removeAll();
                        kGradientPanelFriendSearch1.repaint();
                        jLabelChatUsername.setText(friendName);
                        UserPojo user = new UserPojo(friendName);
                        FriendPojo obj = new FriendPojo(friendName);
                        sharedKey = KeyExchange.generateSharedPackets(KeyExchange.generatePublicPackets(UserDAO.getFriendKey(obj)), KeyExchange.generatePrivatePackets(UserPojo.getPrivateKey()));
                        jLabelMessage.setVisible(true);
                        jTextFieldMessage.requestFocus();
                        jButtonSendMessage.setVisible(true);
                        jLabelChatStatus.setVisible(true);
                        jTextFieldMessage.setEnabled(true);
                        if (UserDAO.getUserStatus(user) == 1) {
                            jLabelChatStatus.setText("Online");
                        } else {
                            jLabelChatStatus.setText("Offline");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    catch(NullPointerException ex){
                        
                    }
                    if (!messageSync.getStatus()) {                               // Check if Thread is ACTIVE
                        messageSync.stop();                                     // Stopping Message Sync
                    }
                    startY = 10;
                    messageSyncThread = new Thread(messageSync);
                    messageSyncThread.start();                                  // Starting Message Sync Thread
                    System.gc();                                                // Called Garbage Collector for Clearing Heap
                }
            }
        });
        return label;
    }

    public class SendMessage extends Thread {

        @Override
        public void run() {
            String strMessage = jTextFieldMessage.getText().trim();
            jTextFieldMessage.setText(null);
            jTextFieldMessage.requestFocus();
            try {
                MessagePojo message = new MessagePojo(jLabelChatUsername.getText(), Security.Encryption(strMessage, KeyExchange.generateSharedKey(sharedKey)));
                MessageDAO.sendMessage(message);
            } catch (SQLException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    //---------------------Message Sync Message Thread------------------------//
    public class SyncMessage implements Runnable {

        private volatile boolean exit = true;

        @Override
        public void run() {
            result = null;
            exit = false;
            ArrayList<Integer> localShared = sharedKey;                         // Initialize Local Shared Key from Global Shared Key
            while (!exit) {
                try {
                    Thread.sleep(10);
                    String user = jLabelChatUsername.getText();
                    JScrollBar bar = jScrollPaneMessage.getVerticalScrollBar();
                    bar.setValue(bar.getMaximum());
                    if (user == null) {                                         // Checking if friend name is null
                        continue;
                    }
                    if (!localShared.equals(sharedKey)) // Check if Shared Key is same for users
                    {
                        continue;
                    }
                    if (result == null) {                                       // Check Message in Database
                        result = MessageDAO.getAllMessage(user);
                        if (result.getSize() == 0) {
                            result = null;
                            continue;
                        }
                        for (int i = 0; i < result.getSize(); i++) {            // Load all messages from Database
                            showMessage(Security.Decryption(result.getMessage(i), KeyExchange.generateSharedKey(sharedKey)), result.getFlag(i));
                        }
                        continue;
                    }
                    Thread.sleep(10);
                    testMessagePojo result1 = MessageDAO.getAllMessage(user);
                    if (result == null || result1 == null) {                      // Check Friend Switch
                        continue;
                    }
                    if (!exit && result.getSize() == result1.getSize()) {       // Condition to exit loop & Check new Data in Database
                        continue;
                    }
                    for (int i = result.getSize(); i < result1.getSize(); i++) {// Print current new messages
                        showMessage(Security.Decryption(result1.getMessage(i), KeyExchange.generateSharedKey(sharedKey)), result1.getFlag(i));
                    }
                    result = result1;                                           // Update old database from RAM and put new messages
                } catch (SQLException | InterruptedException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());

                    Logger.getLogger(ChatApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        //-----------------------Show Messages on Text Field------------------//
        private void showMessage(String msg, int flag) {
            final JLabel l;
            int startxl = 10, startxr = 100;
            l = new JLabel(msg);
            l.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
            l.setForeground(new java.awt.Color(255, 255, 255));
            if (flag == 1) {
                l.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                jPanelMessage.add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(startxr, startY, 270, 30));
            } else if (flag == 0) {
                l.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                jPanelMessage.add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(startxl, startY, 270, 30));
            }
            startY += 40;
            l.setVisible(true);
            try{
            kGradientPanelFriendSearch1.updateUI();
        }catch(NullPointerException r){}
        }

        //----------------------Function to stop Thread-----------------------//
        private void stop() {
            exit = true;
        }

        //------------------Function to check if Thread is Active-------------//
        private boolean getStatus() {
            return exit;
        }

    }

    //-------------------Thread to generate Shared Key------------------------//
    private class SharedKeyGen implements Runnable {

        @Override
        public void run() {
            try {
                FriendPojo obj = new FriendPojo(jLabelChatUsername.getText());
                sharedKey = KeyExchange.generateSharedPackets(KeyExchange.generatePublicPackets(UserDAO.getFriendKey(obj)), KeyExchange.generatePrivatePackets(UserPojo.getPrivateKey()));
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }

    }
}
