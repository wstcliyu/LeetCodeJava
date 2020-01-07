import java.util.Stack;

class Simplify_71 {
    // My first solution
    public String simplifyPath(String path) {
        String[] data = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String name : data) {
            if (name.isEmpty() || name.equals(".")) continue;
            if (name.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(name);
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}