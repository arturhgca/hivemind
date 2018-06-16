package arturhgca.hivemind.monitoring.stats.model;

public class Compute {
    private double relativeCpuUsage;
    private double absoluteMemUsage;
    private double memLimit;
    private double relativeMemUsage;

    public double getRelativeCpuUsage() {
        return relativeCpuUsage;
    }

    public void setRelativeCpuUsage(double relativeCpuUsage) {
        this.relativeCpuUsage = relativeCpuUsage;
    }

    public double getAbsoluteMemUsage() {
        return absoluteMemUsage;
    }

    public void setAbsoluteMemUsage(double absoluteMemUsage) {
        this.absoluteMemUsage = absoluteMemUsage;
    }

    public double getMemLimit() {
        return memLimit;
    }

    public void setMemLimit(double memLimit) {
        this.memLimit = memLimit;
    }

    public double getRelativeMemUsage() {
        return relativeMemUsage;
    }

    public void setRelativeMemUsage(double relativeMemUsage) {
        this.relativeMemUsage = relativeMemUsage;
    }
}
