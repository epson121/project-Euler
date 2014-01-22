=begin
Let d(n) be defined as the sum of proper divisors of n 
(numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an
 amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20,
22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 
284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
=end

@series = {1 => 0, 2 => 1, 3 => 1, 4 => 3}

# get d(n)
def get_divisors n
	sum = 0
	for i in 1..n/2
		if n % i == 0
			sum += i
		end
	end
	sum
end

def generate_ds
	for i in 1..10000-1
		if @series[i] == nil
			@series[i] = get_divisors(i)
		end
	end
end

def get_all_amicable
	sum = 0
	@visited = []
	@series.each do |k, v|
		k2 = @series[v]
		if k == k2 and k != v and @visited[k] != v
			p k
			p v
			p "======================="
			@visited[k] = v
			@visited[v] = k
			sum += k
			sum += v
		end
	end
	sum
end

generate_ds()
p get_all_amicable()
