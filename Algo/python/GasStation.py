''' https://leetcode.com/problems/gas-station/ '''

class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        si = 0
        n = len(gas)
        while si < n and gas[si] < cost[si]:
            si += 1
        
        if si == n:
            return -1
        
        i = si + 1
        g = gas[si] - cost[si]
        while (i%n) != si:
            i = i % n
            g += gas[i]
            if g >= cost[i]:
                g -= cost[i]
            else:
                if si < i:
                    while i < n and gas[i] < cost[i]:
                        i += 1
                    if i == n:
                        return -1
                    g = gas[i] - cost[i]
                    si = i
                else:
                    break
            i += 1
            #print g, i
        if (i%n) == si:
            return si
        return -1
