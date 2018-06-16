package arturhgca.hivemind.monitoring.stats.model;

public class Resources {
    private Compute compute;
    private Io io;

    public Compute getCompute() {
        return compute;
    }

    public void setCompute(Compute compute) {
        this.compute = compute;
    }

    public Io getIo() {
        return io;
    }

    public void setIo(Io io) {
        this.io = io;
    }
}
