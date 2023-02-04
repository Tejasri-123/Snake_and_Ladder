class player{
    private String player_name;
    private int position;

    player(String player_name, int position) {
        this.player_name = player_name;
        this.position = 0;

    }

    public String getPlayerName() {
        return player_name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String toString() {
        return player_name + " " + position;
    }
}