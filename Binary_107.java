import java.util.LinkedList;
import java.util.List;

class Binary_107 {

	// Refer to 102 for another solution, just change res.add(level) to res.add(0, level)
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        // We can also copy the code in Binary_102, and then Collections.reverse(wrapList);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) list.add(0, new LinkedList<Integer>());
        list.get(list.size()-level-1).add(root.val);
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        // list.get(list.size()-level-1).add(root.val);
        // Either pre-order or post-order is OK here.
    }
}