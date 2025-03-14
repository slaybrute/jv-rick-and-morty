package mate.academy.rickandmorty.controller.external;

import io.swagger.v3.oas.annotations.Operation;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.dto.external.episode.EpisodeDto;
import mate.academy.rickandmorty.dto.external.episode.EpisodeSearchParameters;
import mate.academy.rickandmorty.dto.external.episode.EpisodesDto;
import mate.academy.rickandmorty.service.client.EpisodeClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/external/episode")
public class ExternalEpisodeController {
    private final EpisodeClient episodeClient;

    @GetMapping
    @Operation(summary = "Get all episodes",
            description = "Get all available episodes + pagination")
    public EpisodesDto getEpisodes() throws IOException, InterruptedException {
        return episodeClient.getEpisodes();
    }

    @GetMapping("/{ids}")
    @Operation(summary = "Get episodes by ids", description = "Get episodes by ids")
    public List<EpisodeDto> getEpisodesByIds(@PathVariable Integer... ids)
            throws IOException, InterruptedException {
        return episodeClient.getEpisodesByIds(ids);
    }

    @GetMapping("/search")
    @Operation(summary = "Search episodes by parameters",
            description = "Search episodes by name, episode")
    public EpisodesDto getEpisodesByParams(
            @RequestParam EpisodeSearchParameters episodeSearchParameters)
            throws IOException, InterruptedException {
        return episodeClient.getEpisodesByParams(episodeSearchParameters);
    }
}
