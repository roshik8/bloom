import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {

        Path path = Paths.get(
                ClassLoader.getSystemResource("spotify_data.csv").toURI());

        try (Reader reader = Files.newBufferedReader(path)) {
            var spf = new CsvToBeanBuilder(reader).withIgnoreQuotations(true) .withThrowExceptions(false)
                    .withType(SpotifySong.class)
                    .build();
            List<SpotifySong> lines = spf.parse();

            SpotifyBloomFilter spotifyBloomFilter = new SpotifyBloomFilter();

            lines.forEach(song -> spotifyBloomFilter.addTrackName(song.trackName));

            String testTracks[] = new String[] {
                    "Watching You Watch Him",
                    "MANIAC",
                    "ganesh"
            };

            for (String track : testTracks) {
                boolean available = spotifyBloomFilter.exists(track);
                String message = String.format("%s is %s", track, available ? "available" : "not available");
                System.out.println(message);
            }

        }

    }
}
