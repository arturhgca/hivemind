package arturhgca.hivemind.core.container.docker.service;

import arturhgca.hivemind.core.exception.CommandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class DockerCommandExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(DockerCommandExecutor.class);
    private static final Runtime RUNTIME = Runtime.getRuntime();

    public String execute(String baseCommand, String... arguments) throws CommandException {
        String command = buildCommand(baseCommand, arguments);
        return runCommand(command);
    }

    private String buildCommand(String baseCommand, String... arguments) throws CommandException {
        // TODO
        return null;
    }

    private String runCommand(String command) throws CommandException {
        // TODO
        String output;
        try {
            Process process = RUNTIME.exec(command);
            process.waitFor();
            validateResult(process);
            output = parseProcessOutput(process);
        } catch (IOException | InterruptedException e) {
            String message = "Inner process error while executing command";
            LOG.error(message);
            throw new CommandException(message);
        }
        return output;
    }

    private String parseProcessOutput(Process process) {
        StringBuilder output = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                output.append(line).append("\n");
            }
        } catch (IOException e) {
            // TODO
            e.printStackTrace();
        }

        return output.toString();
    }

    private void validateResult(Process process) {
        // TODO
    }
}
