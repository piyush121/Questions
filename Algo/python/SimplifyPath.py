''' https://leetcode.com/problems/simplify-path/ '''

class Solution(object):
    def simplifyPath(self, path):
        """
        :type path: str
        :rtype: str
        """
        dirs = path.split("/")
        p = "/"
        for dir in dirs:
            #print dir, p
            if (dir == '') or (dir == '.'):
                continue
            if dir == '..':
                #print p, p.index('/',-1)
                p = p[:p.rindex('/')]
                if p == '':
                    p = '/'
                continue
            if p[-1] != '/':
                p += '/' + dir
            else:
                p += dir
        
        return p
