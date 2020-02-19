import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MainFrame{
    public static void main(String[] args){
        Player a=new Player();
        JFrame begin=new JFrame("Begin game");
        begin.setSize(900,900);
        JButton play=new JButton("Play");
        JPanel playp=new JPanel();
        //playp.setLayout(null);
        begin.setLayout(null);
        playp.add(play);
        playp.setBounds(350,700,200,30);
        begin.add(playp);
        begin.setVisible(true);
        play.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
        startGame(a);
        begin.dispose();
    }
    });
    }
    public static void startGame(Player a){
        a.Player(getInitialFund());
        JFrame frame=new JFrame("Initial Fund");
        frame.setSize(900,900);
        JLabel message=new JLabel("You have $"+a.getMoney()+" to start with");
        message.setBounds(100,300,200,30);
        JButton next=new JButton("Next");
        JPanel nextp=new JPanel();
        nextp.add(next);
        nextp.setBounds(350,700,200,30);
        frame.setLayout(null);
        frame.add(message);
        frame.add(nextp);
        frame.setVisible(true);
        next.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
        frame.dispose();
        homeScreen(a);
    }
    });
    }
    public static int getInitialFund(){
        int fund=1000*((int)(10*Math.random())+1);
        return fund;
    }
    public static void homeScreen(Player a){
        JFrame frame=new JFrame("Home");
        frame.setSize(900,900);
        frame.setLayout(null);
        JLabel message=new JLabel("Choose what you are going to do");
        JButton job=new JButton("Job");
        JButton store=new JButton("Store");
        JButton business=new JButton("Business");
        JButton invest=new JButton("Invest");
        JButton sell=new JButton("Sell");
        JButton next=new JButton("Next");
        JPanel jobp=new JPanel();
        JPanel storep=new JPanel();
        JPanel businessp=new JPanel();
        JPanel investp=new JPanel();
        JPanel sellp=new JPanel();
        JPanel nextp=new JPanel();
        jobp.add(job);
        storep.add(store);
        businessp.add(business);
        investp.add(invest);
        sellp.add(sell);
        nextp.add(next);
        message.setBounds(100,200,500,30);
        jobp.setBounds(200,300,100,30);
        storep.setBounds(300,300,100,30);
        businessp.setBounds(400,300,100,30);
        investp.setBounds(500,300,100,30);
        sellp.setBounds(600,300,100,30);
        nextp.setBounds(600,700,100,30);
        frame.add(message);
        frame.add(jobp);
        frame.add(storep);
        frame.add(businessp);
        frame.add(investp);
        frame.add(sellp);
        frame.add(nextp);
        frame.setVisible(true);
    }
}
