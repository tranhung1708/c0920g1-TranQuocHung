package session_8.BaiTap;

public class TennisGame {
    public static String getScore(String playerOne, String playerTwo, int scored, int scoreds) {
        String score = "";
        int temporaryPoint = 0;
        if (scored == scoreds) {
            switch (scored) {
                case 0:
                    score = "Love-All";
                    break;
                case 1:
                    score = "Fifteen-All";
                    break;
                case 2:
                    score = "Thirty-All";
                    break;
                case 3:
                    score = "Forty-All";
                    break;
                default:
                    score = "Deuce";
                    break;

            }
        } else if (scored >= 4 || scoreds >= 4) {
            int minusResult = scored - scoreds;
            if (minusResult == 1) score = "Advantage player1";
            else if (minusResult == -1) score = "Advantage player2";
            else if (minusResult >= 2) score = "Win for player1";
            else score = "Win for player2";
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) temporaryPoint = scored;
                else {
                    score += "-";
                    temporaryPoint = scoreds;
                }
                switch (temporaryPoint) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
            }
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(getScore("hung" , "huong" ,2,3));
    }
}
