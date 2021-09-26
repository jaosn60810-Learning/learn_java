package com.company;


public class Main {

    public static void main(String[] args) {

        // 第一階段
        // 創建品牌陣列
        Computer.ComputerLogo[] computerLogo = {Computer.ComputerLogo.ASUS, Computer.ComputerLogo.ACER, Computer.ComputerLogo.MSI};
        // 隨機選一個
        Computer computer = new Computer(computerLogo[random(0, 2)]);
        // 印出購買的品牌
        System.out.println("購買了 " + computer.getComputerLogo() + " 電腦");

        // 第二階段
        // 創建 RAM 陣列
        Computer.ComputerRam[] computerRams = {Computer.ComputerRam.RAM1, Computer.ComputerRam.RAM2, Computer.ComputerRam.RAM3};
        // 隨機選一個
        computer.setRam(computerRams[random(0, 2)]);
        // 創建 CPU 陣列
        Computer.ComputerCpu[] computerCpus = {Computer.ComputerCpu.CPU1, Computer.ComputerCpu.CPU2, Computer.ComputerCpu.CPU3};
        // 隨機選一個
        computer.setCpu(computerCpus[random(0, 2)]);
        // 印出購買的規格
        System.out.println("--------規格--------");
        System.out.println("記憶體: " + computer.getRam().ram + " GB");
        System.out.println("CPU: " + computer.getCpu().cpu);

        // 第三階段
        // 創建電腦類型陣列
        Computer.ComputerType[] computerTypes = {Computer.ComputerType.DESK, Computer.ComputerType.NOTEBOOK};
        // 隨機選一個
        computer.setType(computerTypes[random(0, 1)]);
        // 印出購買的規格
        System.out.println("--------開機測試--------");
        // 根據不同電腦種類決定印出內容
        switch (computer.getType()) {
            // 如果是筆電
            case NOTEBOOK:
                System.out.println("筆記型電腦");
                System.out.println("記憶體效能: " + computer.getRam().ram / 2 + "GB");
                System.out.println("CPU: " + computer.getCpu().cpu + " U");
                break;
            // 如果是桌機
            case DESK:
                System.out.println("桌上型電腦");
                System.out.println("記憶體效能: " + computer.getRam().ram + " GB");
                System.out.println("CPU: " + computer.getCpu().cpu);
                break;
            default:
                System.out.println("沒有這種款式");
                break;
        }

        // 第四階段
        // 創建變數計算價格
        int sumMoney = 0;
        // 根據不同 RAM 決定價格
        switch (computer.getRam()) {
            case RAM1:
                sumMoney += 550;
                break;
            case RAM2:
                sumMoney += 1000;
                break;
            case RAM3:
                sumMoney += 1800;
                break;
            default:
                System.out.println("沒有這種款式");
                break;
        }
        // 根據不同 CPU 決定價格
        switch (computer.getCpu()) {
            case CPU1:
                sumMoney += 3000;
                break;
            case CPU2:
                sumMoney += 5000;
                break;
            case CPU3:
                sumMoney += 6888;
                break;
            default:
                System.out.println("沒有這種款式");
                break;
        }
        // 根據不同電腦類型決定價格
        switch (computer.getType()) {
            case NOTEBOOK:
                sumMoney += 20000;
                break;
            case DESK:
                sumMoney += 10000;
                break;
            default:
                System.out.println("沒有這種款式");
                break;
        }
        // 印出總價
        System.out.println("--------總價--------");
        System.out.println(sumMoney + " 元");

        // 第五階段
        System.out.println();
        System.out.println("第五階段");
        // 隨機選取要買的電腦數量
        int buyPCNum = random(1, 5);
        // 購買電腦 Function
        buyPC(buyPCNum);

    }

    /** 在最大值和最小值之間隨機選數字
     * @param min 最小值
     * @param max 最大值
     * @return 隨機數字
     */
    public static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    /** 將階段一到四合併，將輸出格式更改成符合題目的方式，並計算總價
     * @param buyPCNum 要買的電腦數量
     */
    public static void buyPC(int buyPCNum) {
        // 買的所有電腦總價
        int totalPrice = 0;
        for (int i = 0; i < buyPCNum; i++) {
            // 第一階段

            Computer.ComputerLogo[] computerLogo = {Computer.ComputerLogo.ASUS, Computer.ComputerLogo.ACER, Computer.ComputerLogo.MSI};
            Computer computer = new Computer(computerLogo[random(0, 2)]);

            // 第二階段
            Computer.ComputerRam[] computerRams = {Computer.ComputerRam.RAM1, Computer.ComputerRam.RAM2, Computer.ComputerRam.RAM3};
            computer.setRam(computerRams[random(0, 2)]);
            Computer.ComputerCpu[] computerCpus = {Computer.ComputerCpu.CPU1, Computer.ComputerCpu.CPU2, Computer.ComputerCpu.CPU3};
            computer.setCpu(computerCpus[random(0, 2)]);

            // 第三階段
            Computer.ComputerType[] computerTypes = {Computer.ComputerType.DESK, Computer.ComputerType.NOTEBOOK};
            computer.setType(computerTypes[random(0, 1)]);
            switch (computer.getType()) {
                case NOTEBOOK:
                    System.out.println("買了筆記型電腦");
                    break;
                case DESK:
                    System.out.println("買了桌上型電腦");
                    break;
                default:
                    System.out.println("沒有這種款式");
                    break;
            }

            // 第四階段
            int sumMoney = 0;
            switch (computer.getRam()) {
                case RAM1:
                    sumMoney += 550;
                    break;
                case RAM2:
                    sumMoney += 1000;
                    break;
                case RAM3:
                    sumMoney += 1800;
                    break;
                default:
                    System.out.println("沒有這種款式");
                    break;
            }

            switch (computer.getCpu()) {
                case CPU1:
                    sumMoney += 3000;
                    break;
                case CPU2:
                    sumMoney += 5000;
                    break;
                case CPU3:
                    sumMoney += 6888;
                    break;
                default:
                    System.out.println("沒有這種款式");
                    break;
            }

            switch (computer.getType()) {
                case NOTEBOOK:
                    sumMoney += 20000;
                    break;
                case DESK:
                    sumMoney += 10000;
                    break;
                default:
                    System.out.println("沒有這種款式");
                    break;
            }
            // 將這台電腦的價格加到總價中
            totalPrice += sumMoney;
            System.out.println("購買了 " + computer.getComputerLogo() + " 電腦");
            System.out.println("--------規格--------");
            System.out.println("記憶體: " + computer.getRam().ram + " GB");
            System.out.println("CPU: " + computer.getCpu().cpu);
            System.out.println("--------開機測試--------");
            // 因為沒有原本的值 而是更改輸出方式 所以要在這裡判斷是哪種電腦類型決定輸出方式
            switch (computer.getType()) {
                case NOTEBOOK:
                    System.out.println("筆記型電腦");
                    System.out.println("記憶體效能: " + computer.getRam().ram / 2 + "GB");
                    System.out.println("CPU: " + computer.getCpu().cpu + " U");
                    break;
                case DESK:
                    System.out.println("桌上型電腦");
                    System.out.println("記憶體效能: " + computer.getRam().ram + " GB");
                    System.out.println("CPU: " + computer.getCpu().cpu);
                    break;
                default:
                    System.out.println("沒有這種款式");
                    break;
            }
            System.out.println("--------總價--------");
            System.out.println(sumMoney + " 元");
            System.out.println();
        }
        System.out.println();
        // 印出買的所有電腦總價
        System.out.println(buyPCNum + " 台電腦 共 " + totalPrice + " 元");
    }
}


