package com.learning.stack.simple;



import java.util.Stack;

/**
 * 2020-03-28
 *
 * 题目：
 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 
 都是有效的括号字符串。
 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。

 示例 1：
 输入："(()())(())"
 输出："()()()"
 解释：
 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。

 示例 2：
 输入："(()())(())(()(()))"
 输出："()()()()(())"
 解释：
 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。

 示例 3：
 输入："()()"
 输出：""
 解释：
 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 删除每个部分中的最外层括号后得到 "" + "" = ""。
 */
public class Solution01 {


    public void  removeOuterParentheses() {
        //题解：1、使用栈，( 入栈 ，) 出栈  ， 2、使用变量：( 加1 ) 减1
        String S = "(()())(())(()(()))" ;
        String result1 = removeOuterParentheses01(S);
        String result2 = removeOuterParentheses02(S);
        String result3 = removeOuterParentheses03(S);

    }

    //初始解法
    public String removeOuterParentheses01(String S) {
        char[] schar = S.toCharArray();
        int length = schar.length;
        if(length>10000){
            // array length too large ;
        }
        if(length ==0 ){
            return "";
        }
        StringBuilder result = new StringBuilder();
        Stack<Character> tempStack = new Stack<Character>();
        int start = 0 ;
        for(int i=0;i<length;i++){
            if(schar[i]=='('){
                tempStack.push(schar[i]);
            }else if(schar[i]==')'){
                if(!tempStack.isEmpty()){
                    tempStack.pop();
                }if(tempStack.isEmpty()){
                    if(i-1 != start){
                        result.append(S.substring(start+1,i));
                    }
                    start = i+1 ;
                }
            }else{
                //error input
            }
        }
        return result.toString();
    }

    public String removeOuterParentheses02(String S) {
        char[] schar = S.toCharArray();
        StringBuilder result = new StringBuilder();
        Stack<Character> tempStack = new Stack<Character>();
        for(char s:schar){
            if(s=='(') tempStack.push(s);
            if(tempStack.size()>1) result.append(s);
            if(s== ')') tempStack.pop();
        }
        return result.toString();
    }


    public String removeOuterParentheses03(String S) {
        char[] schar = S.toCharArray();
        StringBuilder result = new StringBuilder();
        int level = 0;
        for(char s:schar){
            if(s=='(') level++;
            if(s== ')') level--;
            if(level>1) result.append(s);
        }
        return result.toString();
    }
}
