import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MainFrame{
    public static void main(String[] args){
        startGame();
    }
    public static void startGame(){
        Player a=new Player();
        JFrame begin=new JFrame("Begin game");
        begin.setSize(900,900);
        JButton play=new JButton("Play");
        JPanel playp=new JPanel();
        JButton instruction=new JButton("Instruction");
        JPanel instructionp=new JPanel();
        JLabel title=new JLabel("Personal Finance Game");
        begin.setLayout(null);
        playp.add(play);
        playp.setBounds(350,700,200,30);
        title.setBounds(140,200,700,60);
        title.setFont(new Font("Serif", Font.BOLD, 60));
        instructionp.add(instruction);
        instructionp.setBounds(700,0,200,30);
        begin.add(playp);
        begin.add(title);
        begin.add(instructionp);
        begin.setVisible(true);
        
        JLabel image=new JLabel();
        image.setIcon(new ImageIcon("image/PF.jpg"));
        begin.add(image);
        image.setBounds(340,350,260,260);
        
        play.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            getInitialFund(a);
            begin.dispose();
        }
        });
        instruction.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            instruction();
            begin.dispose();
        }
        });
    }
    public static void instruction(){
        JFrame frame=new JFrame("Instruction");
        frame.setSize(900,900);
        frame.setLayout(null);
        frame.setVisible(true);
        JButton next=new JButton("Ok");
        JPanel nextp=new JPanel();
        JLabel instruction=new JLabel("Instruction");
        instruction.setFont(new Font("Tahoma", Font.PLAIN, 60));
        instruction.setBounds(100,60,700,60);
        nextp.add(next);
        nextp.setBounds(350,725,200,30);
        frame.add(nextp);
        frame.add(instruction);
        next.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            startGame();
        }
        });
        
        JLabel image=new JLabel();
        image.setIcon(new ImageIcon("image/InstructInfo.png"));
        frame.add(image);
        image.setBounds(180,150,513,560);
    }
    public static void getInitialFund(Player a){
        int fund=1000*((int)(10*Math.random())+1);
        a.Player(fund);
        JFrame frame=new JFrame("Initial Fund");
        frame.setSize(900,900);
        JLabel message=new JLabel("You have $"+a.getMoney()+" to start with!");
        message.setBounds(100,300,400,30);
        JButton next=new JButton("Next");
        JPanel nextp=new JPanel();
        nextp.add(next);
        nextp.setBounds(350,700,200,30);
        frame.setLayout(null);
        message.setFont(new Font("Tahoma", Font.PLAIN, 25));
        frame.add(message);
        frame.add(nextp);
        frame.setVisible(true);
        next.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            homeScreen(a);
        }
        });
        
        JLabel image=new JLabel();
        image.setIcon(new ImageIcon("image/money_icon.PNG"));
        frame.add(image);
        image.setBounds(500,250,250,250);
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
            Sell(a);
       }
       });
       next.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            frame.dispose();
            Next(a);
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
                haveJob(a);
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
                haveJob(a);
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
                haveJob(a);
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
        
        JFrame frame=new JFrame("Business");
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
        if(checknr(a,savingsPlan))
            a.setAsset(savingsPlan);
       
        JFrame frame=new JFrame("Invest");
        frame.setSize(900,900);
        frame.setLayout(null);
        JLabel message=new JLabel("Click on what you want to buy. For savings plan, enter the amount of money you want to put into.");
        JLabel priceinfo=new JLabel("Stock 1: $1000, Stock 2: $5000, Stock 3: $800");
        JLabel savinglabel=new JLabel("Savings Plan:");
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
        buyp.setBounds(500,400,100,30);
        savinglabel.setBounds(100,400,100,30);
        input.setBounds(200,400,300,30);
        frame.add(message);
        frame.add(priceinfo);
        frame.add(stock1p);
        frame.add(stock2p);
        frame.add(stock3p);
        frame.add(backp);
        frame.add(buyp);
        frame.add(savinglabel);
        frame.add(input);
        frame.setVisible(true);
        stock1b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(checknr(a,stock1)){
                a.spend(stock1.getPrice());
                a.setAsset(stock1);
                message.setText("Purchase successfully, you have $"+a.getMoney()+" currently!");
            }
            else
                message.setText("You already bought this");
       }
       });
       stock2b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(checknr(a,stock2)){
                a.spend(stock2.getPrice());
                a.setAsset(stock2);
                message.setText("Purchase successfully, you have $"+a.getMoney()+" currently!");
            }
            else
                message.setText("You already bought this");
       }
       });
       stock3b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            if(checknr(a,stock3)){
                a.spend(stock3.getPrice());
                a.setAsset(stock3);
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
        buy.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent evt){ 
            double money_in=0;
            boolean check=false;
            try{
                money_in=Integer.parseInt(input.getText());
                check=true;
            }
            catch(Exception e){
            }
            if(check && money_in>0){
                if(money_in<=a.getMoney()){
                    a.getAsset("Savings Plan").setPrice(money_in+a.getAsset("Savings Plan").getPrice());
                    a.spend(money_in);
                    message.setText("Purchase successfully, you have $"+a.getMoney()+" currently!");
                }
                else
                    message.setText("You don't have enough money");
            }
            else{
                message.setText("Invalid Input!!!");
            }
        }
       });
    }
    public static void Sell(Player a){
        int sellable=0;
        for(int x=0;x<a.getNumofAsset();x++)
        {
            if(a.getAsset(x).getCanBeSold())
                sellable++;
        }
        Asset[] sellList=new Asset[13];
        int index=0;
        for(int x=0; x<a.getNumofAsset();x++){
            if(a.getAsset(x).getCanBeSold()){
                sellList[index]=a.getAsset(x);
                index++;
            }
         }
        JFrame frame=new JFrame("Sell");
        frame.setSize(900,900);
        frame.setLayout(null);
        JLabel message=new JLabel("What do you want to sell.");
        message.setBounds(50,150,800,30);
        frame.add(message);
        JButton back=new JButton("Back");
        JPanel backp=new JPanel();
        backp.setBounds(600,700,100,30);
        backp.add(back);
        frame.add(backp);
        JLabel[] slot=new JLabel[13];
        JButton[] sell=new JButton[13];
        JPanel[] sellp=new JPanel[13];
        for(int x=0;x<13;x++){
            sell[x]=new JButton("Sell");
            sellp[x]=new JPanel();
            slot[x]=new JLabel();
            if(sellList[x]!=null){
                int n=x;
                slot[x].setText((x+1)+". "+sellList[x].getName()+", worth: $"+sellList[x].getPrice());
                sell[x].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent evt){
                        a.soldAsset(sellList[n].getName());
                        a.earn(sellList[n].getPrice());
                        sellp[n].setVisible(false);
                        slot[n].setVisible(false);
                        message.setText("Sold! Now you have $"+a.getMoney());
                    }
                
                });
            }
            else{
                slot[x].setVisible(false);
                sellp[x].setVisible(false);
            }
            sellp[x].add(sell[x]);
            sellp[x].setBounds(400,200+40*x,100,30);
            slot[x].setBounds(100,200+40*x,300,30);
            frame.add(sellp[x]);
            frame.add(slot[x]);
        }
        frame.setVisible(true);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                frame.dispose();
                homeScreen(a);
            }
        });
    }
    public static void Next(Player a){
        update(a);
        double lost=0;
        double income=0;
        double livingCost=(501*Math.random())+1000;
        for(int x=0;x<a.getNumofAsset();x++){
            income+=a.getAsset(x).Income();
            lost+=a.getAsset(x).getLost();
        }
        if(a.nHouse<1)
            livingCost+=700;
        //System.out.println("Lost:"+lost);
        //System.out.println("Income"+income);

        //a.spend(lost);
        //a.earn(income);

        int unexpect=((int)(10*Math.random()))+1;
        int unexpectedfee=0;
        if(unexpect>=8){
            unexpectedfee=((int)(10000*Math.random()))+1;
            //System.out.println("unexpected fee:"+unexpectedfee);
            //a.spend(unexpectedfee);
        }

        JFrame frame=new JFrame("Result");
        frame.setSize(900,900);
        frame.setLayout(null);
        JButton next=new JButton("Next");
        JPanel nextp=new JPanel();
        nextp.add(next);
        JLabel result=new JLabel("Round result:");
        result.setFont(new Font("Verdana", Font.BOLD, 30));
        JLabel balancel=new JLabel("Balance: $"+a.getMoney());
        JLabel incomel=new JLabel("Income: $"+income);
        JLabel livingCostl=new JLabel("Cost of living: $"+livingCost);
        JLabel lostl=new JLabel("Lost: $"+lost);
        JLabel upexpectedfeel=new JLabel("Unexpected fee: $"+unexpectedfee);
        a.earn(income);
        a.spend(livingCost+lost+unexpectedfee);
        JLabel moneyleft=new JLabel("Money left: $"+a.getMoney());
        result.setBounds(100,190,500,30);
        nextp.setBounds(600,600,100,30);
        balancel.setBounds(100,250,500,30);
        incomel.setBounds(100,300,500,30);
        livingCostl.setBounds(100,350,500,30);
        lostl.setBounds(100,400,500,30);
        upexpectedfeel.setBounds(100,450,500,30);
        moneyleft.setBounds(150,500,500,30);
        frame.add(result);
        frame.add(balancel);
        frame.add(incomel);
        frame.add(livingCostl);
        frame.add(lostl);
        frame.add(upexpectedfeel);
        frame.add(moneyleft);
        frame.add(nextp);
        frame.setVisible(true);
        next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                frame.dispose();
                //win
                if(a.getMoney()>100000||a.roundIndex>=5)
                {
                    win(a);
                }
                //lose
                else if(a.getMoney()<0)
                {
                    lose(a);
                }
                else
                {
                    a.roundIndex++;
                    homeScreen(a);
                }
            }
        });
        
    }
    public static void update(Player a){
        a.canApplyJob=true;
        String business="Business";
        String house="House";
        String car="Car";
        String stock="Stock";
        String savings="Savings Plan";
        for(int x=0;x<a.getNumofAsset();x++){
            if(a.getAsset(x).getCanBeSold())
            {
                if(a.getAsset(x).getName().indexOf(business)>=0){
                    double rate = ((int)(7*Math.random()))-3 ;
                    rate=rate/10+1;
                    a.getAsset(x).setPrice(rate * a.getAsset(x).getPrice());

                    a.getAsset(x).setIncome(((int)(3000*Math.random()))+1 );

                    int lostornot=((int)(10*Math.random()))+1;
                    if(lostornot>=4)
                        a.getAsset(x).setLost(((int)(5000*Math.random()))+1);
                }
                else if(a.getAsset(x).getName().indexOf(house)>=0){
                    double rate = ((int)(3*Math.random()))-1 ;
                    rate=rate/10+1;
                    a.getAsset(x).setPrice(rate * a.getAsset(x).getPrice());
                }
                else if(a.getAsset(x).getName().indexOf(car)>=0){
                    a.getAsset(x).setPrice(0.7 * a.getAsset(x).getPrice());
                }
                else if(a.getAsset(x).getName().indexOf(stock)>=0){
                    double rate = ((int)(11*Math.random()))-5;
                    rate=rate/10+1;
                    a.getAsset(x).setPrice(rate * a.getAsset(x).getPrice());

                    a.getAsset(x).setIncome(((int)(500*Math.random()))+1 );
                } 
                else if(a.getAsset(x).getName().indexOf(savings)>=0){
                    a.getAsset(x).setPrice(1.05 * a.getAsset(x).getPrice());
                }
            }
        }
    }
    public static void win(Player a){
        //a.Player();
        //System.out.println("You win");
        JFrame frame=new JFrame("You win!!");
        frame.setSize(900,900);
        frame.setLayout(null);
        JButton next=new JButton("Next");
        JPanel nextp=new JPanel();
        nextp.add(next);
        nextp.setBounds(350,700,200,30);
        JLabel youwin=new JLabel("Wohoo! You win!");
        youwin.setBounds(100,100,800,60);
        youwin.setFont(new Font("Tahoma", Font.PLAIN, 60));
        frame.add(youwin);
        frame.add(nextp);
        frame.setVisible(true);
        next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                frame.dispose();
                startGame();                
            }
        });
    }

    public static void lose(Player a){
        //a.Player();
        //System.out.println("You lost");
        JFrame frame=new JFrame("You lost!!");
        frame.setSize(900,900);
        frame.setLayout(null);
        JButton next=new JButton("Next");
        JPanel nextp=new JPanel();
        nextp.add(next);
        nextp.setBounds(350,700,200,30);
        JLabel youlost=new JLabel("You lost!");
        youlost.setBounds(100,100,800,60);
        youlost.setFont(new Font("Tahoma", Font.PLAIN, 60));
        frame.add(youlost);
        frame.add(nextp);
        
        frame.setVisible(true);
        next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                frame.dispose();
                startGame();                
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
