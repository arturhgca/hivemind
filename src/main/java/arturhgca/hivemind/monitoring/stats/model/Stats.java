package arturhgca.hivemind.monitoring.stats.model;

public class Stats {
    private Metadata metadata;
    private Resources resources;

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public static class Builder {
        private Stats stats = new Stats();
        private Metadata metadata = new Metadata();
        private Resources resources = new Resources();
        private Compute compute = new Compute();
        private Io io = new Io();

        public Builder withContainerId(String containerId) {
            metadata.setContainerId(containerId);
            return this;
        }

        public Builder withName(String name) {
            metadata.setName(name);
            return this;
        }

        public Builder withPids(String pids) {
            metadata.setPids(pids);
            return this;
        }

        public Builder withRelativeCpuUsage(double relativeCpuUsage) {
            compute.setRelativeCpuUsage(relativeCpuUsage);
            return this;
        }

        public Builder withAbsoluteMemUsage(double absoluteMemUsage) {
            compute.setAbsoluteMemUsage(absoluteMemUsage);
            return this;
        }

        public Builder withMemLimit(double memLimit) {
            compute.setMemLimit(memLimit);
            return this;
        }

        public Builder withRelativeMemUsage(double relativeMemUsage) {
            compute.setRelativeMemUsage(relativeMemUsage);
            return this;
        }

        public Builder withNetIn(double netIn) {
            io.setNetIn(netIn);
            return this;
        }

        public Builder withNetOut(double netOut) {
            io.setNetOut(netOut);
            return this;
        }

        public Builder withBlockIn(double blockIn) {
            io.setBlockIn(blockIn);
            return this;
        }

        public Builder withBlockOut(double blockOut) {
            io.setBlockOut(blockOut);
            return this;
        }

        public Stats build() {
            resources.setCompute(compute);
            resources.setIo(io);
            stats.setMetadata(metadata);
            stats.setResources(resources);
            return stats;
        }
    }
}
