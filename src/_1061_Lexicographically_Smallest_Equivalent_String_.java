class SmallestEquivalentString
{
    static int[] parent = new int[26];

    public static String smallestEquivalentString(String s1, String s2, String baseStr)
    {
        for (int i = 0; i < 26; i++)
        {
            parent[i] = i;
        }
        for (int i = 0; i < s1.length(); i++)
        {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder result = new StringBuilder();
        for (char c : baseStr.toCharArray())
        {
            int root = find(c - 'a');
            result.append((char) (root + 'a'));
        }
        return result.toString();
    }
    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    private static void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rootX < rootY)
        {
            parent[rootY] = rootX;
        }
        else
        {
            parent[rootX] = rootY;
        }
    }
}
public class _1061_Lexicographically_Smallest_Equivalent_String_
{
    public static void main(String[] args)
    {
        String s1 = "parker";
        String s2 = "morris";
        String baseStr = "parser";

        String result = SmallestEquivalentString.smallestEquivalentString(s1, s2, baseStr);
        System.out.println("Lexicographically Smallest Equivalent String: " + result);
    }
}
