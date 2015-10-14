''' https://leetcode.com/problems/evaluate-reverse-polish-notation/ '''

class Solution(object):
    def evalRPN(self, tokens):
        """
        :type tokens: List[str]
        :rtype: int
        """
        num_stack = []
        for token in tokens:
            if token == '+':
                num2 = num_stack.pop()
                num1 = num_stack.pop()
                num_stack.append(num1 + num2)
            elif token == '-':
                num2 = num_stack.pop()
                num1 = num_stack.pop()
                num_stack.append(num1 - num2)
            elif token == '*':
                num2 = num_stack.pop()
                num1 = num_stack.pop()
                num_stack.append(num1 * num2)
            elif token == '/':
                num2 = num_stack.pop()
                num1 = num_stack.pop()
                num_stack.append(int(float(num1) / num2))
            else:
                num_stack.append(int(token))
            #print num_stack
        return int(num_stack[0])
