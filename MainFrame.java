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
        playp.add(play);
        begin.add(playp,"South");
        begin.setVisible(true);
        play.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
        startGame(a);
    }
    });
    }
    public static void startGame(Player a){
        a.Player(getInitialFund());
        System.out.println("You have $"+a.getMoney()+" to start with");
        //homeScreen(a);
    }
    public static int getInitialFund(){
        int fund=1000*((int)(10*Math.random())+1);
        return fund;
    }
}
