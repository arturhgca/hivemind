package arturhgca.hivemind.monitoring.stats.service

import arturhgca.hivemind.core.container.docker.service.DockerCommandExecutor
import arturhgca.hivemind.monitoring.stats.model.Stats
import spock.lang.Shared
import spock.lang.Specification

class StatsServiceTest extends Specification {
    @Shared
    def statsService
    @Shared
    def commandExecutor

    def setup() {
        commandExecutor = Mock(DockerCommandExecutor)
        statsService = new StatsService(commandExecutor)
    }

    def "should get a Stats object for a given running container"() {
        given: "a running container"
        def containerName = "potato"

        when: "we want to get the stats for this container"
        def result = statsService.get(containerName)

        then: "a Stats object should be returned in an Optional"
        result.isPresent()
        result.get().class == Stats.class
    }

    def "should not get a Stats object for a given non-running container"() {
        given: "a non-running container"
        def containerName = "eggplant"

        when: "we want to get the stats for this container"
        def result = statsService.get(containerName)

        then: "an empty Optional should be returned"
        !result.isPresent()
    }
}
