/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode temp = root;
        while (temp != null) {
            TreeLinkNode inner = temp;
            while (inner != null) {
                if (inner.left != null) {
                    inner.left.next = inner.right;
                }
                if (inner.right != null && inner.next != null) {
                    inner.right.next = inner.next.left;
                }
                inner = inner.next;
            }
            temp = temp.left;
        }
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        // recursion终止条件
        if (root == null || root.left == null) {
            return;
        }
        
        // 把当前这一层要干的全部事情说清楚
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        
        // 进入左右子树的递归
        connect(root.left);
        connect(root.right);
    }
}

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node prev = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (prev != null) {
                    prev.next = cur;
                }
                prev = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            prev = null;
        }
        return root;
    }
}
