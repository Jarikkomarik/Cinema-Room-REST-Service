class SimpleCounter {
    public int counter;
    private static SimpleCounter instance = new SimpleCounter();

    private SimpleCounter(){};

    public static SimpleCounter getInstance(){
        return instance;
    }
}