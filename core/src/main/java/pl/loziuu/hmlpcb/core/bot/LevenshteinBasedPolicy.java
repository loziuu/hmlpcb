package pl.loziuu.hmlpcb.core.bot;

public class LevenshteinBasedPolicy implements CommandApplicablePolicy {
    private final int distanceBound;

    public LevenshteinBasedPolicy(int distanceBound) {
        this.distanceBound = distanceBound;
    }

    @Override
    public boolean isApplicable(String question, Command command) {
        int similarity = levenshteinDistance(question, command.getQuestion());
        return similarity <= distanceBound;
    }

    public int levenshteinDistance (CharSequence lhs, CharSequence rhs) {
        int len0 = lhs.length() + 1;
        int len1 = rhs.length() + 1;
        int[] cost = new int[len0];
        int[] newcost = new int[len0];
        for (int i = 0; i < len0; i++)
            cost[i] = i;
        for (int j = 1; j < len1; j++) {
            newcost[0] = j;
            for(int i = 1; i < len0; i++) {
                int match = (lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1;
                int cost_replace = cost[i - 1] + match;
                int cost_insert  = cost[i] + 1;
                int cost_delete  = newcost[i - 1] + 1;
                newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
            }
            int[] swap = cost; cost = newcost; newcost = swap;
        }
        return cost[len0 - 1];
    }
}
