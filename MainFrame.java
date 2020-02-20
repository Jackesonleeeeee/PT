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
        JLabel money=new JLabel("You have $"+a.getMoney());
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
        message.setBounds(100,200,700,30);
        money.setBounds(100,500,300,30);
        jobp.setBounds(200,300,100,30);
        storep.setBounds(300,300,100,30);
        businessp.setBounds(400,300,100,30);
        investp.setBounds(500,300,100,30);
        sellp.setBounds(600,300,100,30);
        nextp.setBounds(600,700,100,30);
        frame.add(message);
        frame.add(money);
        frame.add(jobp);
        frame.add(storep);
        frame.add(businessp);
        frame.add(investp);
        frame.add(sellp);
        frame.add(nextp);
        frame.setVisible(true);
        job.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(a.canApplyJob&&!a.haveJob){
            frame.dispose();
            Job(a);
        }
            else
            message.setText("You already have a job or you applied for it this round");
       }
       });
       store.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            //Store(a);
       }
       });
       business.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            //Business(a);
       }
       });
       invest.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            //Invest(a);
       }
       });
       sell.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            //Sell(a);
       }
       });
       next.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            //Next(a);
       }
       });
    }
    public static void Job(Player a){
        a.canApplyJob=false;
        int chance=(int)(10*Math.random())+1;
        Asset job1=new Asset();
        job1.Asset("Job 1", 0, 10000, false);
        Asset job2=new Asset();
        job2.Asset("Job 2", 0, 9000, false);
        Asset job3=new Asset();
        job3.Asset("Job 3", 0, 8000, false);  
        
        JFrame frame=new JFrame("Job");
        frame.setSize(900,900);
        frame.setLayout(null);
        JLabel jobdes=new JLabel("Job 1: $10000/round, Job 2: $9000/round, Job 3: $8000/round");
        JLabel instruction=new JLabel("You can only choose one job in one game. The higher the job salary, the less chance you get that job. You can only try to get one job per round");
        JButton job1b=new JButton("Job 1");
        JButton job2b=new JButton("Job 2");
        JButton job3b=new JButton("Job 3");
        JPanel job1p=new JPanel();
        JPanel job2p=new JPanel();
        JPanel job3p=new JPanel();
        job1p.add(job1b);
        job2p.add(job2b);
        job3p.add(job3b);
        jobdes.setBounds(100,200,700,30);
        instruction.setBounds(50,150,800,30);
        job1p.setBounds(100,300,100,30);
        job2p.setBounds(350,300,100,30);
        job3p.setBounds(600,300,100,30);
        frame.add(jobdes);
        frame.add(instruction);
        frame.add(job1p);
        frame.add(job2p);
        frame.add(job3p);
        frame.setVisible(true);
        job1b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            if(chance>8){
                a.setAsset(job1);
                a.haveJob=true;
                homeScreen(a);
            }
            else{
                JFrame fail=new JFrame("You didn't get the job");
                JLabel text=new JLabel("You didn't get the job");
                text.setBounds(100,200,700,30);
                fail.setLayout(null);
                fail.add(text);
                fail.setVisible(true);
                homeScreen(a);
            }
       }
       });
       job2b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            if(chance>5){
                a.setAsset(job2);
                a.haveJob=true;
                homeScreen(a);
            }
            else{
                
                JFrame fail=new JFrame("You didn't get the job");
                JLabel text=new JLabel("You didn't get the job");
                text.setBounds(100,200,700,30);
                fail.setLayout(null);
                fail.add(text);
                fail.setVisible(true);
                homeScreen(a);
            }
       }
       });
       job3b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            if(chance>3){
                a.setAsset(job3);
                a.haveJob=true;
                homeScreen(a);
            }
            else{
                JFrame fail=new JFrame("You didn't get the job");
                JLabel text=new JLabel("You didn't get the job");
                text.setBounds(100,200,700,30);
                fail.setLayout(null);
                fail.add(text);
                fail.setVisible(true);
                homeScreen(a);
            }
       }
       });
    }
}
