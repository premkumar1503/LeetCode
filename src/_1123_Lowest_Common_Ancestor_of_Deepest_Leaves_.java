class Solution14
{
    public static class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val)
        {
            this.val = val;
        }
    }

    private static class Result
    {
        TreeNode node;
        int depth;

        Result(TreeNode node, int depth)
        {
            this.node = node;
            this.depth = depth;
        }
    }

    public static TreeNode lcaDeepestLeaves(TreeNode root)
    {
        return dfs(root).node;
    }

    private static Result dfs(TreeNode node)
    {
        if (node == null)
        {
            return new Result(null, 0);
        }

        Result left = dfs(node.left);
        Result right = dfs(node.right);

        if (left.depth == right.depth)
        {
            return new Result(node, left.depth + 1);
        } else if (left.depth > right.depth)
        {
            return new Result(left.node, left.depth + 1);
        }
        else
        {
            return new Result(right.node, right.depth + 1);
        }
    }
}

public class _1123_Lowest_Common_Ancestor_of_Deepest_Leaves_
{
    public static void main(String[] args) {
        /*
            Tree:
                   3
                  / \
                 5   1
                /   / \
               6   0   8
                      /
                     9

            Deepest leaves = 6 and 9 → LCA = 3
        */
        Solution14.TreeNode root = new Solution14.TreeNode(3);
        root.left = new Solution14.TreeNode(5);
        root.right = new Solution14.TreeNode(1);
        root.left.left = new Solution14.TreeNode(6);
        root.right.left = new Solution14.TreeNode(0);
        root.right.right = new Solution14.TreeNode(8);
        root.right.right.left = new Solution14.TreeNode(9);

        Solution14 solution = new Solution14();
        Solution14.TreeNode lca = Solution14.lcaDeepestLeaves(root);
        System.out.println("LCA of deepest leaves: " + (lca != null ? lca.val : "null"));
    }
}
