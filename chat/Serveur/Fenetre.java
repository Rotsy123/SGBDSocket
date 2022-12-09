import java.io.PrintWriter;

import javax.swing.*;

import java.awt.Color;

public class Fenetre extends JFrame{
    JMenu couleur;
    static JMenuItem rouge;
    static JMenuItem bleu;
    static JTextArea msgRec;
    static JTextArea msgSend;
    JButton send;
    JScrollPane pane2;
    JScrollPane pane1;
    JMenuBar bar;
    JMenu messanger;
    JMenuItem logOut;
    JMenu help;
    JMenuItem s_keys;
    JMenuItem about;
    JMenuItem envoyerfichier;
    String username;
    PrintWriter writer;
    String iPAddress = null;

    public JMenu getCouleur() {
        return couleur;
    }
    public void setCouleur(JMenu couleur) {
        this.couleur = couleur;
    }
    //---------------------------------------------
    public JTextArea getMsgRec() {
        return msgRec;
    }
    public void setMsgRec(JTextArea msgRec) {
        this.msgRec = msgRec;
    }

    public JMenuItem getRouge() {
        return rouge;
    }
    public void setRouge(JMenuItem rouge) {
        this.rouge = rouge;
    }

    public JMenuItem getBleu() {
        return bleu;
    }
    public void setBleu(JMenuItem bleu) {
        this.bleu = bleu;
    }

    ////////////////////////////////////////////////
    public JTextArea getMsgSend() {
        return msgSend;
    }
    public void setMsgSend(JTextArea msgSend) {
        this.msgSend = msgSend;
    }
    ////////////////////////////////////////////////
    public JButton getSend() {
        return send;
    }
    public void setSend(JButton send) {
        this.send = send;
    }
    //---------------------------------------------
    public JScrollPane getPane2() {
        return pane2;
    }
    public void setPane2(JScrollPane pane2) {
        this.pane2 = pane2;
    }
    //---------------------------------------------
    public JScrollPane getPane1() {
        return pane1;
    }
    public void setPane1(JScrollPane pane1) {
        this.pane1 = pane1;
    }

    //----------------------------------------------
    public JMenuBar getBar() {
        return bar;
    }
    public void setBar(JMenuBar bar) {
        this.bar = bar;
    }
    //-------------------------------------------------
    public JMenu getMessanger() {
        return messanger;
    }
    public void setMessanger(JMenu messanger) {
        this.messanger = messanger;
    }
    //------------------------------------------------
    public JMenuItem getLogOut() {
        return logOut;
    }
    public void setLogOut(JMenuItem logOut) {
        this.logOut = logOut;
    }
    //-------------------------------------------------
    public JMenu getHelp() {
        return help;
    }
    public void setHelp(JMenu help) {
        this.help = help;
    }
    //-------------------------------------------------
    public JMenuItem getS_keys() {
        return s_keys;
    }
    public void setS_keys(JMenuItem s_keys) {
        this.s_keys = s_keys;
    }
    //-------------------------------------------------
    public JMenuItem getAbout() {
        return about;
    }
    public void setAbout(JMenuItem about) {
        this.about = about;
    }
    //------------------------------------------------
    public JMenuItem getEnvoyerfichier() {
        return envoyerfichier;
    }
    public void setEnvoyerFichier(JMenuItem fichier) {
        this.envoyerfichier = fichier;
    }
    //------------------------------------------------
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    //------------------------------------------------
    public PrintWriter getWriter() {
        return writer;
    }
    public void setWriter(PrintWriter writer) {
        this.writer = writer;
    }

    //------------------------------------------------
    public String getiPAddress() {
        return iPAddress;
    }
    public void setiPAddress(String iPAddress) {
        this.iPAddress = iPAddress;
    }
    
    public Fenetre(){
        super("Java Server");
       
        JTextArea msgRec = new JTextArea(100, 50);
        setMsgRec(msgRec);
        
        JTextArea msgSend = new JTextArea(100, 50);
        setMsgSend(msgSend);
        
        JButton send = new JButton("Send");
        setSend(send);

        JScrollPane pane1 =  new JScrollPane(getMsgSend());
        JScrollPane pane2 =  new JScrollPane(getMsgRec());
        setPane2(pane2);
        setPane1(pane1);

        JMenuBar bar = new JMenuBar();
        setBar(bar);

        JMenu messanger = new JMenu("Options");
        setMessanger(messanger);

        JMenu couleur =  new JMenu("Changer le theme de la discussion");
        setCouleur(couleur);

        JMenuItem logOut = new JMenuItem("Log Out");
        setLogOut(logOut);

        JMenu help = new JMenu("Help");
        setHelp(help);
        
        JMenuItem s_keys = new JMenuItem("Shortcut Keys");
        setS_keys(s_keys);

        JMenuItem about = new JMenuItem("about");
        setAbout(about);

        
        JMenuItem envoyerfichier = new JMenuItem("Envoyer un fichier");
        setEnvoyerFichier(envoyerfichier); 

        JMenuItem rouge = new JMenuItem("Rouge");
        setRouge(rouge);

        JMenuItem bleu = new JMenuItem("bleu");
        setBleu(bleu);

        String username="";
        setUsername(username);

        PrintWriter writer = null;
        setWriter(writer);

        setBounds(0, 0, 407, 495);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
 
        getMsgRec().setEditable(false);
        getMsgRec().setBackground(Color.BLACK);
        getMsgRec().setForeground(Color.WHITE);
       
        getMsgRec().setText("");
 
        getMsgRec().setWrapStyleWord(true);
        getMsgRec().setLineWrap(true);
 
       
        getPane2().setBounds(0, 0, 400, 200);
        getPane2().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(getPane2());
 
        getMsgSend().setBackground(Color.LIGHT_GRAY);
        getMsgSend().setForeground(Color.BLACK);
        getMsgSend().setLineWrap(true);
        getMsgSend().setWrapStyleWord(true);
 
        getMsgSend().setText("Write Message here");
       
        getCouleur().add(getRouge());
        getCouleur().add(getBleu());
        
        getPane1().setBounds(0, 200, 400, 200);
        getPane1().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(getPane1());
 
        getSend().setBounds(0, 400, 400, 40);
        add(getSend());
        
        getBar().add(getMessanger());
        messanger.add(getEnvoyerfichier());
        
        getBar().add(getHelp());
        getBar().add(getCouleur());
        getHelp().add(getS_keys());
        getHelp().add(getAbout());
        getHelp().add(getLogOut());
        
        setJMenuBar(getBar());

        EcouteActionPerformed ea= new EcouteActionPerformed(this);
        getSend().addActionListener(ea);
        getLogOut().addActionListener(ea);
        getS_keys().addActionListener(ea);
        getAbout().addActionListener(ea);
        getEnvoyerfichier().addActionListener(ea);
        getBleu().addActionListener(ea);
        getRouge().addActionListener(ea);

        EcouteWindow ecoute=new EcouteWindow(this);
        this.addWindowFocusListener(ecoute);

        EcouteClavier eClavier = new EcouteClavier(this);
        getMsgSend().addKeyListener(eClavier);

        
        if ((username) != null) {
            setVisible(true);
        } else {
            System.exit(0);
        }
    }
}