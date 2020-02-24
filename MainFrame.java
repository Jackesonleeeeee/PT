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
            Store(a);
       }
       });
       business.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            Business(a);
       }
       });
       invest.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            Invest(a);
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
                noJob(a);
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
                noJob(a);
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
                noJob(a);
            }
       }
       });
    }
    public static void noJob(Player a){
        JFrame frame=new JFrame("You didn't get the job");
        frame.setSize(900,900);
        JLabel text=new JLabel("You didn't get the job");
        text.setBounds(100,200,700,30);
        frame.setLayout(null);
        frame.add(text);
        frame.setVisible(true);
        JButton next=new JButton("Next");
        JPanel nextp=new JPanel();
        nextp.add(next);
        nextp.setBounds(300,500,200,30);
        frame.add(nextp);
        next.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            homeScreen(a);
       }
       });
    }
    public static void haveJob(Player a){
        JFrame frame=new JFrame("You get the job");
        frame.setSize(900,900);
        JLabel text=new JLabel("You get the job");
        text.setBounds(100,200,700,30);
        frame.setLayout(null);
        frame.add(text);
        frame.setVisible(true);
        JButton next=new JButton("Next");
        JPanel nextp=new JPanel();
        nextp.add(next);
        nextp.setBounds(300,500,200,30);
        frame.add(nextp);
        next.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            homeScreen(a);
       }
       });
    }
    public static void Store(Player a){
        Asset house1=new Asset();
        house1.Asset("House 1",100000,0,true);
        Asset house2=new Asset();
        house2.Asset("House 2",80000,0,true);
        Asset house3=new Asset();
        house3.Asset("House 3",50000,0,true);
        Asset car1=new Asset();
        car1.Asset("Car 1",30000,0,true);
        Asset car2=new Asset();
        car2.Asset("Car 2",8000,0,true);
        Asset car3=new Asset();
        car3.Asset("Car 3",5000,0,true);
        
        JFrame frame=new JFrame("Store");
        frame.setSize(900,900);
        frame.setLayout(null);
        JLabel message=new JLabel("Click on what you want to buy");
        JLabel priceinfo=new JLabel("House 1: $100000, House 2: $80000, House 3: $50000, Car 1: $30000, Car 2: $8000, Car 3: $5000");
        JButton house1b=new JButton("House 1");
        JButton house2b=new JButton("House 2");
        JButton house3b=new JButton("House 3");
        JButton car1b=new JButton("Car 1");
        JButton car2b=new JButton("Car 2");
        JButton car3b=new JButton("Car 3");
        JButton back=new JButton("Back");
        JPanel house1p=new JPanel();
        JPanel house2p=new JPanel();
        JPanel house3p=new JPanel();
        JPanel car1p=new JPanel();
        JPanel car2p=new JPanel();
        JPanel car3p=new JPanel();
        JPanel backp=new JPanel();
        house1p.add(house1b);
        house2p.add(house2b);
        house3p.add(house3b);
        car1p.add(car1b);
        car2p.add(car2b);
        car3p.add(car3b);
        backp.add(back);
        message.setBounds(50,150,800,30);
        priceinfo.setBounds(50,200,800,30);
        house1p.setBounds(100,300,100,30);
        house2p.setBounds(350,300,100,30);
        house3p.setBounds(600,300,100,30);
        car1p.setBounds(100,400,100,30);
        car2p.setBounds(350,400,100,30);
        car3p.setBounds(600,400,100,30);
        backp.setBounds(650,600,200,30);
        frame.add(message);
        frame.add(priceinfo);
        frame.add(house1p);
        frame.add(house2p);
        frame.add(house3p);
        frame.add(car1p);
        frame.add(car2p);
        frame.add(car3p);
        frame.add(backp);
        frame.setVisible(true);
        house1b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(checknr(a,house1)){
                a.spend(house1.getPrice());
                a.nHouse+=1;
                a.setAsset(house1);
                message.setText("Purchase successfully, you have $"+a.getMoney()+" currently!");
            }
            else
                message.setText("You already bought this house");
       }
       });
       house2b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(checknr(a,house2)){
                a.spend(house2.getPrice());
                a.nHouse+=1;
                a.setAsset(house2);
                message.setText("Purchase successfully, you have $"+a.getMoney()+" currently!");
            }
            else
                message.setText("You already bought this house");
       }
       });
       house3b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(checknr(a,house3)){
                a.spend(house3.getPrice());
                a.nHouse+=1;
                a.setAsset(house3);
                message.setText("Purchase successfully, you have $"+a.getMoney()+" currently!");
            }
            else
                message.setText("You already bought this house");
       }
       });
       car1b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(checknr(a,car1)){
                a.spend(car1.getPrice());
                a.setAsset(car1);
                message.setText("Purchase successfully, you have $"+a.getMoney()+" currently!");
            }
            else
                message.setText("You already bought this car");
       }
       });
       car2b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(checknr(a,car2)){
                a.spend(car2.getPrice());
                a.setAsset(car2);
                message.setText("Purchase successfully, you have $"+a.getMoney()+" currently!");
            }
            else
                message.setText("You already bought this car");
       }
       });
       car3b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(checknr(a,car3)){
                a.spend(car3.getPrice());
                a.setAsset(car3);
                message.setText("Purchase successfully, you have $"+a.getMoney()+" currently!");
            }
            else
                message.setText("You already bought this car");
       }
       });
       back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            homeScreen(a);
       }
       });
    }
    public static void Business(Player a){
        Asset business1=new Asset();
        business1.Asset("Business 1",200000,0,true);
        Asset business2=new Asset();
        business2.Asset("Business 2",10000,0,true);
        Asset business3=new Asset();
        business3.Asset("Business 3",8000,0,true);
        
        JFrame frame=new JFrame("Store");
        frame.setSize(900,900);
        frame.setLayout(null);
        JLabel message=new JLabel("Click on what you want to buy. Think twice! You might loss money from the business and the total worth of the business can decrease");
        JLabel priceinfo=new JLabel("Business 1: $200000, Business 2: $10000, Business 3: $8000");
        JButton business1b=new JButton("Business 1");
        JButton business2b=new JButton("Business 2");
        JButton business3b=new JButton("Business 3");
        JButton back=new JButton("Back");
        JPanel business1p=new JPanel();
        JPanel business2p=new JPanel();
        JPanel business3p=new JPanel();
        JPanel backp=new JPanel();
        business1p.add(business1b);
        business2p.add(business2b);
        business3p.add(business3b);
        backp.add(back);
        message.setBounds(50,150,800,30);
        priceinfo.setBounds(50,200,800,30);
        business1p.setBounds(100,300,100,30);
        business2p.setBounds(350,300,100,30);
        business3p.setBounds(600,300,100,30);
        backp.setBounds(650,600,200,30);
        frame.add(message);
        frame.add(priceinfo);
        frame.add(business1p);
        frame.add(business2p);
        frame.add(business3p);
        frame.add(backp);
        frame.setVisible(true);
        business1b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(checknr(a,business1)){
                a.spend(business1.getPrice());
                a.setAsset(business1);
                message.setText("Purchase successfully, you have $"+a.getMoney()+" currently!");
            }
            else
                message.setText("You already bought this");
       }
       });
       business2b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(checknr(a,business2)){
                a.spend(business2.getPrice());
                a.setAsset(business2);
                message.setText("Purchase successfully, you have $"+a.getMoney()+" currently!");
            }
            else
                message.setText("You already bought this");
       }
       });
       business3b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(checknr(a,business3)){
                a.spend(business3.getPrice());
                a.setAsset(business3);
                message.setText("Purchase successfully, you have $"+a.getMoney()+" currently!");
            }
            else
                message.setText("You already bought this");
       }
       });
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            homeScreen(a);
       }
       });
    }
    public static void Invest(Player a){
        Asset stock1=new Asset();
        stock1.Asset("Stock 1",1000,0,true);
        Asset stock2=new Asset();
        stock2.Asset("Stock 2",5000,0,true);
        Asset stock3=new Asset();
        stock3.Asset("Stock 3",800,0,true);
        Asset savingsPlan=new Asset();
        savingsPlan.Asset("Savings Plan",0,0,true);
        
        JFrame frame=new JFrame("Store");
        frame.setSize(900,900);
        frame.setLayout(null);
        JLabel message=new JLabel("Click on what you want to buy. For savings plan, enter the amount of money you want to put into.");
        JLabel priceinfo=new JLabel("Stock 1: $1000, Stock 2: $5000, Stock 3: $800");
        JButton stock1b=new JButton("Stock 1");
        JButton stock2b=new JButton("Stock 2");
        JButton stock3b=new JButton("Stock 3");
        JButton back=new JButton("Back");
        JButton buy=new JButton("Buy");
        JPanel stock1p=new JPanel();
        JPanel stock2p=new JPanel();
        JPanel stock3p=new JPanel();
        JPanel backp=new JPanel();
        JPanel buyp=new JPanel();
        JTextField input=new JTextField("Input the amount of $ here");
        stock1p.add(stock1b);
        stock2p.add(stock2b);
        stock3p.add(stock3b);
        backp.add(back);
        buyp.add(buy);
        message.setBounds(50,150,800,30);
        priceinfo.setBounds(50,200,800,30);
        stock1p.setBounds(100,300,100,30);
        stock2p.setBounds(350,300,100,30);
        stock3p.setBounds(600,300,100,30);
        backp.setBounds(650,600,200,30);
        buyp.setBounds(350,450,100,30);
        input.setBounds(100,400,500,30);
        frame.add(message);
        frame.add(priceinfo);
        frame.add(stock1p);
        frame.add(stock2p);
        frame.add(stock3p);
        frame.add(backp);
        frame.add(buyp);
        frame.add(input);
        frame.setVisible(true);
        back.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            homeScreen(a);
       }
       });
        buy.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            System.out.println(input.getText());
       }
       });
    }
    public static boolean checknr(Player a,Asset get){
        for(int x=0;x<a.getNumofAsset();x++){
            if(a.getAsset(x).getName().equals(get.getName()))
            return false;
        }
        return true;
    }
}
