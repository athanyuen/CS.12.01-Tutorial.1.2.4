public class WordMatch {
    private String word;
    public WordMatch(String word){
        this.word = word;
    }
    public int scoreGuess(String guess){
        if(guess.equals("")){
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if (guess.length() > word.length()) {
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }
        int diff = word.length() - guess.length() + 1;
        int ans = 0;
        for(int i = 0; i < diff; i++){
            if(word.startsWith(guess, i))
                ans++;
        }
        return ans * guess.length() * guess.length();
    }
    public String findBetterGuess(String guess1, String guess2){
        int score1 = scoreGuess(guess1), score2 = scoreGuess(guess2);
            if(score1 == score2){
                if(guess1.compareTo(guess2) > 0)
                    return guess1;

                else return guess2;
            }
            else if(score1 > score2)
                return guess1;
            else return guess2;
    }
}
