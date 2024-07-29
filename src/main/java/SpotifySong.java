import com.opencsv.bean.CsvBindByName;

public class SpotifySong {
    @CsvBindByName(column = "id")
    private Integer id;
    @CsvBindByName(column = "artist_name")
    private String artistName;
    @CsvBindByName(column = "track_name")
    public String trackName;
    @CsvBindByName(column = "track_id")
    private String trackId;
    @CsvBindByName(column = "popularity")
    private String popularity;
    @CsvBindByName(column = "year")
    private int year;
    @CsvBindByName(column = "genre")
    private String genre;
    @CsvBindByName(column = "danceability")
    private double danceability;
    @CsvBindByName(column = "energy")
    private double energy;
    @CsvBindByName(column = "key")
    private String key;
    @CsvBindByName(column = "loudness")
    private String loudness;
    @CsvBindByName(column = "mode")
    private String mode;
    @CsvBindByName(column = "speechiness")
    private String speechiness;
    @CsvBindByName(column = "acousticness")
    private double acousticness;
    @CsvBindByName(column = "instrumentalness")
    private double instrumentalness;
    @CsvBindByName(column = "liveness")
    private double liveness;
    @CsvBindByName(column = "valence")
    private double valence;
    @CsvBindByName(column = "tempo")
    private double tempo;
    @CsvBindByName(column = "duration_ms")
    private int durationMs;
    @CsvBindByName(column = "time_signature")
    private int timeSignature;
}
