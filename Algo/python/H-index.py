''' https://leetcode.com/problems/h-index/ '''

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        if not citations:
            return 0
        citations.sort(reverse=True)
        ln = len(citations)
        h = 0
        i = 0
        for i in range(1,ln):
            if citations[i] < citations[i-1]:
                if (h < i <= citations[i-1]):
                    h = i
            elif citations[i] == i:
                h = i
        if (citations[i] >= h) :
            if citations[i] > i:
                h = i+1
            else:
                h = citations[i]
        return h
