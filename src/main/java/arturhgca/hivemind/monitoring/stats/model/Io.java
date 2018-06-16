package arturhgca.hivemind.monitoring.stats.model;

public class Io {
    private double netIn;
    private double netOut;
    private double blockIn;
    private double blockOut;

    public double getNetIn() {
        return netIn;
    }

    public void setNetIn(double netIn) {
        this.netIn = netIn;
    }

    public double getNetOut() {
        return netOut;
    }

    public void setNetOut(double netOut) {
        this.netOut = netOut;
    }

    public double getBlockIn() {
        return blockIn;
    }

    public void setBlockIn(double blockIn) {
        this.blockIn = blockIn;
    }

    public double getBlockOut() {
        return blockOut;
    }

    public void setBlockOut(double blockOut) {
        this.blockOut = blockOut;
    }
}
