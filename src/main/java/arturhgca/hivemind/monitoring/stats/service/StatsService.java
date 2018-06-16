package arturhgca.hivemind.monitoring.stats.service;

import arturhgca.hivemind.core.container.docker.service.DockerCommandExecutor;
import arturhgca.hivemind.core.exception.CommandException;
import arturhgca.hivemind.monitoring.stats.model.Stats;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class StatsService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(StatsService.class);
    private static final String COMMAND = "stats ${containerName} --no-stream --format ${format}";
    private static final String FORMAT = "\"{\\\"containerId\\\": \\\"{{.ID}}\\\", \\\"name\\\": \\\"{{.Name}}\\\", \\\"pids\\\": \\\"{{.PIDs}}\\\", \\\"relativeCpuUsage\\\": \\\"{{.CPUPerc}}\\\", \\\"absoluteMemUsage: \\\"{{.MemUsage}}\\\", \\\"relativeMemUsage\\\": \\\"{{.MemPerc}}\\\", \\\"netIo\\\": \\\"{{.NetIO}}\\\", \\\"blockIo\\\": \\\"{{.BlockIO}}\\\"}\"";
    private DockerCommandExecutor dockerCommandExecutor;

    public StatsService(DockerCommandExecutor dockerCommandExecutor) {
        this.dockerCommandExecutor = dockerCommandExecutor;
    }

    public Optional<Stats> get(String containerName) {
        try {
            String rawResponse = dockerCommandExecutor.execute(COMMAND, containerName, FORMAT);
            return Optional.of(parse(rawResponse));
        } catch (CommandException e) {
            LOG.error("Could not execute command", e);
            return Optional.empty();
        } catch (IOException e) {
            LOG.error("Could not parse command result", e);
            return Optional.empty();
        }
    }

    private Stats parse(String rawResponse) throws IOException {
        JSONPObject jsonpObject = objectMapper.readValue(rawResponse, JSONPObject.class);
        // TODO: build stats
        return null;
    }
}
