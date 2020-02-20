
public class TennisGame2 implements TennisGame
{
    private static final int _FORTY = 3;
	private static final int _THIRTY = 2;
	private static final int _LOVE = 1;
	private static final int _ZERO = 0;
	public int player1Points = 0;
    public int player2Points = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        score = tie(score);
        score = deuce(score);
        
        score = normal(score);
        
        if (isInAdvantage(player1Points,player2Points))
            score = "Advantage player1";
        if (isInAdvantage(player2Points,player1Points))
            score = "Advantage player2";
        
        if (isWiner(player1Points,player2Points))
            score = "Win for player1";
        if (isWiner(player2Points,player1Points))
            score = "Win for player2";
        return score;
    }

	

	private boolean isWiner(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints>=4 && secondPlayerPoints>=0 && (firstPlayerPoints-secondPlayerPoints)>=2;
	}

	private boolean isInAdvantage(int firstPlayerPoints, int secondPlayerPoints) {
		return firstPlayerPoints > secondPlayerPoints && secondPlayerPoints >= 3;
	}


	private String normal(String score) {
	
		if (player1Points != player2Points)
            score = getLiteral(player1Points) + "-" + getLiteral(player2Points);
		return score;
	}

	private String getLiteral(int playerPoints) {
		String result="";
		if(playerPoints==_ZERO)
			result = "Love";
		if (playerPoints==_LOVE)
			result = "Fifteen";
		if (playerPoints==_THIRTY)
			result = "Thirty";
        if (playerPoints==_FORTY)
        	result = "Forty";
		return result;
	}

	private String deuce(String score) {
		if (player1Points==player2Points && player1Points>=3)
            score = "Deuce";
		return score;
	}

	private String tie(String score) {
		if (isTie())
			return getLiteral(player1Points)+ "-All";
		return score;
	}

	private boolean isTie() {
		return player1Points == player2Points && player1Points < 4;
	}
    
    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1Score();
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2Score();
        }
            
    }
    
    public void P1Score(){
        player1Points++;
    }
    
    public void P2Score(){
        player2Points++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}