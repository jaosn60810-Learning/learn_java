package com.company;

public class Computer {
    public enum ComputerLogo {
        ASUS,
        ACER,
        MSI;
    }

    public enum ComputerRam {
        RAM1(4),
        RAM2(8),
        RAM3(16);

        int ram;

        ComputerRam(int ram) {
            this.ram = ram;
        }
    }

    public enum ComputerCpu {
        CPU1("i3"),
        CPU2("i5"),
        CPU3("i7");

        String cpu;

        ComputerCpu(String cpu) {
            this.cpu = cpu;
        }
    }

    public enum ComputerType {
        DESK,
        NOTEBOOK;
    }

    private ComputerLogo computerLogo;
    private ComputerRam ram;
    private ComputerCpu cpu;
    private ComputerType type;

    public Computer(ComputerLogo computerLogo) {
        this.computerLogo = computerLogo;
    }

    public ComputerLogo getComputerLogo() {
        return computerLogo;
    }

    public void setComputerLogo(ComputerLogo computerLogo) {
        this.computerLogo = computerLogo;
    }

    public ComputerRam getRam() {
        return ram;
    }

    public void setRam(ComputerRam ram) {
        this.ram = ram;
    }

    public ComputerCpu getCpu() {
        return cpu;
    }

    public void setCpu(ComputerCpu cpu) {
        this.cpu = cpu;
    }

    public ComputerType getType() {
        return type;
    }

    public void setType(ComputerType type) {
        this.type = type;
    }
}
