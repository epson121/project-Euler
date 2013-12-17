

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
