
public class TennisGame2 implements TennisGame
{
    public int player1Points = 0;
    public int player2Poimts = 0;
    
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
        
        if (player1Points > player2Poimts && player2Poimts >= 3)
        {
            score = "Advantage player1";
        }
        
        if (player2Poimts > player1Points && player1Points >= 3)
        {
            score = "Advantage player2";
        }
        
        if (player1Points>=4 && player2Poimts>=0 && (player1Points-player2Poimts)>=2)
        {
            score = "Win for player1";
        }
        if (player2Poimts>=4 && player1Points>=0 && (player2Poimts-player1Points)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

	private String normal3(String score) {
		if (player2Poimts>player1Points && player2Poimts < 4)
        {
            if (player2Poimts==2)
                P2res="Thirty";
            if (player2Poimts==3)
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
		if (player1Points>player2Poimts && player1Points < 4)
        {
            if (player1Points==2)
                P1res="Thirty";
            if (player1Points==3)
                P1res="Forty";
            if (player2Poimts==1)
                P2res="Fifteen";
            if (player2Poimts==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String normal1(String score) {
		if (player2Poimts > 0 && player1Points==0)
        {
            if (player2Poimts==1)
                P2res = "Fifteen";
            if (player2Poimts==2)
                P2res = "Thirty";
            if (player2Poimts==3)
                P2res = "Forty";
            
            P1res = "Love";
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String normal(String score) {
		String p1resp2="";
		if (player1Points > 0 && player2Poimts==0)
        {
			p1resp2=P1res;
            p1resp2 = getLiteral(player1Points);
            if (player1Points==2)
            	p1resp2 = "Thirty";
            if (player1Points==3)
            	p1resp2 = "Forty";
            P1res=p1resp2;
            
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
		return score;
	}

	private String getLiteral(int playerPoints) {
		String result="";
		if (playerPoints==1)
			result = "Fifteen";
		return result;
	}

	private String deuce(String score) {
		if (player1Points==player2Poimts && player1Points>=3)
            score = "Deuce";
		return score;
	}

	private String tie(String score) {
		if (player1Points == player2Poimts && player1Points < 4)
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
        player2Poimts++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}