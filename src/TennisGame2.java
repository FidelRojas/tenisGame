
public class TennisGame2 implements TennisGame
{
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
        score = normal1(score);
        
        score = normal2(score);
        score = normal3(score);
        
        if (player1Points > player2Points && player2Points >= 3)
        {
            score = "Advantage player1";
        }
        
        if (player2Points > player1Points && player1Points >= 3)
        {
            score = "Advantage player2";
        }
        
        if (player1Points>=4 && player2Points>=0 && (player1Points-player2Points)>=2)
        {
            score = "Win for player1";
        }
        if (player2Points>=4 && player1Points>=0 && (player2Points-player1Points)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

	private String normal3(String score) {
		if (player2Points>player1Points && player2Points < 4)
        {
            if (player2Points==2)
                P2res="Thirty";
            if (player2Points==3)
                P2res="Forty";
            if (player1Points==1)
                P1res="Fifteen";
            if (player1Points==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String normal2(String score) {
		if (player1Points>player2Points && player1Points < 4)
        {
            if (player1Points==2)
                P1res="Thirty";
            if (player1Points==3)
                P1res="Forty";
            if (player2Points==1)
                P2res="Fifteen";
            if (player2Points==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String normal1(String score) {
		if (player2Points > 0 && player1Points==0)
        {
            if (player2Points==1)
                P2res = "Fifteen";
            if (player2Points==2)
                P2res = "Thirty";
            if (player2Points==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String normal(String score) {
	
		if (player1Points > 0 && player2Points==0)
        {
			
            P1res = getLiteral(player1Points);
            
            P2res=getLiteral(player2Points);
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String getLiteral(int playerPoints) {
		String result="";
		if(playerPoints==0)
			result = "Love";
		if (playerPoints==1)
			result = "Fifteen";
		if (playerPoints==2)
			result = "Thirty";
        if (playerPoints==3)
        	result = "Forty";
		return result;
	}

	private String deuce(String score) {
		if (player1Points==player2Points && player1Points>=3)
            score = "Deuce";
		return score;
	}

	private String tie(String score) {
		if (player1Points == player2Points && player1Points < 4)
        {
            if (player1Points==0)
                score = "Love";
            if (player1Points==1)
                score = "Fifteen";
            if (player1Points==2)
                score = "Thirty";
            score += "-All";
        }
		return score;
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