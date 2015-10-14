''' https://leetcode.com/problems/word-pattern/ '''

class Solution(object):
    def wordPattern(self, pattern, str):
        """
        :type pattern: str
        :type str: str
        :rtype: bool
        """
        dict = {}
        st = set()
        str = str.split()
        ln = len(str)
        if len(pattern) != ln:
            #print len(pattern), ln
            return False
        i = 0
        for c in pattern:
            if str[i] in dict:
                if dict[str[i]] != c:
                    return False
            else:
                if c in st:
                    return False
                else:
                    st.add(c)
                dict[str[i]] = c
            
            i += 1
        return True
