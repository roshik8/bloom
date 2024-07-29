
import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

public class SpotifyBloomFilter {

    private BloomFilter<String> trackNameSet;

    public SpotifyBloomFilter() {
        Funnel<String> trackNameFunnel = new Funnel<String>() {
            @Override
            public void funnel(String trackName, PrimitiveSink sink) {
                sink.putString(trackName, Charsets.UTF_8);
            }
        };

        trackNameSet = BloomFilter.create(trackNameFunnel, 1000000, 0.02);
    }

    public void addTrackName(String trackName) {
        trackNameSet.put(trackName);
    }

    public boolean exists(String trackName) {
        return trackNameSet.mightContain(trackName);
    }
}
