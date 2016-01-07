from profilehooks import profile
from math import sqrt

class TwentySeven:

    @profile
    def is_prime(self, n):
        if n < 3 or n%2 == 0 or n%3 == 0 or n%5 == 0:
            return False
        for i in range(3, int(sqrt(n)+1)):
            if n % i == 0:
                return False
        return True

    @profile
    def do_calculation(self):
        max_a = 1
        max_b = 1
        max_n = 1

        #n2+an+b
        for a in range(-999, 1000):
            for b in range(-999, 1000):
                n = 0
                num = n*n + a*n + b
                while self.is_prime(num):
                    n += 1
                    num = n*n + a*n + b
                if n > max_n:
                    max_a = a
                    max_b = b
                    max_n = n

        print max_a * max_b
        #-59231

if __name__ == '__main__':
    instance = TwentySeven()
    print instance.do_calculation()