start = Time.now

@series = [0, 1, 2, 6]

def fact(n)
	@series[n]  ||= n * fact(n-1)
end

p fact(100).to_s.split("").map(&:to_i).inject(:+)

finish = Time.now - start
print (finish * 1000)
print "  ms"