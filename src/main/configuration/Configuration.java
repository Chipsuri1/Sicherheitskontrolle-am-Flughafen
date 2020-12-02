package main.configuration;

public enum Configuration {
    instance;

    public static final int NUMBER_OF_PASSENGERS = 568;
    public static final int NUMBER_OF_BAGGAGE = 609;
    public static final int NUMBER_OF_CONTENT_PER_LAYER = 10000;

    public static final String DATA_FILEPATH = "C:\\Users\\lthomai\\Desktop\\DHBW\\3. Semester\\Software Engineering\\SicherheitskontrolleAmFlughafen\\resources\\passenger_baggage.txt";

    public static MersenneTwister mersenneTwister = new MersenneTwister();
    public static DataGenerator dataGenerator = new DataGenerator();
    public static FileReader fileReader = new FileReader();
    public static AES aes = new AES();

}
