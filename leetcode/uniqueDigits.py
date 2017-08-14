from sets import Set

class Solution(object):
    def countNumbersWithUniqueDigits(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 0:
            return 1
        res = 10
        uniqueDigits = 9
        availableNumber = 9
        while n > 1 and availableNumber > 0:
            uniqueDigits *= availableNumber
            res += uniqueDigits
            n -= 1
            availableNumber -= 1
        return res