class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        int temp = 2*n;
        int count = 0;
        find(count,temp,list,"");
        return list;
    }
    public void find(int count,int temp,List<String> list, String s1){
        if(count==temp){
            if(isValid(s1)){
                list.add(s1);
            }
            return;
        }
        find(count+1,temp,list,s1 + "(");
        find(count+1,temp,list,s1 + ")");
    }
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch=='{' || ch=='['){
                if(ch=='('){
                    stack.add(')');
                }
                else if(ch=='{'){
                    stack.add('}');
                }
                else{
                    stack.add(']');
                }
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                else{
                    char ch1 = stack.pop();
                    if(ch!=ch1){
                        return false;
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
